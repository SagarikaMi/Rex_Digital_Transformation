package Sanity_suite;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass1;
import com.ObjectRepository.*;

public class Home_Page extends BaseClass1
{
	@Test
	public void verify_header() throws IOException, InterruptedException
	{
     Home_pageObj hp= new Home_pageObj(driver);
	 LoginToApp lp=new LoginToApp();
	 lp.signin_To_application();
	 Assert.assertTrue(hp.header_display());
	test.info("Header is verfied");
	}

}
