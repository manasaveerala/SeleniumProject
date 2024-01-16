package tesNGPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelParam {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser","url"})
	void setup(String browser,String url) throws InterruptedException {
		if(browser.equals("IE")) {
			WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();
		}else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	@Test(priority = 1)
	void testLogo(){
		try {
			boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
			Assert.assertEquals(status,true);
		}catch (Exception e) {
			Assert.fail();
		}
	}
	@Test(priority=2)
	void testHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(),"OrangeHRM","Titles are bot matched..");
		
	}
	
	@AfterClass
	void closeApp()
	{
		driver.quit();
	}

	
}
