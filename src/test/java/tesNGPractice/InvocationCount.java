package tesNGPractice;

import org.testng.annotations.Test;

public class InvocationCount {
 
	@Test(invocationCount = 5)
	void test() {
		System.out.println("invocation method testing...");
	}
}
