package plugin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Timer;

import ui.Editor;


public class PluginFinder implements ActionListener{

	private Editor editor;
	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private List<String> files;

	private final static int DELAY = 2000;

	public PluginFinder(String dirPath) {
		editor = new Editor();
		filter = new PluginFilter();
		dir = new File(dirPath);
		files = new ArrayList<String>();
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void actionPerformed(ActionEvent e){
		String[] t = PluginFinder.this.dir.list(PluginFinder.this.filter);
		PluginFinder.this.files = java.util.Arrays.asList(t);

		for(int i=0 ; i<files.size() ; i++){
			if(!pluginAllreadyExists(files.get(i)))
				addAPlugin(files.get(i));
		}
	}

	private boolean pluginAllreadyExists(String name){
		JMenu tools = editor.getTools();
		int count = tools.getItemCount();
		for(int i=0 ; i<count ; i++){
			if(tools.getItem(i).getName().equals(name))
				return true;
		}
		return false;
	}

	public void addAPlugin(String file){
		String fileName = file.substring(0, file.length()-6);
		try {
			Class<?> classFile = Class.forName("plugin."+fileName);
			final Object object = classFile.newInstance();
			final Method transform = classFile.getMethod("transform", String.class);
			Method getLabel = classFile.getMethod("getLabel");
			String label = (String) getLabel.invoke(object);
			
			JMenuItem item = new JMenuItem(label);
			item.setName(file);
			
			item.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						editor.getInput().setText((String) transform.invoke(object, editor.getInput().getText()));
					} catch (Exception ex){
						ex.printStackTrace();
					}
				}
			});
			
			editor.getTools().add(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
