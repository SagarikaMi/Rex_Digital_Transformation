package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	//Declaration - use by annotation
	// xpath for email text field
	@FindBy(xpath="//input[@id='username']")
	private WebElement Email_Edt;
	
    // xpath for password textfield
	@FindBy (xpath="//input[@id='password']")
	private WebElement Password_Edt;
	
    //xpath for sign in with email
	@FindBy (xpath="//button[text()='Sign in']")
	private WebElement Sign_in_Btn;
	

	// Initialisation - provide getters
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization 
    
	public WebElement getEmail_Edt() {
		return Email_Edt;
	}

	public WebElement getPassword_Edt() {
		return Password_Edt;
	}

	
	public WebElement getSign_in_Btn() {
		return Sign_in_Btn;
	}

	
	// Business Library
	public void LoginToApp(String username, String password)
	{
		Email_Edt.sendKeys(username);
		Password_Edt.sendKeys(password);
		Sign_in_Btn.click();
	}

}
