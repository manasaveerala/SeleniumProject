package tesNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssertions {

	//@Test(priority=1)
	void hardAssertion() {
		System.out.println("testing....");
		System.out.println("testing....");
		System.out.println("testing....");
		System.out.println("testing....");
		
		Assert.assertEquals(1, 2);  // if it will fail then below statement will not be executed..
		
		System.out.println("hard assertion completed.....");
		Assert.assertEquals(1, 1);
	}
	@Test(priority = 2)
	void softAssertions() {
		System.out.println("testing....");
		System.out.println("testing....");
		System.out.println("testing....");
		System.out.println("testing....");
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(1, 2);  // Even if it fail then below statement will be executed..
		
		System.out.println("soft assertion completed.....");
		Assert.assertEquals(1, 1);
		sa.assertAll();
	}
}
