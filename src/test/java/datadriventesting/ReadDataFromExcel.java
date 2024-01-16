package datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;

public class ReadDataFromExcel {

	public static void main(String args[]) throws IOException {

		FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		
		/*System.out.println(row);
		XSSFRow row1=sheet.getRow(0);
		XSSFCell cell=row1.getCell(1);
		System.out.println(cell.getStringCellValue());*/
		 
		
		for(int row=0;row<rows;row++) {
			
			XSSFRow roww=sheet.getRow(row);
			int cols=roww.getLastCellNum();
			
			for(int col=0;col<cols;col++) {
				String value=roww.getCell(col).toString();
				System.out.print(value+"      ");
				}
			System.out.println();
		}
}
}
