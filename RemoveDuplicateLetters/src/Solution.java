import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	Map<Integer,Integer> ret = new HashMap<Integer,Integer>();
	List<List<Integer>> lists;
	Map<Character,Integer> leastContaining;
	
	public String removeDuplicateLetters(String string) {
		Map<Character,List<Integer>> listRep = new HashMap<Character,List<Integer>>();
		List<Character> chars = new ArrayList<Character>();
		for(int i=0; i<string.length(); i++) {
			char c = string.charAt(i);
			if(!listRep.containsKey(c)) {
				chars.add(c);
				listRep.put(c , new ArrayList<Integer>());
			}
			listRep.get(c).add(i);
		}
		Collections.sort(chars);
		
		LinkedList<Integer> indicesAdded = new LinkedList<Integer>();
		for(int i=0; i<chars.size(); i++) {
			char c = chars.get(i);
			List<Integer> listForChar = listRep.get(c);
		}
	}

//	public String removeDuplicateLetters(String string) {
//		getLists(string);
//		getGreatestContaining(string);
//		getLex(0,0);
//		return computeSol();
//	}
//
//	private void getLeastContaining(String string) {
//		
//	}
//
//	private void getLists(String string) {
//		lists = new ArrayList<List<Integer>>();
//		for(int i=0; i<26; i++)
//			lists.add( new LinkedList<Integer>() );
//		for(int i=0; i<string.length(); i++) {
//			char c = string.charAt(i);
//			int charInt = c-'a';
//			lists.get(charInt).add(i);
//		}
//	}
//
//	private void getLex(int row, int fromCol) {
//		int fromIndex = getLeastIndexContainingAllBelow(row, fromCol);
//		if( fromIndex == -1 ) {
//			ret.put( row,leastIndex(row,fromCol) );
//			getLex(row+1, fromCol);
//		} else {
//			ret.put(row,fromIndex);
//			getLex(row+1,fromIndex+1);
//		}
//	}

}
