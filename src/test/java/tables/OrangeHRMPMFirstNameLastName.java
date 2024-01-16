package tables;

import java.sql.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMPMFirstNameLastName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("(//button[@type='submit'])")).click();
		
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']/li[2]")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//scrolldown by pixel
		/*js.executeScript("window.scrollBy(0,5000)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));  //5000*/
		
		//Scrolldown by webelement
		WebElement lbl_recordsfound=driver.findElement(By.xpath("//span[contains(normalize-space(),'Records Found')]"));
		js.executeScript("arguments[0].scrollIntoView();", lbl_recordsfound);
		
		
		int rows=driver.findElements(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div")).size();
		for(int row=1;row<rows;row++) {
			String firstname=driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div["+row+"]//div[@role='row']/div[3]/div")).getText();
			String lastname=driver.findElement(By.xpath("//div[@class='oxd-table-body' and @role='rowgroup']/div["+row+"]//div[@role='row']/div[4]/div")).getText();
			System.out.println("Firstname: "+firstname+" and Lastname: "+lastname);
		}
		//driver.close();
	}

}
