package datadriventesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatingROIUsingExcelDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String file=System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		int rows=ExcelUtils.getRowCount(file,"Sheet1");
		
		for(int row=1;row<=rows;row++) {
		//read data
			String principalVal=ExcelUtils.getCellData(file, "Sheet1",row, 0);
			String roi=ExcelUtils.getCellData(file, "Sheet1",row,1 );
			String period=ExcelUtils.getCellData(file, "Sheet1",row, 2);
			String DateMonYear=ExcelUtils.getCellData(file, "Sheet1",row, 3);
			String interesttype=ExcelUtils.getCellData(file, "Sheet1",row, 4);
			String exp_mvalue=ExcelUtils.getCellData(file, "Sheet1",row, 5);
		//read data from excel
		driver.findElement(By.id("principal")).sendKeys(principalVal);
		driver.findElement(By.id("interest")).sendKeys(roi);
		driver.findElement(By.id("tenure")).sendKeys(period);
		driver.findElement(By.xpath("//select[@id='tenurePeriod']")).sendKeys(DateMonYear);
		Select drp=new Select(driver.findElement(By.id("frequency")));
		drp.selectByVisibleText(interesttype);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement calculate=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
		js.executeScript("arguments[0].click();", calculate);
		//Validation and update results in excel
		String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']/strong")).getText();
		if(Double.parseDouble(exp_mvalue)==Double.parseDouble(act_mvalue)) {
			
			ExcelUtils.setCellData(file, "Sheet1", row, 7, "Pass");
			ExcelUtils.fillGreenColor(file, "Sheet1", row, 7);
			
		}else {
			
			ExcelUtils.setCellData(file, "Sheet1", row, 7, "Fail");
			ExcelUtils.fillRedColor(file, "Sheet1", row, 7);
			
		}
		//Update results
		String exp_val=ExcelUtils.getCellData(file, "Sheet1", row, 6);
		String act_val=ExcelUtils.getCellData(file, "Sheet1", row, 7);
		if(exp_val.equalsIgnoreCase(act_val))
			ExcelUtils.setCellData(file, "Sheet1", row, 8, "As Expected");	
			
		Thread.sleep(3000);
		//clearing data
		WebElement cleardata=driver.findElement(By.xpath("//div[@class='cal_div']//a[2]"));
		js.executeScript("arguments[0].click();", cleardata);
		
		}
		Thread.sleep(3000);
		driver.close();
	}

}
