import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	while( sc.hasNext() ) {
    		String line = sc.nextLine();
    		log("line : "+line);
    		System.out.println( process(line) );
    	}
    	sc.close();
    }

	private static int process(String line) {
		int maxLength = 24;
		int n = line.length();
		if( n<=30 )
			return 1;
		List<String> splits = new ArrayList<String>();
		int cur = 0;
		String curSplit = "";
		while( true ) {
			if( cur>=n )
				break;
			String nextWord = readNextWord(line,cur);
			if( curSplit.equals("") ) {
				curSplit += nextWord;
			} else if( nextWord.equals("") && (curSplit+" "+nextWord).length() <= maxLength+1 ) {
				curSplit += (" "+nextWord);
			} else if( (curSplit+" "+nextWord).length() <= maxLength ) {
				curSplit += (" "+nextWord);
			} else {
				splits.add(curSplit);
				curSplit = nextWord;
			}
			cur += (1+nextWord.length());
		}
		if( curSplit!="" ) {
			splits.add( curSplit );
		}
		log(splits);
		return splits.size();
	}

	private static String readNextWord(String line, int cur) {
		String ret = "";
		while( true ) {
			if( cur>=line.length() )
				break;
			char c = line.charAt(cur++);
			if( c==' ' )
				break;
			else
				ret += c;
		}
		return ret;
	}

	private static void log(Object obj) {
		System.out.println(obj);
	}
    
}