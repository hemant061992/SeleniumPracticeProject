package pack1;

import org.testng.annotations.*;

public class Class1 {
	
	@Test
	void abc()
	{
		System.out.println("this is abc method from Class 1");
	}
	
	@Test
	void xyz()
	{
		System.out.println("this is xyz method from Class 2");
	}
	
	@BeforeMethod
	void m1()
	{
		System.out.println("this is before method...");
	}
	
	@BeforeTest
	void m()
	{
		System.out.println("this is before test method...");
	}
	
	@BeforeSuite
	void bs()
	{
	 System.out.println("this is Before suite method...");	
	}
	
	@AfterSuite
	void as()
	{
		System.out.println("this is After suite method...");
	}

}
