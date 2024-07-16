import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class TestValidParenthesis extends Tests<String, Boolean>
{
	@Override
	void implementTests() {
		mapTest.put("()", true);
		mapTest.put("(){}[]", true);
		mapTest.put("(]", false);
		mapTest.put("{[]}", true);
		mapTest.put("[", false);
		mapTest.put("((", false);
		mapTest.put("]", false);
	}
	
	@Override
	Boolean scopeTest(String t) {
		return isValid(t);
	}
	
	public TestValidParenthesis(boolean verbose) {
		super(verbose);
	}
	
	public boolean isValid(String s) {
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
}
