package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericLibrary.BaseClass1;

public class Home_pageObj extends BaseClass1
{
@FindBy(xpath="//div[text()='Welcome, Admin']")
private WebElement Header_of_homepage;

public Home_pageObj(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public WebElement header_page() {
	return Header_of_homepage ;}

public boolean header_display() 
{
return Header_of_homepage.isDisplayed();
}}
