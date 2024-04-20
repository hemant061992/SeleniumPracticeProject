package day_27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1) Find total number of rows

		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("Total Number Of Rows:" + rows);

		// 2) Find total number of columns

		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
		System.out.println("Total Number Of Columns Is:" + cols);

		// 3) Read specific row & column data

		String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]//td[1]")).getText();
		System.out.println(value);

		/*
		 * //4) Read data from all the rows & columns
		 * 
		 * for(int r=2;r<=rows;r++) { for(int c=1;c<=cols;c++) { String
		 * values=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+
		 * "]//td["+c+"]")).getText(); System.out.print(values+"\t"); }
		 * 
		 * System.out.println(); }
		 */

		// 5) Print book names whose author is Amit

		for (int r = 2; r < rows; r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]")).getText();
			System.out.println(author);

			if (author.equals("Amod")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]"))
						.getText();
				System.out.println(author + "    " + bookName);
			}
		}

		// 6)Find sum of prices for all the books

		int sum = 0;
		for (int r = 2; r <= rows; r++) {
			
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			sum = sum + Integer.parseInt(price);	
		}
		System.out.println("Some of Total Price:"+sum);
		
	}

}
