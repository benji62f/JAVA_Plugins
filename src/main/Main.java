package main;

import plugin.PluginFinder;

public class Main {
	
	public static void main(String[] args) {
		new PluginFinder(System.getProperty("java.class.path")+"/plugin");
	}
}
