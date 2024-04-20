package day_29;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		
		WebElement madrid=driver.findElement(By.xpath("(//div[text()='Washington'])[2]"));
		
		WebElement denmark=driver.findElement(By.xpath("//div[text()='United States']"));
		
		Actions act=new Actions(driver);
		
		act.dragAndDrop(madrid, denmark).build().perform();		

	}

}
