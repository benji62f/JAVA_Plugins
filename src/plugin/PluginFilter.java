package plugin;
import java.io.File;
import java.io.FilenameFilter;


public class PluginFilter implements FilenameFilter {

	public boolean accept(File dir, String name) {
		if(name.toLowerCase().endsWith(".java"))
			return true;
		else
			return false;
	}

}
