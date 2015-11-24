package plugin;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;


public class PluginFilter implements FilenameFilter {

	public boolean accept(File dir, String name) {
		return isAPlugin(name);
	}
	
	private boolean isAPlugin(String file){
		if(!file.toLowerCase().endsWith(".class"))
			return false;
		String fileName = file.substring(0, file.length()-6);
		try {
			Class<?> classFile = Class.forName("plugin."+fileName);
			if(!hasAConstructorWithoutParam(classFile))
				return false;
			if(!belongsToPlugin(classFile))
				return false;
			if(!extendsPlugin(classFile))
				return false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}

	private boolean hasAConstructorWithoutParam(Class<?> classFile){
		Constructor<?>[] constructors = classFile.getConstructors();
		for(int i=0 ; i<constructors.length ; i++){
			if(constructors[i].getParameterCount() == 0)
				return true;
		}
		return false;
	}
	
	private boolean belongsToPlugin(Class<?> classFile){
		return classFile.getPackage().getName().equals("plugin");
	}
	
	private boolean extendsPlugin(Class<?> classFile){
		return Plugin.class.isAssignableFrom(classFile);
	}
}
