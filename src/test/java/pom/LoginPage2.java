package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage2 {
 public WebDriver driver;
	
	public LoginPage2(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
// WebElements Locators+identification
@FindBy(xpath="//img[@alt='company-branding']") 
WebElement img_logo;

@FindBy(name="username")
WebElement txt_username;

@FindBy(css ="input[placeholder='Password']")
WebElement txt_password;

@FindBy(xpath = "//button[normalize-space()='Login']")
WebElement btn_Login;

public boolean setlogoPresence() {
	boolean logoPresent=img_logo.isDisplayed();
		return logoPresent;
	}
	public void setUsername(String username) {
		txt_username.sendKeys(username);
	}
	public void setPassword(String pwd) {
		txt_password.sendKeys(pwd);
	}
	
	public void loginClick() {
		// TODO Auto-generated method stub
		btn_Login.click();
	}
	
	
	
}
