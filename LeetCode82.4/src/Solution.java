import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


class Solution {
	int[][] grid;
	List<HashSet<Point>> connectedGroups;
	
    public int largestIsland(int[][] grid) {
    	this.grid = grid;
    	connectedGroups = getConnectedGroups();
    	int ret = 0;
    	for(Set<Point> group : connectedGroups) {
    		ret = Math.max(ret, group.size());
    	}
    	for(int i=0; i<grid.length; i++) {
    		for(int j=0; j<grid[0].length; j++) {
    			int points = 0;
    			if(grid[i][j] == 0) {
    				points += 1;
    				points += groupPoints(i-1,j);
    				points += groupPoints(i+1,j);
    				points += groupPoints(i,j-1);
    				points += groupPoints(i,j+1);
    			}
    			ret = Math.max(ret, points);
    		}
    	}
    	return ret;
    }
    
    private List<HashSet<Point>> getConnectedGroups() {
    	List<HashSet<Point>> groups = new ArrayList<HashSet<Point>>();
    	Set<Point> unvisited = new HashSet<Point>();
    	for(int i=0; i<grid.length; i++) {
    		for(int j=0; j<grid[0].length; j++) {
    			Point point = new Point(i,j);
    			unvisited.add(point);
    		}
    	}
    	while( !unvisited.isEmpty() ) {
    		Iterator<Point> iterator = unvisited.iterator();
			Point pt = iterator.next();
			while(iterator.hasNext()) {
				iterator.next();
			}
    		unvisited.remove(pt);
    		if( grid[pt.x][pt.y]==0 )
    			continue;
    		else {
    			HashSet<Point> group = new HashSet<Point>();
    			group.add(pt);
    			dfs(pt, group, unvisited);
    			groups.add(group);
    		}
    	}
    	return groups;
	}

	private void dfs(Point point, HashSet<Point> group, Set<Point> unvisited) {
		List<Point> neighbours = getValidNeighbours(point,unvisited);
		for(Point pt : neighbours) {
			group.add(point);
            unvisited.remove(pt);
			dfs(pt, group, unvisited);
		}
	}

	private List<Point> getValidNeighbours(Point pt, Set<Point> unvisited) {
		List<Point> neighbours = new ArrayList<Point>();
		int i = pt.x;
		int j = pt.y;
		if( isValid(i-1,j) )
			neighbours.add(new Point(i-1, j));
		if( isValid(i+1,j) )
			neighbours.add(new Point(i+1, j));
		if( isValid(i,j-1) )
			neighbours.add(new Point(i, j-1));
		if( isValid(i,j+1) )
			neighbours.add(new Point(i, j+1));
		
		List<Point> ret = new ArrayList<Point>();
		for(Point p : neighbours) {
			if( unvisited.contains(p) && grid[p.x][p.y]==1) {
				ret.add(p);
			}
		}
		
		return neighbours;
	}

	private boolean isValid(int i, int j) {
		if(
				i<0 || j<0
				|| i>=grid.length
				|| j>=grid[0].length
				) {
			return false;
		}
		return true;
	}

	private int groupPoints(int i, int j) {
    	if(
    			i<0 || j<0
    			|| i>=grid.length
    			|| j>=grid[0].length
    			) 
    	{
    		return 0;
    	}
    	if(grid[i][j] == 0)
    		return 0;
    	for(Set<Point> group : connectedGroups) {
    		if(group.contains( new Point(i,j) )) {
    			return group.size();
    		}
    	}
    	return 0;
	}

	static class Point {
    	public int x,y;
    	public Point(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	@Override
    	public boolean equals(Object obj) {
    		Point other = (Point)obj;
    		return this.x==other.x
    				&& this.y==other.y;
    	}
    	@Override
    	public int hashCode() {
    		int result = 17;
            result = 31 * result + Integer.hashCode(x);
            result = 31 * result + Integer.hashCode(y);
            return result;
    	}
    }

}