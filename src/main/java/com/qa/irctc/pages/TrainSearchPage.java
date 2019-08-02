/**
 * 
 */
package com.qa.irctc.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
	static String path = "C:\\Users\\swapnil\\eclipse-workspace\\IRCTC\\src\\main\\java\\com\\qa\\irctc\\objectrepo\\TrainSearchPage.properties";

	public TrainSearchPage()
	{
		super();
		PageFactory.initElements(driver, this);

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
	
	


	public Train_ListPage searchTrains()
	{
		WebElement From  = driver.findElement(By.xpath(searchPageObj.getProperty("From")));
		waitforElement(From);
		From.sendKeys("PUNE JN - PUNE");
		
		WebElement To = driver.findElement(By.xpath(searchPageObj.getProperty("To")));
		To.sendKeys("MUMBAI CENTRAL - BCT");
		
		WebElement Date = driver.findElement(By.xpath(searchPageObj.getProperty("DatepickerField")));
		Date.clear();
		Date.sendKeys("15-08-2019");
		
		WebElement FlexibleDate = driver.findElement(By.xpath(searchPageObj.getProperty("FlexibleDateCheckBox")));
		
		if(!FlexibleDate.isSelected())
		{
			FlexibleDate.click();
		}
		
		WebElement FindBtn = driver.findElement(By.xpath(searchPageObj.getProperty("FindTrainsButton")));
		FindBtn.click();
	
		return new Train_ListPage();
	}

}