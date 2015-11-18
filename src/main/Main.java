package main;

import plugin.PluginFinder;
import ui.Editor;

public class Main {
	
	public static void main(String[] args) {
		Editor editor = new Editor();
		new PluginFinder(System.getProperty("java.class.path")+"/plugin", editor).getAllClassFiles();
	}
}
