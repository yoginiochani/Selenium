package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class All_annotations_execution {
	@BeforeSuite
	  public void beforeSuite() {
		  System.out.println("This is before suite, which is execute 1st: 1");
	  }
	
	@BeforeTest
	  public void beforeTest() {
		  System.out.println("This is before test, which is exeuted 2nd: 2");
	  }
	
	@BeforeClass
	  public void beforeClass() {
		  System.out.println("This is before class, which is executed 3rd: 3");
	  }
	
	@BeforeMethod
	  public void beforeMethod() {
		  System.out.println("This is before method, which is executed 4th: 4");
	  }
	
	@Test(priority = 0)
	public void test() {
	  System.out.println("This is the first test, which is executed 5th: 5");
	}
	
	@AfterMethod
	  public void afterMethod() {
		  System.out.println("This is after method, which is executed 6th: 6");
	  }
	
	@Test(priority = 1)
	public void test2()
	{
		System.out.println("This is second test, which is executed second after first one");
		
	}
  
  
  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class, whihc is executed 7th: 7");
  }
  
  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test, which is executed 8th: 8");
  }

  

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite, which is executed last");
  }

}
