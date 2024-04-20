package day_32;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file =new FileInputStream(System.getProperty("user.dir")+"\\testData\\data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet= workbook.getSheet("Sheet1"); //workbook.getattribut(0)
		
		int totalRows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows:"+totalRows);  //6
		System.out.println("Number of cells:"+totalcells);//5
		
		for(int r=0; r<=totalRows;r++ )
		{
			XSSFRow  currentRow=sheet.getRow(r); 
	
			for(int c=0;c<totalcells;c++)
			{
				XSSFCell cell=currentRow.getCell(c);
				String value=cell.toString();
				System.out.print(value+"   ");
			}
			
			System.out.println();
			
		}
   
		
		workbook.close();
		file.close();
	}

}
