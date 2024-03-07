package com.orangehrm.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pageobjects.HomePage;
import com.orangehrm.pageobjects.LoginPage;
import com.orangehrm.utility.Log;
import com.orangehrm.dataprovider.DataProviders;

public class LoginPageTest extends BaseClass {
	
	HomePage homePage ;
	LoginPage loginPage ;
	
	@BeforeTest
	public void setup() throws Throwable
	{
		launchApp();
		homePage = new HomePage();
		loginPage = new LoginPage();
		Thread.sleep(5000);
	}
	
	@AfterTest
	public void teardown()
	{
		getDriver().quit();
	}
	
	
	@Test(priority = 1)
	public void checkLogoTest() throws Throwable
	{
		Log.startTestCase("LogoTest started");
		boolean result = loginPage.checklogo();
		Assert.assertTrue(result);
		Log.info("Logo is visible");
		Thread.sleep(4000);
		Log.endTestCase("Logo Test ended");
	}
	
	@Test(priority = 2, dataProvider="Credentials", dataProviderClass = DataProviders.class)
	public void checkLoginTest(String Username, String Password) throws Throwable
	{
		Log.startTestCase("LoginTest started");
		Log.info("Enter Username and Password");
		homePage = loginPage.checkLogin(Username, Password);
		Thread.sleep(5000);
		Log.info(" Login Successful");
		Log.endTestCase("LoginTest ended");
	}
	
}
