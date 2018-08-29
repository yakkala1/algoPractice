import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
	private static final int CLOSE = -1;
	private static final int OPEN = -2;
	private static final Map<Character,Integer> map = new HashMap<Character,Integer>();
	static {
		map.put('(', OPEN);
		map.put(')', CLOSE);
	}
	
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<Integer>();
        for(char c:S.toCharArray()) {
        	if( c=='(' )
        		stack.add( OPEN );
        	else {
        		int score = 0;
        		while( !stack.empty() ) {
        			int latest = stack.pop();
        			if( latest>=0 )
        				score+=latest;
        			else {
        				if(score==0)
        					score = 1;
        				else
        					score = 2*score;
        				stack.add(score);
        				break;
        			}
        		}
        	}
        }
        int ret = 0;
        while( !stack.empty() )
        	ret += stack.pop();
        return ret;
    }

	public void log(Object obj) {
		System.out.println(obj);
	}
	
}
