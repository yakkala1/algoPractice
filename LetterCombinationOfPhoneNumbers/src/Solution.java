import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	private static final Map<Character,String> map;
	static {
		map = new HashMap<Character,String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
	}
	
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if( digits.isEmpty() )
        	return ret;
		if( digits.length() == 1 ) {
			char digit = digits.charAt(0);
        	String correspondingDigits = map.get(digit);
        	for(Character c : correspondingDigits.toCharArray()) {
        		ret.add(c.toString());
        	}
        }
        char firstDigit = digits.charAt(0);
        List<String> subResult = letterCombinations(digits.substring(1));
        char[] possibleFirstChar = map.get(firstDigit).toCharArray();
        for(char firstChar : possibleFirstChar) {
        	for(String remainingChars : subResult) {
        		String permutation = firstChar + remainingChars;
        		ret.add(permutation);
        	}
        }
        return ret;
    }
}