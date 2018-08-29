import java.util.ArrayList;
import java.util.List;

class Solution {
	
    public boolean buddyStrings(String A, String B) {
        if(A.length()!=B.length())
        	return false;
        else if(A.equals(B)) {
        	if( sameCharecterExists(A) )
        		return true;
        	else
        		return false;
        } else {
        	return checkNormalCase(A,B);
        }
    }
	
    
	private boolean checkNormalCase(String A, String B) {
		ArrayList<Integer> diffIndices = new ArrayList<Integer>();
		for(int i=0; i<A.length(); i++) {
			if(A.charAt(i) != B.charAt(i)) {
				diffIndices.add(i);
			}
		}
		if(diffIndices.size()!=2)
			return false;
		int firstIndex = diffIndices.get(0);
		int secondIndex = diffIndices.get(1);
		return A.charAt(firstIndex)==B.charAt(secondIndex) && A.charAt(secondIndex)==B.charAt(firstIndex);
	}


	private boolean sameCharecterExists(String A) {
		int[] counts = new int[26];
		for(char c:A.toCharArray()) {
			int cint = c-'a';
			if( counts[cint]==0 )
				counts[cint] = 1;
			else if( counts[cint]==1 )
				return true;
		}
		return false;
	}


	public void log(Object obj) {
		System.out.println(obj);
	}
	
}
