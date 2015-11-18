package main;

import java.util.List;

import plugin.PluginFinder;
import ui.Editor;

public class Main {

	public static void main(String[] args) {
		new Editor();
		List<String> files = new PluginFinder("/home/l3/lefebvreb/workspace/Plugins/src/plugin").getAllClassFiles();
		
		
		while (true);
	}
}
