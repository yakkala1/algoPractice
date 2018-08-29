import java.util.*;

class Solution {
	int p,q;
	static final int NORTH = 1;
	static final int SOUTH = 2;
	static final int EAST = 3;
	static final int WEST = 4;
	static Point p0,p1,p2;
	
    public int mirrorReflection(int p, int q) {
    	if( q==0 )
    		return 0;
    	Point start = new Point(0,0);
        this.p = p;
        this.q = q;
        p0 = new Point(p,0);
        p1 = new Point(p,p);
        p2 = new Point(0,p);
        PointAndSlope ray = new PointAndSlope(start,p,q);
        while(true) {
        	ray = process( ray);
        	if(ray.point.equals(p0))
        		return 0;
        	if(ray.point.equals(p1))
        		return 1;
        	if(ray.point.equals(p2))
        		return 2;
        }
    }
    
    private PointAndSlope process(PointAndSlope ray) {
    	Point start = ray.point;
    	int vx = ray.vx;
    	int vy = ray.vy;
    	
    	int nd = p-start.y;
    	int sd = 0-start.y;
    	int ed = p-start.x;
    	int wd = 0-start.x;
    	
    	double timeTaken = Integer.MAX_VALUE;
    	int nextX=0,nextY=0;
    	int wallHit;
    	int nextVx=0, nextVy=0;
    	if( nd!=0 && sameSign(nd,vy) ) {
    		double nt = getTime(nd,vy);
    		if( nt<timeTaken ) {
    			timeTaken = nt;
    			nextX = start.x+mmd(nd,vx,vy);
    			nextY = p;
    			wallHit = NORTH;
    			nextVx = vx;
    			nextVy = -vy;
    		}
    	}
    	if( sd!=0 && sameSign(sd,vy) ) {
    		double st = getTime(sd,vy);
    		if( st<timeTaken ) {
    			timeTaken = st;
    			nextX = start.x+mmd(sd,vx,vy);
    			nextY = 0;
    			wallHit = SOUTH;
    			nextVx = vx;
    			nextVy = -vy;
    		}
    	}
    	if( ed!=0 && sameSign(ed,vx) ) {
    		double et = getTime(ed,vx);
    		if( et<timeTaken ) {
    			timeTaken = et;
    			nextX = p;
    			nextY = start.y+mmd(ed,vy,vx);
    			wallHit = EAST;
    			nextVx = -vx;
    			nextVy = vy;
    		}
    	}
    	if( wd!=0 && sameSign(wd,vx) ) {
    		double wt = getTime(wd,vx);
    		if( wt<timeTaken ) {
    			timeTaken = wt;
    			nextX = 0;
    			nextY = start.y+mmd(wd,vy,vx);
    			wallHit = WEST;
    			nextVx = -vx;
    			nextVy = vy;
    		}
    	}
    	
    	Point nextPoint = new Point(nextX,nextY);
    	return new PointAndSlope(nextPoint, nextVx, nextVy);
	}

	private int mmd(int n1, int n2, int d) {
		return (n1*n2)/d;
	}

	private double getTime(int d, int v) {
		return (double)d/(double)v;
	}

	private boolean sameSign(int nd, int vy) {
		return nd*vy>0;
	}

	class Point {
    	public int x,y;
    	public Point(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	@Override
    	public boolean equals(Object o) {
    		Point other = (Point)o;
    		return this.x==other.x && this.y==other.y;
    	}
    }
    
    class PointAndSlope {
    	public Point point;
    	public int vx,vy;
    	public PointAndSlope(Point p, int vx, int vy) {
    		this.point = p;
    		this.vx = vx;
    		this.vy = vy;
    	}
    }
    
}