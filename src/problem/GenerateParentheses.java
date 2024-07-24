import java.util.List;
import java.util.*;

public class GenerateParentheses extends Tests<Integer, List<String>> {
	
	public GenerateParentheses(boolean verbose) {
		super(verbose);
	}
	
	@Override
	void testInit() {
		String[] str = {"((()))","(()())","(())()","()(())","()()()"};
		List<String> list;
		list = new ArrayList<>(Arrays.asList(str));
		mapTest.put(3, list);
	}

	@Override
	List<String> solution(Integer t) {
		return null;
	}
}
