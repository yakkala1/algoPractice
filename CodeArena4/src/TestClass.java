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
		while( sc.hasNext() ) {
			Solution sol = new Solution();
			String line = sc.nextLine();
			if(line.equals("0"))
				return;
			String nR = sc.nextLine();
			int nRooms = Integer.parseInt(nR);
			System.out.println( sol.solve(line,nRooms) );
		}
	}

    static class Solution {
    	
		public int solve(String line, int nRooms) {
			int roomsAvailable = nRooms;
			Set<Character> inRooms = new HashSet<Character>();
			Set<Character> notStaying = new HashSet<Character>();
			for( char c : line.toCharArray() ) {
				if( inRooms.contains(c) ) {
					inRooms.remove(c);
					roomsAvailable++;
				} else {
					if(roomsAvailable > 0) {
						inRooms.add(c);
						roomsAvailable--;
					} else {
						notStaying.add(c);
					}
				}
			}
			return notStaying.size();
		}
		
    }

}
