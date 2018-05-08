import java.util.*;

public class Solution {

	public Integer[] search(String word, String text) {
		List<Integer> ret = new ArrayList<Integer>();
		int wordLength = word.length();
		Logger.log("wL : "+wordLength);
		if(text.length()<word.length())
			return ret.toArray(new Integer[0]);
		HashCalculator hc = new HashCalculator(wordLength);
		int wordHash = hc.hash(word);
		Logger.log("wh : "+wordHash);
		int hash = hc.hash(text.substring(0,wordLength));
		if( hash==wordHash && word.equals(text.substring(0,wordLength)) )
			ret.add(0);
		int prevHash = hash;
		for(int i=1; i+wordLength-1<text.length(); i++) {
			hash = hc.hash(prevHash,
					text.charAt(i-1),
					text.charAt(i+wordLength-1));
			Logger.log("i : "+i);
			if( hash==wordHash && word.equals( text.substring(i,i+wordLength) ) )
				ret.add(i);
			prevHash = hash;
			Logger.log("i : "+i);
			Logger.log("hash : "+hash);
		}
		return ret.toArray(new Integer[0]);
	}

}

class HashCalculator {
	static final int PRIME = 31;
	static final int MAX = 100001;
	private int n;
	public HashCalculator(int n) {
		this.n = n;
	}
	public int hash(String str) {
		long ret = 0;
		for(int i=0; i<n; i++) {
			ret = str.charAt(i) + (ret*PRIME)%MAX;
			ret = ret%MAX;
		}
		return Integer.parseInt( ret+"" );
	}
	public int hash(int prevHash, char removing, char adding) {
		long hash = prevHash;
		hash = hash - (removing*modPower(PRIME,n-1))%MAX;
		hash = (hash*PRIME)%MAX;
		hash = (hash+adding)%MAX;
		if(hash<0)
			hash = -hash;
		return Integer.parseInt( hash+"" );
	}
	private long modPower(int a, int b) {
		if(b==1) {
			return a%MAX;
		} else if(b%2 == 0) {
			long temp = modPower(a,b/2);
			return (temp*temp)%MAX;
		} else {
			return (modPower(a,b-1)*a)%MAX;
		}
	}
}

class Logger {
	public static void log(Object obj) {
		System.out.println(obj);
	}
}