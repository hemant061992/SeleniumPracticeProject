package day_27;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//select[@name='fromPort']")).sendKeys("Portland");
		driver.findElement(By.xpath("//select[@name='toPort']")).sendKeys("Rome");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		int rows =driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		System.out.println("Total Number Of Rows:"+rows);
		
		//captur price then store into array
		
		String priceArr[]=new String[rows];
		
		for(int r=1;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			priceArr[r-1]=price ; //adding price into array	
		}
		
		//sort price then find lower price value
		
		for(String arrayValue: priceArr)
		{
		  System.out.println(arrayValue);	
		}
		
		Arrays.sort(priceArr);
		String lowerprice=priceArr[0];
		String rpl_lowerprice=lowerprice.replace("$","");
		System.out.println("Lower Price Of Array Value is:"+rpl_lowerprice);
		
		//Find record in table having lower price
		
		for(int r=1;r<=rows;r++)
		{
			String price =driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			
			if(price.equals(lowerprice))
			{
				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[1]//input")).click();
				break;
			}
		}
		
		//Fill the details then click on Purchase Filight button

		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Sunil");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("US Gali No.4 Dwarka Street");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("New York");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Washington DC");
		driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("122001");
		driver.findElement(By.xpath("//select[@id='cardType']")).sendKeys("American Express");
		driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("SBI000HDFC8899");
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).clear();
		driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("12");
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).clear();
		driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2023");
		driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Hemant Kumar");
		driver.findElement(By.xpath("//input[@id='rememberMe']")).isSelected();
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		String Exp_Result="Thank you for your purchase today!";
		String Actual_Result=driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
		
		if(Exp_Result.equals(Actual_Result))
		{
			System.out.println("Test Is Passed...");
		}
		else
		{
			System.out.println("Test Is Failed...");
		}
		driver.quit();
		
	}

}
