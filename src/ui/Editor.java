package ui;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Editor {

	JFrame window;
	JMenuBar menu;
	JMenu file, tool, help;
	JMenuItem toUpperCase, deleteVowels, cesarCode1, toLowerCase, cesarCode13;
	JTextArea input;
	JScrollPane scrollPane;
	
	public Editor() {
		toUpperCase = new JMenuItem("toUpperCase");
		toLowerCase = new JMenuItem("toLowerCase");
		deleteVowels = new JMenuItem("deleteVowels");
		cesarCode1 = new JMenuItem("cesarCode1");
		cesarCode13 = new JMenuItem("cesarCode13");
		
		file = new JMenu("File");
		tool = new JMenu("Tool");
		help = new JMenu("Help");
		
		tool.add(toLowerCase);
		tool.add(toUpperCase);
		tool.add(deleteVowels);
		tool.add(cesarCode1);
		tool.add(cesarCode13);
		
		menu = new JMenuBar();
		menu.add(file);
		menu.add(tool);
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
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Editor();
	}
}
