import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class GenerateParentheses extends Tests<Integer, List<String>> {
	
	public GenerateParentheses(boolean verbose) {
		super(verbose);
	}
	
	@Override
	void testInit() {
		List<String> list;
		list = new ArrayList<>(Arrays.asList(new String[]{"((()))","(()())","(())()","()(())","()()()"}));
		mapTest.put(3, list);
		
		list = new ArrayList<>(Arrays.asList(new String[]{"()"}));
		mapTest.put(1, list);
		
		list = new ArrayList<>(Arrays.asList(new String[]{"(())", "()()"}));
		mapTest.put(2, list);
	}

	@Override
	List<String> solution(Integer t) {
		// t is maximum deep level of parentheses
		List<String> formList = new ArrayList<>();
		char[] pair = {'(', ')'};
		int formCount = t * pair.length;
		char[] forms = new char[formCount];
		
		for (int i = 0; i < formCount; i++) {
			forms[i] = i < t ? pair[0] : pair[1];
		}
		
		char[] originalForm = forms;
		backtrack(formList, "", 0, 0, t);
		// transform
		return formList;
	}
	public void backtrack(List<String> list, String str, int open, int close, int max){
        System.out.println("open: " + open + " close: " + close + " max: " + max + "  " + str);
		// recursion ended
		if(str.length() == max*2){
            list.add(str);
			System.out.println("added: " + str);
            return;
        }
		
        if(open < max){
            backtrack(list, str+"(", open+1, close, max);
        }
        if(close < open){
            backtrack(list, str+")", open, close+1, max);
        }
    }
	
}
