import java.util.Arrays;

public class Solution {
	
    public int numFriendRequests(int[] ages) {
        int nRequests = 0;
        int n = ages.length;
        int l = 0;
        int m = 0;
        Arrays.sort(ages);
        for(int i=0; i<n; i++) {
        	int age = ages[i];
        	int min = getMin(age);
        	int max = getMax(age);
        	while( l<n && ages[l]<=min ) {
        		l++;
        	}
        	while( m<n && ages[m]<=max ) {
        		m++;
        	}
        	m--;
        	if(l>=n)
        		break;
        	log("i : "+i);
        	log("l : "+l);
        	log("m : "+m);
        	if(l<=m)
        		nRequests += (m-l+1);
            log("nReq : "+nRequests);
            if(i>=l && i<=m)
                nRequests -= 1;
            log("nReq : "+nRequests);
        }
        return nRequests;
    }

	private int getMax(int age) {
		return age;
	}

	private int getMin(int age) {
		if(age%2 == 0) {
			return age/2 + 7;
		} else {
			return age/2 + 7;
		}
	}
	
	private void log(Object obj) {
		System.out.println(obj);
	}

}
