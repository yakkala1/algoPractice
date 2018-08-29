import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MyCalendarTwo {
	Schedule schedule1,schedule2;
    public MyCalendarTwo() {
    	schedule1 = new Schedule();
    	schedule2 = new Schedule();
    }
    public boolean book(int start, int end) {
    	end = end-1;
    	Interval interval = new Interval(start,end);
    	Logger.log("book : "+interval);
    	Schedule overlap1 = schedule1.overlap(interval);
    	Logger.log("overlap1 : "+overlap1);
		Schedule overlap2 = overlap1.overlap(schedule2);
    	Logger.log("overlap2 : "+overlap2);
		if( !overlap2.isEmpty() ) {
    		Logger.log("double overlap : returning false");
    		return false;
    	} else {
    		schedule1.merge( interval );
    		schedule2.merge( overlap1 );
    		schedule1.normalize();
    		schedule2.normalize();
    		return true;
    	}
    }
	private void log(Object obj) {
		//System.out.println(obj);
	}
	@Override
	public String toString() {
		return schedule1+"; "+schedule2;
	}
}

class Interval {
	int start,end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public boolean overlaps(Interval other) {
		if( this.start>other.end && this.end>other.end )
			return false;
		else if( this.start<other.start && this.end<other.start )
			return false;
		else
			return true;
	}
	public Interval overlap(Interval other) {
		if( overlaps(other) )
			return new Interval(
				Math.max(this.start,other.start),
				Math.min(this.end, other.end)
				);
		else
			return new Interval(0,0);
	}
	public void mergeOverlappingInterval(Interval other) {
		log("merging intervals : "+this+" : "+other);
		this.start = Math.min(this.start,other.start);
		this.end = Math.max(this.end, other.end);
	}
	@Override
	public String toString() {
		return "("+start+","+end+")";
	}
	private void log(Object obj) {
		Logger.log("\t"+obj);
	}
}

class Schedule {
	List<Interval> list;
	public Schedule() {
		list = new ArrayList<Interval>();
	}
	public void normalize() {
		List<Interval> newList = new ArrayList<Interval>();
		for( Interval interval : list ) {
			if( newList.size()>0 ) {
				Interval lastInterval = newList.get( newList.size()-1 );
				if( lastInterval.end+1 == interval.start ) {
					lastInterval.end = interval.end;
					continue;
				}
			}
			newList.add( interval );
		}
		this.list = newList;
	}
	public Schedule overlap(Interval interval) {
		Schedule schedule = new Schedule();
		schedule.append(interval);
		return overlap(schedule);
	}
	public Schedule overlap(Schedule schedule) {
		log("overlap of schedules");
		log("this : "+this);
		log("other : "+schedule);
		Schedule overlap = new Schedule();
		int i1=0,i2=0;
		List<Interval> list1,list2;
		list1 = this.list;
		list2 = schedule.getList();
		while( i1<list1.size() && i2<list2.size() ) {
			Interval int1 = list1.get(i1);
			Interval int2 = list2.get(i2);
			log("int1 : "+int1);
			log("int2 : "+int2);
			if( int1.overlaps(int2) ) {
				log("overlapping");
				overlap.append( int1.overlap(int2) );
			}
			if( int1.end < int2.end )
				i1++;
			else if( int1.end > int2.end )
				i2++;
			else {
				i1++;
				i2++;
			}
			log("overlap : "+overlap);
		}
		return overlap;
	}
	public void merge(Schedule schedule) {
		log("merging of schedules : "+this+" : "+schedule);
		Schedule merged = new Schedule();
		List<Interval> sortedIntervals = getIntervalsSortedByStart( this.getList(),schedule.getList() );
		log("sorted : "+sortedIntervals);
		for( Interval cur : sortedIntervals ) {
			log("merged : "+merged);
			log("cur : "+cur);
			if( !merged.isEmpty() && merged.lastInterval().overlaps(cur) )
				merged.lastInterval().mergeOverlappingInterval(cur);
			else
				merged.append(cur);
			log("merged : "+merged);
			log("-----------------");
		}
		log("merged : "+merged);
		this.list = merged.list;
		log("merging of schedules done");
	}
	private Interval lastInterval() {
		return this.list.get( list.size()-1 );
	}
	private static List<Interval> getIntervalsSortedByStart(List<Interval> list1, List<Interval> list2) {
		List<Interval> ret = new ArrayList<Interval>();
		int i1 = 0;
		int i2 = 0;
		while( i1<list1.size() && i2<list2.size() ) {
			if( list1.get(i1).start <= list2.get(i2).start )
				ret.add( list1.get(i1++) );
			else
				ret.add( list2.get(i2++) );
		}
		while( i1<list1.size() )
			ret.add( list1.get(i1++) );
		while( i2<list2.size() )
			ret.add( list2.get(i2++) );
		return ret;
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	private List<Interval> getList() {
		return list;
	}
	public void merge(Interval interval) {
		Schedule schedule = new Schedule();
		schedule.append(interval);
		merge(schedule);
	}
	private void append(Interval interval) {
		list.add(interval);
	}
	public Iterator<Interval> iterator() {
		return list.iterator();
	}
	@Override
	public String toString() {
		return list.toString();
	}
	private void log(Object obj) {
		Logger.log("\t"+obj);
	}
}

class Logger {
	public static void log(Object obj) {
		//System.out.println( obj );
	}
}