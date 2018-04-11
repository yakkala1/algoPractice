package triangleDp;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<List<Integer>> minPaths,triangle;
	
	public int minimumTotal(List<List<Integer>> triangle) {
		this.triangle = triangle;
		this.minPaths = new ArrayList<List<Integer>>();
		int n = triangle.size();
		if(n==0)
			return 0;
		
		for(int i=0; i<n; i++) {
			List<Integer> minPathArray = new ArrayList<Integer>();
			for(int j=0; j<=i; j++) {
				int minPath = calculateMinPath(i,j);
				minPathArray.add(minPath);
			}
			minPaths.add(minPathArray);
		}
		return min(minPaths.get(n-1));
	}

	private int min(List<Integer> list) {
		int min = list.get(0);
		for(int element:list)
			min = Math.min(min, element);
		return min;
	}

	private int calculateMinPath(int i, int j) {
		if(i==0)
			return triangle.get(0).get(0);
		int value = triangle.get(i).get(j);
		List<Integer> previousMinPathArray = minPaths.get(i-1);
		if(j==0)
			return previousMinPathArray.get(j)+value;
		else if(j==i)
			return previousMinPathArray.get(j-1)+value;
		else
			return Math.min(previousMinPathArray.get(j), previousMinPathArray.get(j-1))+value;
	}

}
