package day_26;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAssignment {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> searchlinks = driver
				.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a"));

		System.out.println("Number Of Links:" + searchlinks.size());

		System.out.println("Printings & Clickings links.....");

		for (WebElement link : searchlinks) {
			System.out.println(link.getText());
			link.click();
		}

		// After opening all the pages, now capture windows ids 
		Set<String>windowsIds = driver.getWindowHandles();

		for (String winid : windowsIds) {
			String title = driver.switchTo().window(winid).getTitle();
			System.out.println(title);
		}

		driver.close();

	}

}
