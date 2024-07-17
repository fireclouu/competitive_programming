import java.util.HashMap;
import java.util.Map;

public abstract class Tests<T, U> {
	Map<T, U> mapTest = new HashMap<>();
	private boolean verbose;
	
	abstract void testInit();
	abstract U wrapFunction(T t);
	
	public Tests(boolean verbose) {
		this.verbose = verbose;
		testInit();
		test();
	}

	public void test() {
		String pad = "%-10s %s%s";
		int correct = 0;
		int counter = 0;
		long benchmark;
		double avgTime = 0;
		double benchmarkMills;
		
		System.out.println("Type: " + getClass().getName());
		System.out.println();

		for (Map.Entry entry : mapTest.entrySet()) {
			benchmark = System.nanoTime();
			T output = (T) wrapFunction((T) entry.getKey());
			benchmark = (System.nanoTime() - benchmark);
			benchmarkMills = (double) benchmark / 1_000_000.0f;
			avgTime += benchmarkMills;
			
			boolean testResult = (output).equals(entry.getValue());
			String testResultStatus = testResult ? "Passed" : "Failed";
			System.out.print("Test " + ++counter + ": ");

			if (testResult) correct++;

			if (verbose) {
				System.out.println();
				System.out.printf(pad, "Input:", entry.getKey(), "\n");
				System.out.printf(pad, "Output:", output, "\n");
				System.out.printf(pad, "Expected: ", entry.getValue(), "\n");
				System.out.printf(pad + " %s", "Result:", testResultStatus, "(" + benchmarkMills + "ms)","\n");
				System.out.println("-----------");
			}
			else {
				System.out.println(testResultStatus + " (" + String.format("%.4f", benchmarkMills) + "ms)");
			}	
		}

		System.out.println();
		System.out.println("Got " + Math.ceil((((double) correct / (double) counter) * 100.0f)) + "% test passed!");
		System.out.println("Total execution time: " + String.format("%.4f", avgTime)  + "ms");
		System.out.println("-----------");
	}
}
