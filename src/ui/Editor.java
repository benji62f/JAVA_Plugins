package ui;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Editor {

	private JFrame window;
	private JMenuBar menu;
	private JMenu file, tools, help;
	private JTextArea input;
	private JScrollPane scrollPane;
	
	public Editor() {
		file = new JMenu("File");
		tools = new JMenu("Tools");
		help = new JMenu("Help");
		
		menu = new JMenuBar();
		menu.add(file);
		menu.add(tools);
		menu.add(help);
		
		input = new JTextArea();
		scrollPane = new JScrollPane(input);
		
		window = new JFrame();
		
		window.add(scrollPane);
		
		window.setSize(500, 250);
		window.setMinimumSize(new Dimension(150, 50));
		window.setLocationRelativeTo(null);
		window.setTitle("Extendable Editor");
		window.setJMenuBar(menu);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	public JMenu getTools(){
		return tools;
	}
	
	public JTextArea getInput(){
		return input;
	}
}
