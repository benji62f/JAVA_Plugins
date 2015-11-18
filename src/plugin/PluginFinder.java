package plugin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;


public class PluginFinder {

	private PluginFilter filter;
	private Timer timer;
	private File dir;
	private List<String> files;
	
	private final static int DELAY = 2000;
	
	public PluginFinder(String dirPath) {
		filter = new PluginFilter();
		dir = new File(dirPath);
		files = new ArrayList<String>();
		timer = new Timer(DELAY, new MyActionListener());
		timer.start();
	}
	
	public List<String> getAllClassFiles(){
		return this.files;
	}
	
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String[] t = PluginFinder.this.dir.list(PluginFinder.this.filter);
			PluginFinder.this.files = java.util.Arrays.asList(t);
			
			for(int i=0 ; i<files.size() ; i++)
				System.out.println(files.get(i)+"\n");
		}
	}
	
}
