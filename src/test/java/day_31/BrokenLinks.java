package day_31;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links :"+links.size());
		
		int brokenlinks=0;
		
		for( WebElement linkele:links)
		{
		  String hrefAttrValue=linkele.getAttribute("href");
		  
		  // pre-requisite for checking broken link
		  if(hrefAttrValue==null || hrefAttrValue.isEmpty())
		  {
		     System.out.println("href attribute value is empty.");	
		     continue;
		  }
		  
		  //Checking link is broken or not.
		  URL linkurl=new URL(hrefAttrValue);  // convert String --> URL format
		  
		  HttpURLConnection conn= (HttpURLConnection)linkurl.openConnection(); //send request to server - open , connect
		
		  conn.connect();
		  
		  if(conn.getResponseCode()>=400)
		  {
			  System.out.println(hrefAttrValue+"     "+"====> Broken Link");
			  brokenlinks++;
		  }
		  else
		  {
			  System.out.println(hrefAttrValue+"     "+"====> Not Broken Link");
		  }
		  
		  System.out.println("total number of broken links:"+brokenlinks);
			
		 
		}
		 driver.close();
	}

}
