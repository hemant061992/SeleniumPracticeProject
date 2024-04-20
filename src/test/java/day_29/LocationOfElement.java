package day_29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocationOfElement {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		
		
		/*
		 * System.out.println("Before Minimizing window"+logo.getLocation());//276, 41
		 * 
		 * driver.manage().window().maximize();
		 * System.out.println("After Maximizing window"+logo.getLocation());//476, 53
		 * 
		 * driver.manage().window().minimize();
		 * System.out.println("After minimizing window"+logo.getLocation());//476, 51
		 * 
		 * driver.manage().window().fullscreen();
		 * System.out.println("After fullscreen the window"+logo.getLocation());//476,
		 * 114
		 */		 		
		/*
		 * Point p=new Point(100,100); driver.manage().window().setPosition(p);
		 * System.out.println("After setting window 100 * 100:"+logo.getLocation());
		 * //(277, 42)
		 */
		
		
		  Point p=new Point (1280,720); 
		  driver.manage().window().setPosition(p);
		  System.out.println("After setting window 1280 * 720:"+logo.getLocation());
		 
		

	}

}
