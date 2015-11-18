package plugin;

public class ToLowerCase implements Plugin {

	public String transform(String s) {
		return s.toLowerCase();
	}

	public String getLabel() {
		return "To lower case";
	}

}
