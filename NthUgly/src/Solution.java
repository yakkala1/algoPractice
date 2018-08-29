import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int nthUglyNumber(int n) {
        Number[] numbers = new Number[]{
        		new Number(1,0,0,"N2"),
        		new Number(0,1,0,"N3"),
        		new Number(0,0,1,"N5"),
        		new Number(1,1,0,"N23"),
        		new Number(1,0,1,"N25"),
        		new Number(0,1,1,"N35"),
        		new Number(1,1,1,"N235"),
        };
        Arrays.sort(numbers);
        int ret = 1;
        for(int i=2; i<=n; i++) {
        	Number num = numbers[0];
        	ret = num.num;
        	
        }
    }
}

class Number implements Comparable<Number> {
	public long f2,f3,f5;
	public String type;
	public long num;
	public Number(int f2, int f3, int f5, String type) {
		this.f2 = f2;
		this.f3 = f3;
		this.f5 = f5;
		this.type = type;
		compute();
	}
	public void compute() {
		this.num = power(2,f2)*
				power(3,f3)*
				power(5,f5);
	}
	public void increment(int b) {
		switch(b) {
		case 2:
			f2++;
			num = num*2;
			break;
		case 3:
			f3++;
			num = num*3;
			break;
		case 5:
			f5++;
			num = num*5;
			break;
		default:
			break;
		}
	}
	private int power(int b, long p) {
		int ret = 1;
		for(int i=0; i<p; i++) {
			ret = ret*b;
		}
		return ret;
	}
	@Override
	public int compareTo(Number o) {
		return Long.compare(this.num, o.num);
	}
}