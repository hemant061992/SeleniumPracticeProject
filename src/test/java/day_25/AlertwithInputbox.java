package day_25;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertwithInputbox {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//div[@class='example']//button)[3]")).click();
		
		Alert alert= driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		alert.sendKeys("Welcome");
		
		alert.accept();
		
		String act_Title=driver.findElement(By.xpath("//p[@id='result']")).getText();

		String Exp_Title="You entered: Welcome";
		
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
