package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static Properties prop;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Sanity", "Smoke", "Regression"})
	public void loadConfig() throws Throwable
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j2.xml");
		
		try
		{ 
		prop =  new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\Config.properties");
		prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static RemoteWebDriver getDriver()
	{
		return driver.get();
	}
	
	public void launchApp()
	{
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("GoogleChrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver.set( new ChromeDriver());
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//WebDriver driver = new FirefoxDriver();
			driver.set( new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			//WebDriver driver = new EdgeDriver();
			driver.set( new EdgeDriver());
		}
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
			getDriver().get(prop.getProperty("url"));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
	@AfterSuite(groups = {"Sanity", "Smoke", "Regression"})
	public void afterSuite()
	{
		ExtentManager.endReport();
	}
}
