package plugin;

public class ToUpperCase implements Plugin {

	public String transform(String s) {
		return s.toUpperCase();
	}

	public String getLabel() {
		return "To upper case";
	}

}
