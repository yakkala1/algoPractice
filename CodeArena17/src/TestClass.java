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
		int N = sc.nextInt();
		sc.nextLine();
		List<Interval> intervals = new ArrayList<Interval>();
		for(int i=0; i<N; i++) {
			Interval interval = new Interval( sc.nextLine() );
			if( solve(intervals, interval) ) {
				System.out.println("Will need a moderator!");
				return;
			}
		}
		System.out.println("Who needs a moderator?");
	}

	private static boolean solve(List<Interval> intervals, Interval interval) {
		for(Interval prev : intervals) {
			if( interval.isOverlapping(prev) ) {
				return true;
			}
		}
		intervals.add(interval);
		return false;
	}

	private static void log(Object string) {
		System.out.println(string);
	}
	
	static class Time implements Comparable<Time>{
		int h,min;
		public Time(int h, int min) {
			this.h = h;
			this.min = min;
		}
		public Time(String string) {
			String[] params = string.split(":");
			this.h = Integer.parseInt(params[0]);
			this.min = Integer.parseInt(params[1]);
		}
		@Override
		public int compareTo(Time o) {
			if(this.h == o.h)
				return Integer.compare(this.min, o.min);
			else
				return Integer.compare(this.h, o.h);
		}
	}
	
	static class Interval {
		Time start,end;
		public Interval(Time start, Time end) {
			this.start = start;
			this.end = end;
		}
		public Interval(String line) {
			String[] times = line.split("-");
			this.start = new Time(times[0]);
			this.end = new Time(times[1]);
		}
		public boolean isOverlapping(Interval o) {
			if( this.start.compareTo(o.end)>=0 || this.end.compareTo(o.start)<=0 )
				return false;
			else
				return true;
		}
	}

}
