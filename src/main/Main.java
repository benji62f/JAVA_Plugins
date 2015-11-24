package main;

import plugin.PluginFinder;

public class Main {

	private static String dirPath = System.getProperty("java.class.path");
	private static String pluginsPackage = "plugin";
	
	public static void main(String[] args) {
		String[] paths = dirPath.split(";");
		new PluginFinder(paths[0] + "/" + pluginsPackage);
	}
}
