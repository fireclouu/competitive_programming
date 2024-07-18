import java.util.HashMap;
import java.util.Map;
import java.util.*;

public abstract class Tests<T, U> {
	Map<T, U> mapTest = new LinkedHashMap<>();
	private boolean verbose;
	
	abstract void testInit();
	abstract U wrapFunction(T t);
	
	public Tests(boolean verbose) {
		this.verbose = verbose;
		testInit();
		test();
	}

	public void test() {
		final String PAD = "%-10s %s%s";
		String expectedString;
		String outputString;
		String inputString;
		int countPassed = 0;
		int countTest = 0;
		T input;
		U output;
		U expected;
		long benchmark;
		double avgTime = 0;
		double benchmarkMills;
		
		System.out.println("Type: " + getClass().getName());
		System.out.println();

		for (Map.Entry entry : mapTest.entrySet()) {
			inputString = outputString = expectedString = "";
			input = (T) entry.getKey();
			expected = (U) entry.getValue();
			
			// test
			benchmark = -System.nanoTime();
			output = (U) wrapFunction(input);
			benchmark += System.nanoTime();
			
			benchmarkMills = (double) benchmark / 1_000_000.0f;
			benchmarkMills = benchmarkMills < 0 ? 0 : benchmarkMills;
			avgTime += benchmarkMills;
			
			inputString += parseToString(input);
			outputString += parseToString(output);
			expectedString += parseToString(expected);
			
			boolean isExpected = true;
			
			if (expected == null || output == null) {
				isExpected = output == null && expected == null;
			} else if (expected instanceof ListNode) {
				ListNode nodeExpected = (ListNode) expected;
				ListNode nodeOutput = (ListNode) output;
				
				while ((nodeExpected != null || nodeOutput != null)) {
					isExpected = nodeExpected != null && nodeOutput != null;
					if (!isExpected) break;
					isExpected = nodeExpected.val == nodeOutput.val;
					if (!isExpected) break;
					nodeExpected = nodeExpected.next;
					nodeOutput = nodeOutput.next;
				}
			} else {
				isExpected = output != null && expected != null && output.equals(expected);
			}
			
			String testResultStatus = isExpected ? "Passed" : "Failed";
			System.out.print("Test " + ++countTest + ": ");

			if (isExpected) countPassed++;

			if (verbose) {
				System.out.println();
				System.out.printf(PAD, "Input:", inputString, "\n");
				System.out.printf(PAD, "Output:", outputString, "\n");
				System.out.printf(PAD, "Expected: ", expectedString, "\n");
				System.out.printf(PAD + " %s", "Result:", testResultStatus, " (" + String.format("%.4f", benchmarkMills) + "ms)","\n");
				System.out.println("-----------");
			}
			else {
				System.out.println(testResultStatus + " (" + String.format("%.4f", benchmarkMills) + "ms)");
			}	
		}

		System.out.println();
		System.out.println("Got " + Math.ceil((((double) countPassed / (double) countTest) * 100.0f)) + "% test passed!");
		System.out.println("Total execution time: " + String.format("%.4f", avgTime)  + "ms");
		System.out.println("-----------");
	}
	
	private String parseToString(Object object) {
		String result = "";
		
		if (object == null) return "[]";
		
		if (object instanceof List) {
			List<ListNode> nodes =  (List<ListNode>) object;
			for (ListNode node : nodes) {
				result += parseToString(node);
			}
		} else if (object instanceof ListNode) {
			result += ListNode.getListNodeValues((ListNode) object);
		} else {
			result = object.toString();
		}
		
		return result;
	}
}
