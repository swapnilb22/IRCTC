package com.qa.irctc.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.irctc.base.TestBase;
import com.qa.irctc.pages.TrainSearchPage;

public class NewTest extends TestBase 
{
	TrainSearchPage ts;
	
	public NewTest()
	{
		super();
	}
	
  @Test
  public void f() 
  {
	  ts = new TrainSearchPage();
	  
	  ts.searchTrains();
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  initialization();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
