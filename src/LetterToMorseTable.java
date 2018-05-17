import java.util.HashMap;

public class LetterToMorseTable {
	
	public HashMap<Character, String> letterTranslator;
	
	public LetterToMorseTable() {
		
		letterTranslator = new HashMap<Character, String>();
		
		letterTranslator.put('a', ".-");
		letterTranslator.put('b', "-...");
		letterTranslator.put('c', "-.-.");
		letterTranslator.put('d', "-..");
		letterTranslator.put('e', ".");
		letterTranslator.put('f', "..-.");
		letterTranslator.put('g', "--.");
		letterTranslator.put('h', "....");
		letterTranslator.put('i', "..");
		letterTranslator.put('j', ".---");
		letterTranslator.put('k', "-.-");
		letterTranslator.put('l', ".-..");
		letterTranslator.put('m', "--");
		letterTranslator.put('n', "-.");
		letterTranslator.put('o', "---");
		letterTranslator.put('p', ".--.");
		letterTranslator.put('q', "--.-");
		letterTranslator.put('r', ".-.");
		letterTranslator.put('s', "...");
		letterTranslator.put('t', "-");
		letterTranslator.put('u', "..-");
		letterTranslator.put('v', "...-");
		letterTranslator.put('w', ".--");
		letterTranslator.put('x', "-..-");
		letterTranslator.put('y', "-.--");
		letterTranslator.put('z', "--..");
		
		
	}

}
