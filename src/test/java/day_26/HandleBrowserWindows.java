package day_26;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		// capture id's for browser windows
		Set<String> windowsIDS = driver.getWindowHandles();

		System.out.println("Capture the IDS Of windows:" + windowsIDS); // store 2 window id's

		// Approach1 - using List collection

		/*
		 * List<String> windowsList = new ArrayList(windowsIDS); // converted Set
		 * --->List String ParentwindowsIds = windowsList.get(0); String ChildwindowsIds
		 * = windowsList.get(1);
		 * 
		 * //Switch to Child window driver.switchTo().window(ChildwindowsIds);
		 * driver.findElement(By.
		 * xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		 * System.out.println("Child Window Id's ="+ChildwindowsIds);
		 * 
		 * // Switch to Back Parent windows driver.switchTo().window(ParentwindowsIds);
		 * driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(
		 * "Admin"); System.out.println("Parent Window Id's ="+ParentwindowsIds);
		 */
		// Approach 2

		for (String wid : windowsIDS) {
			String text = driver.switchTo().window(wid).getTitle();

			if (text.equals("OrangeHRM HR Software | OrangeHRM")) {
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
				System.out.println(text);
			}
		}

		// closing specific browser windows based on choice
		// 1-x 2-y 3-z 4-a 5-b...........

		/*
		 * for(String winIds:windowsIDS) { String
		 * title=driver.switchTo().window(winIds).getTitle();
		 * 
		 * if(title.equals("OrangeHRM")) { driver.close(); System.out.println(title); }
		 * }
		 */

		/*
		 * for(String strids :windowsIDS) { String
		 * title1=driver.switchTo().window(strids).getTitle();
		 * 
		 * if(title1.equals("Get in Touch with OrangeHRM Sales | OrangeHRM")) {
		 * driver.close(); System.out.println(title1); } }
		 */

	}
}
