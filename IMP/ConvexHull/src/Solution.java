import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/convex-hull/0
 * */
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1; i<=T; i++) {
			int N = sc.nextInt();
			List<Point> points = new ArrayList<Point>();
			for(int j=0; j<N; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				points.add( new Point(x,y) );
			}
			List<Point> ans = solve(points);
			print(i, ans);
		}
		sc.close();
	}

	private static void print(int i, List<Point> ans) {
		Iterator<Point> iterator = ans.iterator();
		System.out.println("Case #"+i);
		while(iterator.hasNext()) {
			Point p = iterator.next();
			System.out.println(p.x+" "+p.y);
		}
	}

	private static List<Point> solve(List<Point> points) {
		Point p = Collections.min(points, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				int compY = Integer.compare(p1.x, p2.x);
				if(compY != 0)
					return compY;
				else 
					return Integer.compare(p1.y, p2.y);
			}
		});
		Logger.log("min point : "+p);
		sortWithSlope(points, p);
		points = removeDuplicatesInSorted(points);
		Logger.log("points sorted : "+points);
		Stack<VectorAndPoint> stack = new Stack<VectorAndPoint>();
		for(Point q : points) {
			Logger.log("q : "+q);
			if(q == p) {
				continue;//skip
			}
			while(true) {
				if(stack.isEmpty()) {
					Vector v = new Vector(p,q);
					stack.push( new VectorAndPoint(v,q) );
					break;
				} else {
					VectorAndPoint prev = stack.peek();
					Logger.log("prev : "+prev);
					long crossP = prev.v.crossProduct( new Vector(prev.p,q) );
					Logger.log("crossP : "+crossP);
					if(crossP > 0) {//left turn
						Vector v = new Vector(prev.p,q);
						stack.push( new VectorAndPoint(v,q) );
						break;
					} else {
						stack.pop();
					}
				}
			}
		}
		Stack<Point> reversedStack = new Stack<Point>();
		while(!stack.isEmpty()) {
			reversedStack.add(stack.pop().p);
		}
		List<Point> ret = new ArrayList<Point>();
		ret.add(p);
		while(!reversedStack.isEmpty()) {
			ret.add( reversedStack.pop() );
		}
		return ret;
	}

	private static List<Point> removeDuplicatesInSorted(List<Point> points) {
		List<Point> ret = new ArrayList<Point>();
		ret.add(points.get(0));
		for(Point p : points) {
			if(p != ret.get(ret.size()-1)) {
				ret.add(p);
			}
		}
		return ret;
	}

	private static void sortWithSlope(List<Point> points, Point p) {
		Logger.log("sort with slope");
		Collections.sort(points, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				if(p1==p2)
					return 0;
				if(p1==p)
					return 1;
				else if(p2==p)
					return -1;
				else {
					long y1 = p1.y-p.y;
					long x1 = p1.x-p.x;
					long y2 = p2.y-p.y;
					long x2 = p2.x-p.x;
					Slope s1 = new Slope(x1,y1);
					Slope s2 = new Slope(x2,y2);
					int comp = s1.compareTo(s2);
					if(comp!=0) {
						return comp;
					} else {
						return Integer.compare(
								Math.abs(p1.x+p1.y-p.x-p.y), 
								Math.abs(p2.x+p2.y-p.x-p.y));
					}
				}
			}
		});
	}

}

class Point {
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int x,y;
	@Override
	public boolean equals(Object obj) {
		Point o = (Point)obj;
		return x==o.x && y==o.y;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}

class Vector {
	public long x,y;
	public Vector(Point p1, Point p2) {
		x = p2.x-p1.x;
		y = p2.y-p1.y;
	}
	public long crossProduct(Vector other) {
		Logger.log("crossP");
		Logger.log("this : "+this);
		Logger.log("other : "+other);
		return this.x*other.y - this.y*other.x;
	}
	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
}

class VectorAndPoint {
	public Vector v;
	public Point p;

	public VectorAndPoint(Vector v, Point p) {
		this.v = v;
		this.p = p;
	}
	@Override
	public String toString() {
		return "v:"+v+" p:"+p;
	}
}

class Logger {
	//static OutputStream stream;
	static {
//		try {
//			stream = new FileOutputStream(new File("/tmp/t"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}
	public static void log(Object obj) {
//		try {
//			stream.write( obj.toString().getBytes() );
//			stream.write("\n".getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}

class Slope implements Comparable<Slope> {
	long x,y;
	public Slope(long x, long y) {
		this.x = x;
		this.y = y;
		if(x==0) {
			this.y = (y>0) ? Integer.MAX_VALUE : -Integer.MAX_VALUE;
			this.x = 1;
		}
	}
	@Override
	public int compareTo(Slope o) {
		return Long.compare(this.y*o.x, o.y*this.x);
	}
}