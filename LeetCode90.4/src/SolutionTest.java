import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SolutionTest {
	Solution sol = new Solution();

	@Test
	public void test1() {
		test(new int[]{10,20,5}, new int[]{70,50,30}, 2, 105.0);
	}

	@Test
	public void test2() {
		test(
				new int[]{
						32,43,66,9,94,57,25,44,99,19
						}, 
				new int[]{
						187,366,117,363,121,494,348,382,385,262
						}, 
				4, 
				1528.0);
	}

	@Test
	public void test3() {
		test(
				new int[]{
						426,348,172,182,86,55,459,148,79,179,308,187,394,118,143,4,138,312,125,170,201,221,166,135,359,144,6,282,186,372,16,469,394,412,102,172,494,313,277,5,320,347,318,252,377,434,184,272,286,6,377,108,457,17,126,235,234,280,368,243,25,160,220,425,28,495,405,12,152,313,29,103,500,360,327,92,364,405,109,362,224,279,171,394,190,265,430,237,495,475,100,86,184,424,63,58,488,88,197,114,429,283,210,282,331,210,302,347,402,414,238,180,451,182,326,479,332,152,294,209,101,304,19,189,408,7,167,14,1,230,278,324,444,474,82,296,368,466,160,192,183,394,201,295,208,452,140,169,415,67,284,235,291,31,278,264,8,496,445,289,160,113,255,278,38,462,142,95,431,389,188,359,10,22,496,320,321,298,463,500,13,27,287,8,297,155,11,480,397,221,145,30,475,365,304,181,204,33,366,320,75,343,251,107,15,415,351,116,342,408,271,163,2,74,176,130,265,258,10,267,123,245,193,36,326,210,50,104,153,438,308,66,11,483,434,51,484,60,301,133,313,423,332,36,353,155,163,423,186,45,108,197,500,73,400,165,243,166,401,401,218,383,377,160,360,375,413,375,276,17,375,500,269,98,311,262,59,86,414,2,99,38,179,208,439,26,451,311,355,37,73,246,417,243,239,480,388,193,254,201,377,161,388,164,165,234,307,222,17,452,250,316,169,381,398,115,260,383,499,489,279,75,305,372,313,110,166,261,385,15,35,285,363,140,302,211,307,438,46,466,384,420,368,26,92,240,455,235,183,475,183,196,132,21,84,324,305,106,161,288,196,308,109,87,434,442,285,359,176,46,84,169,474,193,225,434,115,312,408,408,455,278,26,432,123,341,62,208,153,80,491,312,478,323,142,110,166,305,487,267,420,45,472,374,464,430,147,397,350,209,402,147,494,190,426,129,464,114,448,443,142,53,189,133,479,415,237,274,343,132,250,461,102,38,3,321,346,166,214,271,186,11,425,463,96,338,358,388,444,181,466,474,26,72,430,433,266,17,222,386,31,405,450,377,68,133,394,290,341,390,272,178,345,82,267,176,441,264,380,204,472,235,423,214,7,410,460,310,484,47,88,216,142,265,234,468,400,292,114,82
						}, 
				new int[]{
						278,235,385,444,291,269,480,189,63,76,163,17,85,482,245,227,321,379,81,287,440,489,39,213,250,434,88,120,43,212,1,289,221,425,177,294,285,373,319,70,366,370,288,146,368,353,372,446,317,359,139,204,245,303,153,12,359,358,99,326,261,85,44,338,499,286,435,432,363,272,383,63,350,38,191,178,129,154,196,8,12,73,288,53,336,363,466,168,218,447,32,223,383,425,427,452,146,189,42,135,318,336,86,62,254,8,99,429,486,68,436,70,172,475,124,201,194,58,166,185,263,451,233,332,421,240,219,317,45,256,254,463,423,248,344,178,329,398,127,26,332,143,26,480,493,495,420,251,253,148,360,424,360,315,395,28,325,214,32,469,169,335,83,352,182,96,440,77,23,453,272,425,237,418,415,205,481,46,157,484,271,47,122,427,37,356,176,261,480,69,492,258,433,438,453,140,19,486,250,27,330,385,263,138,107,86,368,363,18,485,380,415,283,217,276,257,80,58,106,90,225,128,215,240,358,199,202,379,10,481,255,99,451,288,389,478,197,256,375,243,188,135,260,311,37,445,219,436,139,168,246,388,385,215,280,397,96,420,455,400,83,361,43,28,96,337,201,323,215,113,330,365,281,37,403,380,26,132,155,421,125,260,472,153,234,40,432,334,354,465,366,104,323,243,130,343,268,357,325,138,230,455,368,230,388,44,180,402,500,287,476,23,114,221,255,205,420,375,28,109,14,316,342,392,297,101,444,196,115,330,177,280,110,405,289,123,141,353,81,470,335,256,61,365,5,166,315,40,223,332,14,486,162,259,203,207,455,174,414,403,49,125,104,87,273,354,345,299,132,240,427,242,497,364,289,431,176,99,154,18,92,300,397,395,208,388,379,203,16,413,223,60,422,410,310,409,295,306,230,417,382,379,305,275,221,370,173,328,96,450,52,351,250,122,331,17,203,76,384,137,31,396,383,487,67,212,198,241,22,85,253,28,92,210,294,444,159,382,52,277,145,225,60,140,198,460,355,66,81,370,149,147,311,335,445,481,80,370,332,175,8,8,274,427,87,267,15,89,135,279,318,123,282,254,302,457,495,252,125,408,430,178,318,411,324,99,59,312,496,320,76,445,373,382,104,15,106,119,379,296
						}, 
				85, 
				1528.0);
	}

	@Test
	public void test4() {
	}
	
	public void test(int[] quality, int[] wages, int K, double expected) {
		Assert.assertEquals(expected, sol.mincostToHireWorkers(quality, wages, K));
	}
	
	public void log(Object obj) {
		System.out.println(obj);
	}

}