package ui;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugin.PluginFinder;


public class Editor extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menu;
	private JMenu file, tools, help;
	private JMenuItem changeDir, about;
	private JTextArea input;
	private JScrollPane scrollPane;
	
	public Editor() {
		file = new JMenu("File");
		tools = new JMenu("Tools");
		help = new JMenu("Help");
		
		changeDir = new JMenuItem("Change the plugins directory");
		changeDir.addActionListener(this);
		file.add(changeDir);
		
		menu = new JMenuBar();
		menu.add(file);
		menu.add(tools);
		menu.add(help);
		
		about = new JMenuItem("About Extendable Editor");
		about.addActionListener(this);
		help.add(about);
		
		input = new JTextArea();
		scrollPane = new JScrollPane(input);
		
		this.add(scrollPane);
		
		this.setSize(500, 250);
		this.setMinimumSize(new Dimension(150, 50));
		this.setLocationRelativeTo(null);
		this.setTitle("Extendable Editor");
		this.setJMenuBar(menu);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public JMenu getTools(){
		return tools;
	}
	
	public JTextArea getInput(){
		return input;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(about))
			JOptionPane.showMessageDialog(this, "This software was developed as part of a university project by:\n- Benjamin Lefebvre\n- Thibault Montois\nBoth students at University Lille 1.", "About : Extendable Editor", JOptionPane.INFORMATION_MESSAGE);
		if(e.getSource().equals(changeDir)){
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.showOpenDialog(this);
			String path = fileChooser.getSelectedFile().getPath();
			if(path != null)
				new PluginFinder(path);
		}
	}
}
