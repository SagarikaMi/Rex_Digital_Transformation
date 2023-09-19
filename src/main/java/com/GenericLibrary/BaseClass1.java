package com.GenericLibrary;

import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ObjectRepository.Login_Page;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.relevantcodes.extentreports.LogStatus;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {
	// create object for all utilities
	public ExcelfileUtility eLib= new ExcelfileUtility();
	//  public DataBaseUtility dbLib=new DataBaseUtility();
	public PropertyfileUtil pLib= new PropertyfileUtil();
	public WebDriverUtility wLib=new WebDriverUtility();
	public JavaUtility jLib=new JavaUtility();
	public static  WebDriver driver=null;
	public static WebDriver sdriver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	//Initialize it to driver
	//		@BeforeSuite(groups={"smokeSuite","RegressionSuite"})
	@Parameters("testname")
	@BeforeSuite
	public void setUp(@Optional("Smoke Test")String testname)
	{
		htmlReporter = new ExtentHtmlReporter("./testOutput/ExtentReport.html");
		htmlReporter.config().setDocumentTitle("REX WEB APP");
		htmlReporter.config().setReportName(testname);
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("OS-name", System.getenv("OS"));
		extent.setSystemInfo("Device-name", "Windows");
		extent.setSystemInfo("Author", "sree harsha");
	}
	//@Parameters("browser")
	//		@BeforeTest
	//		@BeforeClass(groups={"smokeSuite","RegressionSuite"})
	@BeforeClass
	public void launchThebrowser() throws Throwable
	{
//		//		//read the data from property file
//		String BROWSER = pLib.readfrompropertyfile("browser");
//		String URL = pLib.readfrompropertyfile("url");
//		//		//String URL=eLib.readthedatafroExcel("Sheet1", 0, 1);
//		//		//String BROWSER=eLib.readthedatafroExcel("Sheet1", 3, 1);
//		//	create RunTime Polymorphisem
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox"))
//		{
//			WebDriverManager.firefoxdriver().setup();
//			driver = new FirefoxDriver();
//		}else{
//			System.out.println("Invaild Browser");
//		}
//
//		sdriver=driver;
//		wLib.maximizewindow(driver);
//		wLib.waitforthePageLoad(driver);
//		driver.get(URL);
	}
	@BeforeMethod
	public void Login(ITestResult result) throws IOException, Throwable
	{
//		//read the data from property file
		String BROWSER = pLib.readfrompropertyfile("browser");
		String URL = pLib.readfrompropertyfile("url");
		//		//String URL=eLib.readthedatafroExcel("Sheet1", 0, 1);
		//		//String BROWSER=eLib.readthedatafroExcel("Sheet1", 3, 1);
		//	create RunTime Polymorphisem
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
		
			driver = new FirefoxDriver();
		}else{
			System.out.println("Invaild Browser");
		}

		sdriver=driver;
		wLib.maximizewindow(driver);
		wLib.waitforthePageLoad(driver);
		driver.get(URL);
	}
	@AfterMethod
	public void closethebrowser()
	{
		
	}

	@AfterClass
	public void close1()
	{
		//driver.close();
	}
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
}


