import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
	
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<Integer>> anagramIndices = new HashMap<String,List<Integer>>();
        for(int i=0; i<strs.length; i++) {
        	String str = strs[i];
        	String sortedString = sortedString(str);
        	if( anagramIndices.containsKey(sortedString) ) {
        		anagramIndices.get(sortedString).add(i);
        	} else {
        		anagramIndices.put(sortedString, new ArrayList<Integer>());
        		anagramIndices.get(sortedString).add(i);
        	}
        }
        
        List<List<String>> ret = new ArrayList<List<String>>();
        for(List<Integer> indices : anagramIndices.values()) {
        	List<String> anagrams = new ArrayList<String>();
        	for(int index : indices) {
        		anagrams.add( strs[index] );
        	}
        	ret.add(anagrams);
        }
        return ret;
    }

	private String sortedString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort( charArray );
		String ret = "";
		for(char c : charArray) 
			ret += c;
		return ret;
	}

}
