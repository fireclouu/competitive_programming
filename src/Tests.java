import java.util.HashMap;
import java.util.Map;

public abstract class Tests<T, U>
{
	Map<T, U> mapTest = new HashMap<>();
	private boolean verbose;
	public Tests(boolean verbose) {
		this.verbose = verbose;
		implementTests();
	}
	
	abstract void implementTests();
	abstract U scopeTest(T t);
	public void test() {
		String pad = "%-10s %s%s";
		int correct = 0;
		int counter = 0;
		
		System.out.println("Type: " + getClass().getName());
		System.out.println();
		
		for (Map.Entry entry : mapTest.entrySet()) {
			boolean testResult = (scopeTest((T) entry.getKey()).equals(entry.getValue()));
			String testResultStatus = testResult ? "Passed" : "Failed";
			System.out.print("Test " + ++counter + ": ");
			
			if (testResult) correct++;
			
			if (verbose) {
				System.out.println();
				System.out.printf(pad, "Input:", entry.getKey(), "\n");
				System.out.printf(pad, "Output:", scopeTest((T) entry.getKey()), "\n");
				System.out.printf(pad, "Expected: ", entry.getValue(), "\n");
				System.out.printf(pad, "Result:", testResultStatus, "\n");
				System.out.println("-----------");
			} else {
				System.out.println(testResultStatus);
			}	
		}
		
		System.out.println();
		System.out.println("Got " + Math.ceil((((double) correct / (double) counter) * 100.0f)) + "% test passed!" );
	}
}
