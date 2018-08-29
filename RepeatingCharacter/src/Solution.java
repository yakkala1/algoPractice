import java.util.HashMap;
import java.util.Map;

class Solution {
	
    public int lengthOfLongestSubstring(String s) {
        int from = 0;
        int to = 0;
        String ret = "";
        Map<Character,Integer> positions = new HashMap<Character,Integer>();
        for(; to<s.length(); to++) {
        	char toChar = s.charAt(to);
        	if( positions.containsKey(toChar) ) {
        		if( ret.length() < to-from )
        			ret = s.substring(from,to);
        		int newFrom = positions.get(toChar)+1;
        		for(; from<newFrom; from++) {
        			positions.remove( s.charAt(from) );
        		}
        	}
        	positions.put(toChar,to);
        }
        if( positions.size()>ret.length() )
        	return positions.size();
        return ret.length();
    }

}
