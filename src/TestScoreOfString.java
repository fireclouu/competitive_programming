
public class TestScoreOfString extends Tests<String, Integer> {
	@Override
	void testInit() {
		mapTest.put("hello", 13);
		mapTest.put("zaz", 50);
		mapTest.put("aa", 0);
		mapTest.put("ab", 1);
		mapTest.put("", 0);
	}

	@Override
	Integer solution(String s) {
		int score = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			score += Math.abs(s.charAt(i) - s.charAt(i + 1));
		}
		return score;
	}
	
	public TestScoreOfString(boolean verbose) {
		super(verbose);
	}
}
