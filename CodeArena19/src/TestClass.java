import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		System.out.println( solve(S) );
	}

	private static String solve(String s) {
		String ret = "";
		int[] found = new int[26];
		for(char c : s.toCharArray()) {
			int ch = c-'a';
			if( found[ch]==0 ) {
				ret += c;
				found[ch] = 1;
			} else {
			}
		}
		return ret;
	}

}
