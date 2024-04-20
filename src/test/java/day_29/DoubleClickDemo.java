package day_29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		
		WebElement f1=driver.findElement(By.xpath("//input[@value='Hello World!']"));
		f1.clear();
		
	    f1.sendKeys("Welcome in this site...");
	    
	    WebElement button = driver.findElement(By.xpath("//button[text()='Copy Text']"));
	    
	    Actions act=new Actions(driver);
	    
	    act.doubleClick(button).perform();
	    
	    WebElement f2=driver.findElement(By.xpath("//input[@id='field2']"));
	    
	    String copiedText=f2.getAttribute("value");
	    
	    System.out.println("Copied Text Is:"+copiedText);
	    
	    if(copiedText.equals("Welcome in this site..."))
	    {
	      System.out.println("Test is Passed");	
	    }
	    else
	    {
	      System.out.println("Test is Failed");
	    }
	    
	    driver.close();
	}

}
