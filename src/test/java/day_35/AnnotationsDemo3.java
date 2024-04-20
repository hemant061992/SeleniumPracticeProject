package day_35;

import org.testng.annotations.*;

public class AnnotationsDemo3 {

	@BeforeTest
	void login()
	{
		System.out.println("Login...");
	}
		
	@Test(priority=1)
	void search()
	{
		System.out.println("Search...");
	}
	
	@Test(priority=2)
	void advacedsearch()
	{
		System.out.println("Advanced search...");
	}
	
	@AfterTest
	void logout()
	{
		System.out.println("Logout...");
	}

	
}
