package day_24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDownwithSelectTag {

	public static void main(String[] args) {
		
       WebDriver driver=new ChromeDriver();
       
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
       driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
       driver.manage().window().maximize();
       
       WebElement element=driver.findElement(By.xpath("//select[@id='country-list']"));
       
       Select select =new Select(element);
       
     //1) Selecting an option from the dropdown
           //select.selectByVisibleText("India");
           //select.selectByValue("4");  
           // select.selectByIndex(5);
       
     //2)Find total options in dropdown
      List<WebElement>  options=select.getOptions();
     //List<WebElement> options=driver.findElements(By.xpath("//select[@id='country-list']"));
     System.out.println("Total Numbers Of Options:"+options.size());
     
     //3)Print all the Option in console window
		
		  for(int i=1; i<options.size();i++) {
		  System.out.println("Display All the Options Value:"+options.get(i).getText())
		  ; }
		 
		/*
		 * for (WebElement op:options) { System.out.println(op.getText()); }
		 */
      
      driver.quit();
	}

}
