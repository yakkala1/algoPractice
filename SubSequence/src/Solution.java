
public class Solution {

	public boolean isSubsequence(String sequence, String string) {
		int i=0,j=-1;
		for(i=0; i<sequence.length(); i++) {
			char c = sequence.charAt(i);
			j++;
			while( j<string.length()  &&  string.charAt(j) != c ) {
				j++;
			}
			if( j>=string.length() )
				return false;
		}
		return true;
	}

}
