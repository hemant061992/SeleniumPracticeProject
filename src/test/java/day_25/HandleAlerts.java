package day_25;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
	    Alert alert=driver.switchTo().alert();
	    System.out.println(alert.getText());
	    
        alert.accept();
        //alert.dismiss();
        
        String act_Result=driver.findElement(By.xpath("//p[@id='result']")).getText();
        System.out.println("Actual Result Is:"+act_Result);
        String expt_Result="You clicked: Ok";
        
        if(act_Result.equals(expt_Result))
        {
           
           System.out.println("Test is Passed");	
        }
        else
        {
        	System.out.println("Test is Failed");
        }
        
	}

}
