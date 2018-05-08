
public class Solution {

	public int solve(int i, int j) {
		System.out.println(i+","+j);
		if(i<j)
			return solve(j,i);
		else if(i%j == 0)
			return j;
		else
			return solve(j,i%j);
	}

}