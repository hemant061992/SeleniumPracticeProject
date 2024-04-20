package day_32;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\myfile.xlsx");
 		
        XSSFWorkbook workbook=new XSSFWorkbook();
        
        XSSFSheet sheet= workbook.createSheet();
        
      //Creating rows, cells and update data without loop
      		/*XSSFRow row1=sheet.createRow(0);
      				
      		row1.createCell(0).setCellValue("welcome");
      		row1.createCell(1).setCellValue("12345");
      		row1.createCell(2).setCellValue("xyz");
      				
      		XSSFRow row2=sheet.createRow(1);
      		
      		row2.createCell(0).setCellValue("abc");
      		row2.createCell(1).setCellValue("4567");
      		row2.createCell(2).setCellValue("testing");
      		*/
        
           //creating rows, cells and update data using loop
        
	       Scanner scn=new Scanner(System.in);
	       
	       for(int r=0; r<=3; r++)
	       {
	    	   XSSFRow currentRow=sheet.createRow(r);
	    	   
	    	   for(int c=0;c<2;c++)
	    	   {
	    		  // currentRow.createCell(c).setCellValue("Welcome");
	    		    System.out.println("Enter a value:");
					String value=scn.next();
					currentRow.createCell(c).setCellValue(value);
	    		   
	    	   }
	       }
	       
	       workbook.write(file);
	       workbook.close();
	       file.close();
	       
	       System.out.println("Writing is done!!!!");
	}

}
