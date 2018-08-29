import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer,Node> map = new HashMap<Integer,Node>();
    Node head,tail;
    int capacity;
    
    public String toString() {
    	StringBuilder builder = new StringBuilder();
    	builder.append( map.toString()+"\n" );
    	builder.append( listString() );
    	return builder.toString();
    }
    
    private String listString() {
    	String str = "";
    	Node cur = head;
    	int counter = 0;
    	while( cur!=null ) {
    		if( counter++ > 100 )
    			return str;
    		str += (cur+"->");
    		cur = cur.next;
    	}
    	return str;
	}

	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if( map.containsKey(key) ) {
            Node node = map.get(key);
            remove(node);
            add( new Node(node.key,node.value) );
            return node.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if( map.containsKey(key) ) {
            remove( map.get(key) );
        }
        if(map.size() == capacity)
            remove(head);
        if( capacity!=0 ) {
            Node node = new Node(key,value);
            add(node);
        }
    }
    
    private void add(Node node) {
        if(node==null)
            return;
        map.put(node.key,node);
        if(tail!=null) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            head = node;
            tail = node;
        }
    }
    
    private void remove(Node node) {
        if(node==null)
            return;
        map.remove( node.key );
        Node prev = node.prev;
        Node next = node.next;
        if( prev!=null ) {
            prev.next = next;
        } else { //node is head
            head = next;
        }
        if( next!=null ) {
            next.prev = prev;
        } else { //node is tail
            tail = prev;
        }
    }
    
    class Node {
        public int key,value;
        public Node prev,next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
        	return String.format("[%d,%d]", key, value);
        }
    }
    
    class Logger {
    	public void log(Object obj) {
    		System.out.println(obj);
    	}
    }
    
}
