import java.util.*;


class Solution {
	
    public String convert(String s, int numRows) {
    	if(numRows==1)
    		return s;
        List<String> list = new ArrayList<String>();
        for(int i=0; i<numRows; i++) {
        	list.add("");
        }
        int index = -1;
        boolean increment = true;
        for(char c : s.toCharArray()) {
        	
        	if(increment)
        		index++;
        	else
        		index--;
        	
        	if(index<0) {
        		increment = true;
        		index+=2;
        	} else if(index>=numRows) {
        		increment = false;
        		index-=2;
        	}
        	
        	list.set(index , list.get(index)+c);
        	
        }
        String ret = "";
        for(String str : list) {
        	ret += str;
        }
        return ret;
    }
    
}