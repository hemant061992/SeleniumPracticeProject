package pack1;

import org.testng.annotations.*;

public class Class2 {

	@Test
	void xyz()
	{
		System.out.println("this is xyz from class 2");
	}
	
	@Test
	void abcd()
	{
		System.out.println("this is abcd from class 2");
	}
	
	@AfterTest
	void n()
	{
		System.out.println("this is after test method..");
	}
	
}
