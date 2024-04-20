package day_30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InteractwithElementsUsingJS {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// First name -InputBox

		WebElement inpubox = driver.findElement(By.xpath("//input[@id='name']"));// . sendKeys("Selnium Automation");
		js.executeScript("arguments[0].setAttribute('value','Selnium Automation')", inpubox);

		// Radio Button
		WebElement mal_Radio = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeAsyncScript("arguments[0].click();", mal_Radio);

		Thread.sleep(5000);

		driver.switchTo().frame(0);

		// button
		WebElement button = driver.findElement(By.id("FSsubmit"));
		js.executeScript("arguments[0].click();", button);

		driver.close();

	}

}
