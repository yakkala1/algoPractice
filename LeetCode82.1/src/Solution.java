import java.util.Scanner;

public class Solution {
	
    public String toGoatLatin(String S) {
        Scanner sc = new Scanner(S);
        String ret = "";
        int index = 1;
        while(sc.hasNext()) {
        	String word = sc.next();
        	String goatWord = word;
        	if( isVowel(goatWord.charAt(0)) ) {
        		goatWord += "ma";
        	} else {
        		char firstChar = goatWord.charAt(0);
        		goatWord = goatWord.substring(1);
        		goatWord += firstChar;
        		goatWord += "ma";
        	}
        	for(int i=0; i<index; i++) {
        		goatWord += "a";
        	}
        	index++;
        	ret += goatWord + " ";
        }
        return ret.trim();
    }

	private boolean isVowel(char c) {
		switch(c) {
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			return true;
		default:
			return false;
		}
	}
    
}
