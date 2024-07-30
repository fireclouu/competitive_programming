

public class StringToIntegerAtoI extends Tests<String, Integer>
{
	public StringToIntegerAtoI(boolean verbose) {
		super(verbose);
	}
	
	@Override
	void testInit() {
		mapTest.put(null, 0);
		mapTest.put("42", 42);
		mapTest.put("    -042", -42);
		mapTest.put("1337c0d3", 1337);
		mapTest.put("0-1", 0);
		mapTest.put("words and 987", 0);
		mapTest.put("", 0);
		mapTest.put("-91283472332", -2147483648);
		mapTest.put("21474836460", 2147483647);
		mapTest.put("  0000000000012345678", 12345678);
		mapTest.put(" ", 0);
		mapTest.put("-6147483648", -2147483648);
		mapTest.put("2147483648", 2147483647);
		mapTest.put("9223372036854775808", 2147483647);
	}

	@Override
	Integer solution(String s) {
		if (s == null) return 0;
		s = s.trim();
		if (s.length() == 0) return 0;
		long answer = 0;
		boolean isPositive = true;
		
		// + = 43
		// - = 45
		// 0 = 48
		// 9 = 57
		char firstChar = s.charAt(0);
		if (firstChar >= '0' && firstChar <= '9') {
			answer = firstChar - 48;
		} else if (firstChar == '-') {
			isPositive = false;
		} else {
			return 0;
		}
		
		// check overflow
		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < '0' || c > '9') break;
			answer = isPositive ? (answer * 10) + (c - 48) : (answer * 10) - (c -48);
			if (answer > Integer.MAX_VALUE || (answer < 0 && answer < Integer.MIN_VALUE)) {
				return answer > Integer.MAX_VALUE ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
		}
		
		return (int) answer;
	}
}
