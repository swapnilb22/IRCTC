/**
 * 
 */
package com.qa.irctc.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.irctc.base.TestBase;

/**
 * @author swapnil
 *
 */
public class TrainSearchPage extends TestBase
{
	Properties searchPageObj;	
	
	public TrainSearchPage()
	{
		PageFactory.initElements(driver, this);
				
	}
	
	public void loadprop()
	{
		FileInputStream ip;
		searchPageObj = new Properties();
		try {
			 ip = new FileInputStream("C:\\Users\\swapnil\\eclipse-workspace\\IRCTC\\src\\main\\java\\com\\qa\\irctc\\objectrepo\\TrainSearchPage.properties");
			searchPageObj.load(ip);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	String FromCity = searchPageObj.getProperty("From");

	@FindBy(xpath = "FromCity")
	private WebElement FromTextBox;

	public void searchTrains()
	{
		loadprop();
		waitforElement(FromTextBox);
		FromTextBox.sendKeys("Pune");
	}

}