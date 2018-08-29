import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> fallingSquares(int[][] positions) {
    	List<Square> squares = new ArrayList<Square>();
    	List<Integer> ret = new ArrayList<Integer>();
    	int maxHeight = 0;
    	for(int i=0; i<positions.length; i++) {
    		log("---------------");
    		log("i : "+i);
    		int from = positions[i][0];
    		int length = positions[i][1];
    		int to = from+length;
    		log("from : "+from);
    		log("to : "+to);
    		int baseHeight = 0;
    		for( int j=0; j< squares.size(); j++) {
    			Square square = squares.get(j);
    			log(square);
				if( overlapping(from,to,square) )
    				baseHeight = Math.max(baseHeight,square.height);
				log("baseHeight : "+baseHeight);
    		}
    		int height = baseHeight+length;
			squares.add( new Square(from,to,height) );
			maxHeight = Math.max(height, maxHeight);
			ret.add( maxHeight );
			log("ret : "+ret);
			log(squares);
    	}
    	return ret;
    }

	private boolean overlapping(int from, int to, Square square) {
		if( from>=square.to || square.from>=to )
			return false;
		else
			return true;
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}
    
}

class Square {
	int from,to,height;
	public Square(int from, int to, int height) {
		this.from = from;
		this.to = to;
		this.height = height;
	}
	@Override
	public String toString() {
		return String.format("SQ{%d,%d,%d}", from, to, height);
	}
}