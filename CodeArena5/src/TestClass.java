import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;

public class TestClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0; t<T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			Solution sol = new Solution();
			int ret = 0;
			for(int i=A; i<=B; i++) {
				if( sol.isPalindrome(i+"") ) {
					ret++;
				}
			}
			System.out.println(ret);
		}
	}

    static class Solution {
		public boolean isPalindrome(String N) {
			int nDigits = N.length();
			for(int i=0; i<nDigits; i++) {
				if( N.charAt(i) != N.charAt(nDigits-1-i) )
					return false;
			}
			return true;
		}

    }

}
