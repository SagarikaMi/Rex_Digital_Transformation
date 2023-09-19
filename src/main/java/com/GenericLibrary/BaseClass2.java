package com.GenericLibrary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Excel.data;
//check1

public class BaseClass2 {

	public ExcelfileUtility eLib = new ExcelfileUtility();
	public PropertyfileUtil pLib = new PropertyfileUtil();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib = new JavaUtility();
	public static WebDriver driver = null;
	public static WebDriver sdriver;
	
	 data da=new data();
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	// Initialize it to driver
	@Parameters("testname")
	@BeforeSuite
	public void setUp(@Optional("Smoke Test") String testname) {
		
		htmlReporter = new ExtentHtmlReporter("./testOutput/ExtentReport.html");
		htmlReporter.config().setDocumentTitle("RCNi-Learning");
		htmlReporter.config().setReportName(testname);
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS-name", System.getenv("OS"));
		extent.setSystemInfo("Device-name", "Windows");
		extent.setSystemInfo("Author", "sree harsha");		
	}
	
	@BeforeClass
	
	public void OpenBrowser() throws EncryptedDocumentException, IOException, InterruptedException
	{
        String browser = da.Read(1, 3);
		
		if(browser.equalsIgnoreCase("Mozilla")){
		  
		  System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		  
		  //Open Mozilla firefox browser
		  driver = new FirefoxDriver();
		 
		  
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		}
		
		else if(browser.equalsIgnoreCase("Chrome")){
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\samir.munde\\automation");
			//ChromeOptions chromeOptions = new ChromeOptions();
		       // chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
			  
			  //Open Chrome browser
			  driver = new ChromeDriver();
		
				driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}	
	
	}
	
	
	
	
	
	
	
	@BeforeMethod
	public void OpenUrl() throws EncryptedDocumentException, IOException
	{
//	String url = da.Read(1, 0);
	//Navigate to End user portal 
//	driver.navigate().to(url);
	}
	
	@AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
	
	 @AfterClass
	    public void CloseBrowser()
	    {
	    	
	    	driver.close(); 
	    }
	  
	    @AfterSuite
	    public void tearDown()
	    {
	    	
	    	
	        extent.flush();
	       // m.MailAfterExecution();
	        
	    }
    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

