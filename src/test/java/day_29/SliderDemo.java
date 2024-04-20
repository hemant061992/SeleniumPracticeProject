package day_29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
	    WebElement min_Slider=driver.findElement(By.xpath("//span[1]"));
	    System.out.println("Current Location of Min Slider Is:"+min_Slider.getLocation()); //59,250
	    
	    Actions act=new Actions(driver);
	    act.dragAndDropBy(min_Slider, 150, 250).perform();
	    System.out.println("Location of Min Slider After moving Is:"+min_Slider.getLocation());
	    

	    WebElement max_Slider=driver.findElement(By.xpath("//span[2]"));
	    System.out.println("Current Location of Max Slider Is:"+max_Slider.getLocation()); //612, 250
	    
	    act.dragAndDropBy(max_Slider, -112, 250).perform();
	    System.out.println("Location of Max Slider After moving Is:"+max_Slider.getLocation());
	    
	    driver.close();
	}

}
