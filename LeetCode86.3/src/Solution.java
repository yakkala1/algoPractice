import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
	
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	int size = rooms.size();
        Set<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited.add(0);
        queue.add(0);
        while( !queue.isEmpty() ) {
            int s = queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i = rooms.get(s).listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited.contains(n))
                {
                	visited.add(n);
                    queue.add(n);
                    if( visited.size() == size )
                    	return true;
                }
            }
        }
        return (visited.size()==size);
    }

}
