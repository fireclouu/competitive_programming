

public class StringToIntegerAtoI extends Tests<String, Integer>
{
	public StringToIntegerAtoI(boolean verbose) {
		super(verbose);
	}
	
	@Override
	void testInit() {
		mapTest.put("42", 42);
		mapTest.put("    -042", -42);
		mapTest.put("1337c0d3", 1337);
		mapTest.put("0-1", 0);
		mapTest.put("words and 987", 0);
		mapTest.put("", 0);
	}

	@Override
	Integer solution(String s) {
		s = s.trim();
		System.out.println((int) '1');
		return null;
	}
	
}
