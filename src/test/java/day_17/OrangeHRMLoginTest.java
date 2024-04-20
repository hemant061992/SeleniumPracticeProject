package day_17;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1) Launch browser
2) open url
	https://opensource-demo.orangehrmlive.com/
3) Provide username  - Admin
4) Provide password  - admin123
5) Click on Login button 
6) Verify the title of dashboard page   
	Exp title : OrangeHRM
7) close browser

 */

public class OrangeHRMLoginTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		/* Title Validation
		 * String act_Title=driver.getTitle(); System.out.println(act_Title);
		 * 
		 * String exc_Title="OrangeHRM";
		 * 
		 * if(act_Title.equals(exc_Title)) { System.out.println("Test is Passed"); }
		 * else { System.out.println("Test is Failed"); }
		 */
		
		  Thread.sleep(5000);
		
		 //Label validation
		
		 String act_Title= driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
		 String exp_Title="Dashboard";
		 
		if (act_Title.equals(exp_Title)) {
			
			System.out.println("Test is Passed");
		} else {
			
			System.out.println("Test is Failed");
		}
		
		//driver.close();
		driver.quit();
		
	}

}
