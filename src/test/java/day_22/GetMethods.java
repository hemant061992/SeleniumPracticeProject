package day_22;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*get(url)
getTitle()
getCurrentURL()
getPageSource()
getWindowHandle()
getwindowHandles()
getText()
*/

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		
         WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		System.out.println("title of the page:" + driver.getTitle());

		System.out.println("Current URL:" + driver.getCurrentUrl());
		
		System.out.println("Page source......................");
		String ps=driver.getPageSource();
		//System.out.println(ps);
		System.out.println(ps.contains("html"));
		
		//System.out.println(driver.getWindowHandle());
		
		
		  Thread.sleep(3000);
		  driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // opens new browser window
		  
		  Set<String> windowids = driver.getWindowHandles();
		  
		  for (String winid : windowids) 
		  { 
			  System.out.println(winid); // CDwindow-B9429C1F5CC606A3981FAF0CD1A96DBC 
		                                //CDwindow-339CE5C5C5FB731B207639DE22EC40D1 
		  }
		
		driver.close();

	}

}
