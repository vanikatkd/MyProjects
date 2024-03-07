package com.orangehrm.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orangehrm.base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
	private WebElement dropdown;
	
	@FindBy(css = "a[class='oxd-main-menu-item active'] span[class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	private WebElement myinfo;
	
	@FindBy(css ="input[placeholder='First Name']")
	private WebElement firstname;
	
	@FindBy(css = "input[placeholder='Last Name']")
	private WebElement lastname;
	
	@FindBy(xpath = "(//i)[9]")
	private WebElement calendar;
	
}
