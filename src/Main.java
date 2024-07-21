
public class Main {
	public static void main(String[] args) {
		// new ValidParenthesis(true);
		// new ScoreOfString(false);
		// new MergeTwoSortedList(true);
		// recursiveTest(500);
		// new ReverseInteger(true);
		new StringToIntegerAtoI(true);
	}
	
	private static boolean doesAliceWin(String s) {
		String vowels = s.replaceAll("[^aeiou]","");
		if (vowels.isEmpty()) return false;
		
		// test leetcoder
		// alice: leetco
		// bob: d
		// alice: er
		
		return (vowels.length() % 2) == 0;
	}
	
	private static int minChanges(int n, int k) {
		if (n == k) return 0;
		//if (k > n) minChanges(k, n);
		
		// use of and to flip k and n, while n is the basis number
		int count = n & k;
		if (count != k) return -1;
		
		int counter = 0;
		for (; n > 0;) {
			if ((k&1) != 1) counter+= (n&1);
			n = n >> 1;
			k = k >> 1;
		}
		
		return counter;
	}
	
	private static int recursiveTest(int value) {
		if (value == 0) return 0;
		System.out.println("param is " + value);
		return recursiveTest(value - 1);
	}
}

