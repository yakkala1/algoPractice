import java.util.ArrayList;
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
	static int[] mem = new int[10000+1];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=0; t<T; t++) {
			String ret = "";
			String str = sc.nextLine();
			for(int i=0; i<str.length(); i++) {
				ret = ret + str.charAt( str.length()-1-i );
			}
			System.out.println( ret );
		}
	}

	private static void log(Object string) {
		System.out.println(string);
	}

}

