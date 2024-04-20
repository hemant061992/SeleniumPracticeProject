package day_25;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertBox {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		
		Alert alert=driver.switchTo().alert();
		System.out.println("Ater Text Is:"+alert.getText());
		
		alert.accept();
		
		String act_Title=driver.findElement(By.xpath("//p[@id='result']")).getText();
		String Exp_Title="You successfully clicked an alert";
		System.out.println("Actual Text Is:"+act_Title);
		if(act_Title.equals(Exp_Title))
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
