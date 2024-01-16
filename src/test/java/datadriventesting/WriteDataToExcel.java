package datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet("testing");
		
		XSSFRow row1 = sheet.createRow(0);
		//writing data without loop
		row1.createCell(0).setCellValue("Firstname");
		row1.createCell(1).setCellValue("Lastname");
		row1.createCell(2).setCellValue("Designation");
		
		Scanner sc=new Scanner(System.in);
		
		for(int row=0;row<=2;row++) {
			XSSFRow roww = sheet.createRow(row);
			for(int col=0;col<=2;col++) {
				//roww.createCell(col).setCellValue("welcome");
				System.out.println("Enter a value: ");
				String value=sc.next();
				roww.createCell(col).setCellValue(value);
			}
		}
		
		wb.write(fo);
		wb.close();
		fo.close();
	}

}
