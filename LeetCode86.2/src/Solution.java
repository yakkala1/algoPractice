import java.util.ArrayList;
import java.util.List;

class Solution {
	
    public List<Integer> splitIntoFibonacci(String S) {
        int n = S.length();
		if( n<3 )
        	return new ArrayList<Integer>();
        
		for(int firstLength=1; firstLength<=10 && firstLength<=n-2; firstLength++) {
			log("fl : "+firstLength);
			for(int secondLength=1; secondLength<=10 && firstLength+secondLength+1<=n; secondLength++) {
				log("sl : "+secondLength);
				List<Integer> ret = getFib(S,firstLength,secondLength);
				if(ret.size() != 0)
					return ret;
			}
		}
		
		return new ArrayList<Integer>();
    }

	private void log(Object string) {
		System.out.println(string);
	}

	private List<Integer> getFib(String s, int firstLength, int secondLength) {
		String first = s.substring(0,firstLength);
		String second = s.substring(firstLength,firstLength+secondLength);
		if( notValid(first) || notValid(second) )
			return new ArrayList<Integer>();
		List<Integer> ret = new ArrayList<Integer>();
		ret.add( Integer.parseInt(first) );
		ret.add( Integer.parseInt(second) );
		log(ret);
		int pointer = firstLength+secondLength;
		while( pointer<s.length() ) {
			int nextFib = getNextFib( ret );
			String nextFibStr = nextFib+"";
			if( pointer+nextFibStr.length()<=s.length() && nextFibStr.equals( s.substring(pointer,pointer+nextFibStr.length()) ) ) {
				pointer += nextFibStr.length();
				ret.add( nextFib );
			} else
				return new ArrayList<Integer>();
		}
		return ret;
	}

	private int getNextFib(List<Integer> ret) {
		int n = ret.size();
		int i1 = ret.get(n-2);
		int i2 = ret.get(n-1);
		return i1+i2;
	}

	private boolean notValid(String str) {
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException e) {
			return true;
		}
		if( str.length()>1 && str.charAt(0)=='0' )
			return true;
		else
			return false;
	}
	
}
