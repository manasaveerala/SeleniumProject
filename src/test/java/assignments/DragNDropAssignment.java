package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragNDropAssignment {
	public static void main(String args[]) {
		
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://demo.guru99.com/test/drag_drop.html");
	
	driver.manage().window().maximize();
	Actions act=new Actions(driver);
	WebElement banksrc=driver.findElement(By.xpath("//li[@id='credit2']/a"));
	WebElement bankdestination=driver.findElement(By.xpath("//table[@id='table4']/tbody/tr/td[1]//ol[@id='bank']"));
	
	act.dragAndDrop(banksrc, bankdestination).perform();
	
	WebElement debitsrcmoney=driver.findElement(By.xpath("(//li[@id='fourth'])[1]/a"));
	WebElement debitdestinationmoney=driver.findElement(By.xpath("//table[@id='table4']/tbody/tr/td[2]//ol[@id='amt7']"));
	act.dragAndDrop(debitsrcmoney, debitdestinationmoney).perform();
	
	WebElement salessrc=driver.findElement(By.xpath("//li[@id='credit1']/a"));
	WebElement salesdestination=driver.findElement(By.xpath("//table[@id='table4']/tbody/tr/td[1]//ol[@id='loan']"));
	
	act.dragAndDrop(salessrc, salesdestination).perform();
	
	WebElement creditsrcmoney=driver.findElement(By.xpath("(//li[@id='fourth'])[2]/a"));
	WebElement creditdestinationmoney=driver.findElement(By.xpath("//table[@id='table4']/tbody/tr/td[2]//ol[@id='amt8']"));
	act.dragAndDrop(creditsrcmoney,creditdestinationmoney ).perform();
	
	}
}
