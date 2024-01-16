package assignments;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://blazedemo.com");
		
		driver.manage().window().maximize();
		//Dropdown without list and Select tag
		//driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("Portland");

		//Dropdown by using list
		List<WebElement> departlist =driver.findElements(By.xpath("//select[@name='fromPort']/option"));
		for(int i=0;i<departlist.size();i++) {
			
			String fromcity=departlist.get(i).getText();
			if(fromcity.equalsIgnoreCase("Portland"))
				departlist.get(i).click();
		}
		//Dropdown by Select tag
		WebElement arrivecityoptions=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select tocity=new Select(arrivecityoptions);
		tocity.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement tableElement=driver.findElement(By.xpath("//table//tbody[1]"));
		List<WebElement> rows= tableElement.findElements(By.tagName("tr"));
		double[] pricearr =new double[rows.size()];
		for(int row=0;row<rows.size();row++) {
			List<WebElement> cols=rows.get(row).findElements(By.tagName("td"));
			String price=cols.get(5).getText().replace("$", "");
			//System.out.println(price);
			pricearr[row]=Double.parseDouble(price);
			//System.out.println(pricearr[row]);
		}
		Arrays.sort(pricearr);
		String minval=String.valueOf(pricearr[0]);
		for(int row=0;row<rows.size();row++) {
			List<WebElement> cols=rows.get(row).findElements(By.tagName("td"));
			String price=cols.get(5).getText().replace("$", "");
			if(minval.equals(price)) {
			   cols.get(0).click();
				break;
			}
		}
		driver.findElement(By.id("inputName")).clear();
		driver.findElement(By.id("inputName")).sendKeys("Ananth Padma");
		
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("Venkatagiri");
		
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Hyderabad");
		
		driver.findElement(By.id("state")).clear();
		driver.findElement(By.id("state")).sendKeys("Telangana");
		
		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("500053");
		
		WebElement carddetails=driver.findElement(By.id("cardType"));
		Select card=new Select(carddetails);
		card.selectByVisibleText("American Express");
		
		driver.findElement(By.id("creditCardNumber")).clear();
		driver.findElement(By.id("creditCardNumber")).sendKeys("6578765434");
		
		driver.findElement(By.id("creditCardMonth")).clear();
		driver.findElement(By.id("creditCardMonth")).sendKeys("11");
		
		driver.findElement(By.id("creditCardYear")).clear();
		driver.findElement(By.id("creditCardYear")).sendKeys("2023");
		
		driver.findElement(By.id("nameOnCard")).clear();
		driver.findElement(By.id("nameOnCard")).sendKeys("Ananth");
		
		driver.findElement(By.id("rememberMe")).click();
		driver.findElement(By.xpath("(//input[@value='Purchase Flight'])")).click();
		
		String confirmMsg=driver.findElement(By.xpath("(//h1[normalize-space()='Thank you for your purchase today!'])")).getText();
		if(confirmMsg.equalsIgnoreCase("Thank you for your purchase today!"))
			System.out.println("Ticket has booked successfully");
		//driver.close();
	}

}
