package Sanity_suite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass1;
import com.GenericLibrary.PropertyfileUtil;
import com.ObjectRepository.Login_Page;


public class LoginToApp extends BaseClass1
{
	
	@Test(enabled = true, priority = 1)
	public void signin_To_application() throws IOException, InterruptedException {
		test = extent.createTest("Validation of Rex Login and Logout ");
		String USERNAME = pLib.readfrompropertyfile("username");
		String PASSWORD = pLib.readfrompropertyfile("password");
		Login_Page lp = new Login_Page(driver);
		PropertyfileUtil pLib=new PropertyfileUtil();
		lp.getEmail_Edt().sendKeys(USERNAME);
		lp.getPassword_Edt().sendKeys(PASSWORD);
		lp.getSign_in_Btn().click();
		

	}
}

