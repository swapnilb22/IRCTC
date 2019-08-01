/**
 * 
 */
package com.qa.irctc.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.irctc.util.TestUtil;

/**
 * @author swapnil
 *
 */
public class TestBase 
{

	public static WebDriver driver;
	static WebDriverWait wait;	
	static Properties prop;

	//Reading the properties file 
	public TestBase()
	{
		prop = new Properties();
		FileInputStream fis;
		try
		{
			fis = new FileInputStream("C:\\Users\\swapnil\\eclipse-workspace\\IRCTC\\src\\main\\java\\com\\qa\\irctc\\config\\config.properties");
			prop.load(fis);
		}catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Common initialization method

	public static void initialization()
	{

		String browserName = prop.getProperty("BrowserName");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\swapnil\\eclipse-workspace\\WebDriver\\test\\scripts\\resources\\chromedriver.exe");
		}

		if(browserName.equalsIgnoreCase("other"))
		{

			try {
				throw new FileNotFoundException();
			} catch (FileNotFoundException e) {
				System.out.println("Set Chromediver path here");
				e.printStackTrace();
			}
		}

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		try {
				driver.get(prop.getProperty("url"));
			}catch (IllegalStateException e) {
				e.printStackTrace();
			}
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TIMEOUT, TimeUnit.SECONDS);
	}

	public static void waitforElement(WebElement el)
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(el));
	}

}
