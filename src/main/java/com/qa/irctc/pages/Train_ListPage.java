package com.qa.irctc.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.irctc.base.TestBase;

public class Train_ListPage extends TestBase
{
	
	Properties TrainListPageObj;
	
	static String path = "C:\\Users\\swapnil\\eclipse-workspace\\IRCTC\\src\\main\\java\\com\\qa\\irctc\\objectrepo\\Train_ListPage.properties";
	public Train_ListPage()
	{
		super();
		PageFactory.initElements(driver, this);

			FileInputStream ip;
			TrainListPageObj = new Properties();
			try {
				ip = new FileInputStream(path);
				TrainListPageObj.load(ip);
			}catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}catch(IOException e)
			{
				e.printStackTrace();
			}

	}
		
	public void getTrainList()
	{
//		HashMap<WebElement, WebElement> hs = new HashMap<WebElement, WebElement>();
//		hs.put(driver.findElements(By.xpath(TrainListPageObj.getProperty("trainNameclass"))), driver.findElements(By.xpath(TrainListPageObj.getProperty("journytime"));
	}
	
	
	}


