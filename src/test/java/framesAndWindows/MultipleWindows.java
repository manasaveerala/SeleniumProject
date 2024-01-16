package framesAndWindows;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@class='wikipedia-search-input']")).sendKeys("testing");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		List<WebElement> searchlinks=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']/div/a"));
		System.out.println("No. of Links"+searchlinks.size());
		System.out.println("Printing and clicking links...................");
		
		for(WebElement link:searchlinks) {
			System.out.println(link.getText());
			link.click();
		}	
	//After opening all pages capture windows
			Set<String> windows=driver.getWindowHandles();
	System.out.println("switching to each browser window and getting the titles...........");
			for(String winid:windows) {
				String titles=driver.switchTo().window(winid).getTitle(); 
				System.out.println(titles);
				if(titles.equalsIgnoreCase("Testing (album) - Wikipedia") || titles.contains("Testing cosmetics on animals")){
					driver.close();
				}
			}
			
		}
	

}
