import java.util.List;
import java.util.Arrays;

public class IsSubsequence extends Tests<List<String>, Boolean>
{
	public IsSubsequence(boolean verbose) {
		super(verbose);
	}
	
	@Override
	void testInit() {
		// mapTest.put(null, false);
		mapTest.put(Arrays.asList(new String[]{
			"abc", "abc"
		}), true);
		mapTest.put(Arrays.asList(new String[]{
			"abc", "cab"
		}), false);
		mapTest.put(Arrays.asList(new String[]{
			"abc", "axbxcx"
		}), true);
		mapTest.put(Arrays.asList(new String[]{
			"abc", "ab"
		}), false);
	}

	@Override
	Boolean solution(List<String> param) {
		// param index 0: matching sequence
		// param index 1: sequence to traverse
		
		String s = param.get(0);
		String t = param.get(1);
		
		if (t.length() < s.length()) return false;

		int satisfy = 0;
		
		for (int i = 0; i < t.length() && satisfy != s.length(); i++) {
			if (t.charAt(i) == s.charAt(satisfy)) satisfy++;
		}

		return satisfy == s.length();
	}
}
