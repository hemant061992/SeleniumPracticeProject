package SeleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver;
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://qaadmin.diabeticu.net/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq']"))
				.sendKeys("qa_admin@yopmail.com");
		driver.findElement(By.xpath(
				"//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2']"))
				.sendKeys("Admin@123");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		
		driver.findElement(By.xpath("//label[text()='Security Code*']/following::input")).sendKeys("1234");
		
		driver.findElement(By.xpath("//button[contains(text(), 'Verify')]")).click();

	}

}
