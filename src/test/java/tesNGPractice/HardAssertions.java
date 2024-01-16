package tesNGPractice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	void test() {
		int x,y;
		x=10; y=15;
		if(x==y) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		//Assert.assertTrue(true);
		//Assert.assertTrue(false);
		//assertEquals(x, y);
		int a=10;
		int b=20;
		// Assert.assertEquals(actual, expected, description)
		//assertEquals(a>b, true, "a is not greater than b");//fail
		//assertEquals(a>b, false, "a is not greater than b");//pass
		
		String s1="abc";
		String s2="abc1";
		
		Assert.assertEquals(s1,s2,"string are not equal"); // fail
		//Assert.assertEquals(s1, s2);//fail
		//Assert.assertNotEquals(s1, s2);//fail
		if(false)
		{
			Assert.assertTrue(true);
		}
		else
		{
			//Assert.assertTrue(false);
			Assert.fail();
			
		}

	}
}
