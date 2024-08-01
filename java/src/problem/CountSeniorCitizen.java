
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CountSeniorCitizen extends Tests<List<String>, Integer> {
	
	public CountSeniorCitizen(boolean verbose) {
		super(verbose);
	}
	
	@Override
	void testInit() {
		mapTest.put(Arrays.asList(new String[]{
			"7868190130M7522",
			"5303914400F9211",
			"9273338290F4010"}), 2);
	}

	@Override
	Integer solution(List<String> t) {
		int count = 0;
		for (String item : t) {
			if (((item.charAt(11) - '0') * 10) + (item.charAt(12) - '0') > 60) {
				count++;
			}
		}
		return count;
	}

}
