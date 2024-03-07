package com.orangehrm.pageobjects;

import java.io.File;
//import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//img[@alt='company-branding']")
	public WebElement Logo;
	
	@FindBy(css = "input[name*='username']")
	public WebElement Username;
	
	@FindBy(css="input[name*='password']")
	public WebElement Password;
	
	@FindBy(css = "button[type='submit']")
	public WebElement LoginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	public boolean checklogo() throws Throwable
	{
		boolean chk = Logo.isDisplayed();
		File src = Logo.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\ADMIN\\eclipse-workspace\\OrangeHRM\\Screenshots\\screenshot.png");
		FileUtils.copyFile(src, des);
		return chk;
	}
	
	public HomePage checkLogin(String usrname, String psw)
	{
		Username.sendKeys(usrname);
		Password.sendKeys(psw);
		LoginBtn.click();
		HomePage homePage = new HomePage();
		return homePage;
		
	}
}
