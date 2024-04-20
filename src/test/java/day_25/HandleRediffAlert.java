package day_25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleRediffAlert {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println("Alert Text is:"+alert.getText());
		
		alert.accept();
		
		driver.close();

	}

}
