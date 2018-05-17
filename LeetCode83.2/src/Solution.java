import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public String maskPII(String S) {
		if(S.contains("@")) {
			return maskEmail(S);
		} else {
			return maskPh(S);
		}
	}

	private String maskEmail(String S) {
		int atI = S.indexOf('@');
		int dotI = S.indexOf('.');
		String name1 = S.substring(0, atI).toLowerCase();
		String name2 = S.substring(atI+1,dotI).toLowerCase();
		String name3 = S.substring(dotI+1).toLowerCase();
		name1 = maskName(name1);
		return name1+"@"+name2+"."+name3;
	}

	private String maskName(String name) {
		return name.charAt(0)+"*****"+name.charAt(name.length()-1);
	}

	private String maskPh(String s) {
		int nDigits = nDigits(s);
		if(nDigits>10)
			return maskBigPh(s,nDigits);
		else 
			return maskLocalPh(s);
	}

	private int nDigits(String s) {
		int nDigits = 0;
		for(char c : s.toCharArray()) {
			switch(c) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				nDigits++;
				break;
			default:
				break;
			}
		}
		return nDigits;
	}

	private String maskBigPh(String s, int nDigits) {
		List<Character> last4 = getLast4(s);
		String ret = "";
		switch(nDigits) {
		case 13:
			ret  = "+***-***-***-";
			break;
		case 12:
			ret  = "+**-***-***-";
			break;
		case 11:
			ret  = "+*-***-***-";
			break;
		default:
			break;
		}
		for(char c : last4) {
			ret += c;
		}
		return ret;

	}

	private String maskLocalPh(String s) {
		List<Character> last4 = getLast4(s);
		String ret = "***-****-";
		for(char c : last4) {
			ret += c;
		}
		return ret;
	}

	private List<Character> getLast4(String s) {
		List<Character> ret = new ArrayList<Character>();
		for(int i=s.length()-1; i>=0; i--) {
			char c = s.charAt(i);
			if( Character.isDigit(c) ) {
				ret.add(c);
			}
			if(ret.size() == 4)
				break;
		}
		Collections.reverse(ret);
		return ret;
	}

}
