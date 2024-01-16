 package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;

	//constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators
	By img_Logo_loc=By.xpath("//img[@alt='company-branding']");
	By username_loc=By.name("username");
	By password_loc=By.cssSelector("input[placeholder='Password']");
	By btn_submit_loc=By.xpath("//button[normalize-space()='Login']");

	 //Actions
	
	public void setUsername(String username) {
		driver.findElement(username_loc).sendKeys(username);
	}
		
	public void setPassword(String password) {
		driver.findElement(password_loc).sendKeys(password);
	}
	public void loginClick() {
		driver.findElement(btn_submit_loc).click();
	}
	public boolean setLogoPresence() {
		
		boolean logopresent=driver.findElement(img_Logo_loc).isDisplayed();
		return logopresent;
	}
	
	

}
