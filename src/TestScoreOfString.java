
public class TestScoreOfString extends Tests<String, Integer> {
	@Override
	void testInit() {
		mapTest.put("hello", 13);
		mapTest.put("zaz", 50);
	}

	@Override
	Integer wrapFunction(String t) {
		return scoreOfString(t);
	}
	
	public TestScoreOfString(boolean verbose) {
		super(verbose);
	}
	
	public int scoreOfString(String s) {
		return 0;
	}
}
