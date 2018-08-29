import java.util.HashSet;
import java.util.Set;

public class Solution {

	public String predictPartyVictory(String string) {
		int n = string.length();
		int nRadiants = nRadiants(string);
		int nDires = nDires(string);
		int radiantsToBan = 0, diresToBan = 0;
		Set<Integer> radiantsBanned = new HashSet<Integer>();
		Set<Integer> diresBanned = new HashSet<Integer>();
		int pointer = 0;
		while(true) {
			if( radiantsBanned.size() == nRadiants )
				return "Dire";
			if( diresBanned.size() == nDires )
				return "Radiant";
			if( radiantsBanned.contains(pointer) 
					|| diresBanned.contains(pointer) ) 
			{
				pointer++;
				continue;
			}
			char c = string.charAt(pointer);
			switch(c) {
			case 'R':
				if(radiantsToBan>0) {
					radiantsToBan--;
					radiantsBanned.add(pointer++);
				} else {
					diresToBan++;
					pointer++;
				}
				break;
			case 'D':
				if(diresToBan>0) {
					diresToBan--;
					diresBanned.add(pointer++);
				} else {
					radiantsToBan++;
					pointer++;
				}
				break;
			default:
				break;
			}
			if(pointer==n)
				pointer=0;
		}
	}

	private int nDires(String string) {
		int ret = 0;
		for(char c : string.toCharArray()) {
			if(c=='D')
				ret++;
		}
		return ret;
	}

	private int nRadiants(String string) {
		int ret = 0;
		for(char c : string.toCharArray()) {
			if(c=='R')
				ret++;
		}
		return ret;
	}

}
