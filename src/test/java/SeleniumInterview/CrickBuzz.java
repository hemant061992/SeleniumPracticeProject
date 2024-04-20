package SeleniumInterview;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrickBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	 WebDriver driver;	
	 WebDriverManager.chromedriver().setup();
	 
	 driver=new ChromeDriver();
	 driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/women/batting");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 WebElement ele= driver.findElement(By.xpath("//a[@id='batsmen-t20s-tab']"));//.click();
	 ele.click();
	 System.out.println("Value Of The Element:"+ele.getText());
	 
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	
	 WebElement flag=driver.findElement(By.xpath("(//img[@alt='Hayley Matthews'])[2]"));
	 
	 js.executeScript("arguments[0].scrollIntoView();", flag);
	 
	 System.out.println("Scroll is Working Fine");
	 
	 driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 cb-padding-left0']//a[@title=\"Hayley Matthews's Profile\"][normalize-space()='Hayley Matthews']")).click();
	  
	 String Exp_Result="Hayley Matthews";
	 String Act_Result=driver.findElement(By.xpath("//h1[normalize-space()='Hayley Matthews']")).getText();
	 
	 if(Exp_Result.equals(Act_Result))
	 {
		 System.out.println("Test Is Passed....");
	 }
	 else
	 {
		 System.out.println("Test Is Failed Passed....");
	 }
		
	 driver.quit();
	}

}
