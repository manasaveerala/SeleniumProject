package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;
	
	//LoginPage lp;
	LoginPage2 lp;
	@BeforeClass
	 void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	@Test(priority = 1)
	 void testLogo() {
		//lp=new LoginPage(driver);
		lp=new LoginPage2(driver);
		boolean status=lp.setlogoPresence();
		Assert.assertEquals(status, true);
	}
	@Test(priority = 2)
	void testLogin() {
		//lp=new LoginPage(driver);
		lp=new LoginPage2(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.loginClick();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		}
	@AfterClass
	void teardown() {
driver.close();
}
}