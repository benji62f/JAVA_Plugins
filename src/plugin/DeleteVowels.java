package plugin;

public class DeleteVowels implements Plugin {

	public String transform(String s) {
		String vowelLess = "";
		char current;
		for(int i=0 ; i<s.length() ; i++){
			current = s.charAt(i);
			if(current != 'a' && current != 'e' && current != 'i' && current != 'o' && current != 'u' && current != 'y' && current != 'A' && current != 'E' && current != 'I' && current != 'O' && current != 'U' && current != 'Y')
				vowelLess += current;
		}
		return vowelLess;
	}

	public String getLabel() {
		return "Delete vowels";
	}

}
