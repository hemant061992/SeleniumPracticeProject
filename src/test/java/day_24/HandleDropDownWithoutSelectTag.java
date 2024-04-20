package day_24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropDownWithoutSelectTag {

	public static void main(String[] args) {
		
		
	   WebDriver driver=new ChromeDriver();	
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	   driver.manage().window().maximize();
	   
	   driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
	   List<WebElement> option= driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
	   
	   System.out.println("Total Number Of Options Is:"+option.size());
	   
	   //Using simple for loop
	   for(int i=0;i<option.size();i++)
	   {
		  System.out.println(option.get(i).getText());
		   
		  String str= option.get(i).getText();
		  
		  if(str.equals("Java") ||str.equals("MS SQL Server"))
		  {
			  option.get(i).click();
		  }
		  
	   }
	   
	   //Using for each loop
		/*
		 * for(WebElement op:option) {
		 * System.out.println("Using For EachLoop::"+op.getText()); String
		 * text=op.getText(); if(text.equals("C#")||text.equals("jQuery")) { op.click();
		 * } }
		 */
	   
	  // driver.close();
	  
	}

}
