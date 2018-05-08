
public class Solution {

	public String solve(int i) {
		if(i==0)
			return "0";
		else if(i==1)
			return "1";
		else
			return solve(i/2)+(i%2);
	}

}
