package day_17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NOPCommorceLoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
	   WebDriver driver=new ChromeDriver();
	   driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	   driver.manage().window().maximize();
	   
	   driver.navigate().refresh();
	  
	   driver.findElement(By.xpath("//input[@type='email']")).clear();
	   driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@yourstore.com");
	   driver.findElement(By.xpath("//input[@type='password']")).clear();
	   driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	   driver.findElement(By.xpath("//button[@type='submit']")).click();
	   
	   String act_Title=driver.findElement(By.xpath("//h1[text()[normalize-space()='Dashboard']]")).getText();
	   String exp_Title="Dashboard";
	   
	   if(act_Title.equals(exp_Title))
	   {
		   System.out.println("Test is Passed");
	   }
	    
	   else
	   {
		   System.out.println("Test is Failed");
	   }
	   
	   driver.quit();
	}
}
