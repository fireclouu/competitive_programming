import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis extends Tests<String, Boolean> {
	
	@Override
	void testInit() {
		mapTest.put("()", true);
		mapTest.put("(){}[]", true);
		mapTest.put("(]", false);
		mapTest.put("{[]}", true);
		mapTest.put("[", false);
		mapTest.put("((", false);
		mapTest.put("]", false);
	}
	
	@Override
	Boolean solution(String s) {
		if (s == null || s.isEmpty()) return false;
		Stack<Character> pairStack = new Stack<>();
		Map<Character, Character> pairs = new HashMap<>();
		pairs.put('(', ')');
		pairs.put('{', '}');
		pairs.put('[', ']');

		for (int i = 0; i < s.length(); i++) {
			char item = s.charAt(i);
			if (pairs.containsKey(item)) {
				pairStack.push(pairs.get(item));
			}
			else {
				if (pairStack.size() == 0 || item != pairStack.pop()) return false;
			}
		}

		return s.length() != 1 && pairStack.size() == 0;
	}
	
	public ValidParenthesis(boolean verbose) {
		super(verbose);
	}
}
