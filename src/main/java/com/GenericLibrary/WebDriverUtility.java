package com.GenericLibrary;

	import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;

	/**
	 * This class consists of all generic methods related to the webdriver actions
	 * @author sree harsha
	 *
	 */
	public class WebDriverUtility 
	{
		WebDriver driver = null;
		/**
		 * this method will use maximize the window
		 * @param driver
		 */
//		WebDriverUtility(WebDriver driver){
//			this.driver= driver;
//		}
		
		public Boolean waitTillElementVisible(WebDriver driver, String locator){
			try {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
				   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
				return true;
			}catch (Exception e){
				return false;
			}
				
		}
	   public void maximizewindow(WebDriver driver)
	   {
		   driver.manage().window().maximize(); 
	   }
	   /**
	    * This method will wait for 20 seconds for the element to be visibility
	    * @param driver
	    */
	   public void waitforthePageLoad(WebDriver driver)
	   {
		   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   }
	   /**
	    * This method will wait for 20 seconds for the element to be  visible
	    * @param driver
	    * @param element
	    */
	   public void waitForElementTobeClickable(WebDriver driver,WebElement element)
	   {
		   WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		   wait.until(ExpectedConditions.visibilityOf(element));
	   }
	   public void waitForElementTobeClickable(String locator)
	   {
		   WebElement element = driver.findElement(By.xpath(locator));
		   WebDriverWait wait = new WebDriverWait( driver,Duration.ofSeconds(30));
		   wait.until(ExpectedConditions.visibilityOf(element));
	   }
	   /**
	    * This method will select data from dropdown using index
	    * @param element
	    * @param index
	    */
	   public void select(WebElement element, int index) 
	   {
		   Select sel= new Select(element);
		   sel.selectByIndex(index);
	   }
	   /**
	    * This method will select data from dropdown using visible text
	    * @param element
	    * @param text
	    */
	   public void select(WebElement element, String text)
	   {
		   Select sel= new Select(element);
		     sel.selectByVisibleText (text);
	   }
	   /**
	    * This method will select data from dropdown using visible value
	    * @param value
	    * @param element
	    */
	   
	   public void select( String value,WebElement element)
	   {
		   Select sel= new Select(element);
	     sel.selectByValue(value);
	   }
	   /**
	    * This Method will perform Mouse Hover Action
	    * @param driver
	    * @param element
	    */
	   public void mousHover(WebDriver driver,WebElement element)
	   {
		  Actions act=new Actions(driver);
		  act.moveToElement(element).perform();
	   }
	   /**
	    * This will perform drag and drop action
	    * @param driver
	    * @param src
	    * @param target
	    */
	   public void dragAndDrop(WebDriver driver, WebElement src,WebElement target)
	   {
		   Actions act = new Actions(driver);
		   act.dragAndDrop(src, target).perform();
	   }
	   /**
	    * This Method will be use Double click on Element
	    * @param elemet
	    * @param driver
	    */
	   public void doubleclickAction(WebElement element,WebDriver driver)
	   {
		   Actions act = new Actions(driver);
		   act.doubleClick(element).perform();
	   }
	   /**
	    * This Method will right click on web page
	    * @param driver
	    */
	   public void rightClickAction(WebDriver driver,WebElement element)
	   {
		   Actions act= new Actions(driver);
		   act.contextClick(element).perform();
	   }
	   /**
	    * This Method will use to press enter key
	    * @param driver
	    * @param element
	    */
	   public void rightclick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
		   
	   }
	   /**
	    * This Method will used to switch to frame based on index
	    * @param driver
	    * @param index
	    */
	   public void switchToFrame(WebDriver driver, int index)
	   {
		   driver.switchTo().frame(index);
	   }
	   /**
	    * This Method will switch the frame based on Name or ID 
	    * @param driver
	    * @param nameOrID
	    */
	   public void switchToFrame(WebDriver driver,String nameOrID)
	   {
		   driver.switchTo().frame(nameOrID);
	   }
	   /**
	    * This Method will be the frame based on address of the element
	    * @param driver
	    * @param adress
	    */
	   public void SwithToFrame(WebDriver driver, WebElement adress)
	   {
		   driver.switchTo().frame(adress);
	   }
	   /**
	    * This Method will accept the alert popup
	    * @param driver
	    */
	   public void acceptAllert(WebDriver driver)
	   {
		   driver.switchTo().alert().accept();
	   }
	   /**
	    * This Methods will dismiss the alert pop- up
	    * @param driver
	    */
	   public void dismisstheAllert(WebDriver driver)
	   {
		  driver.switchTo().alert().dismiss(); 
	   }
	   public void swithtowindowHandles(WebDriver driver,String PartialWinTitle)
	   {
		   //step:1 to use get window handles to capture all window ids
		  Set<String> windows = driver.getWindowHandles();
		  //step:2 iterate thru windows
		  Iterator<String> it = windows.iterator();
		  while(it.hasNext())
		  { 
			  //step:3 capture current window id
			  String windid = it.next();
			  //step:4 switch to current window and capture title
			  String currntWindowTitle = driver.switchTo().window(windid).getTitle();
			  //step:5 check whether current window is expected
			  if(currntWindowTitle.contains(PartialWinTitle))
			  {
				  break;
			  }
		  }
		  
	   }
	   /**
	    * This Method will take screenshot and store it in folder called as screenshot
	    * @param driver
	    * @param screenshotName
	 * @throws Throwable 
	    */
	   public String getScreenshot(WebDriver driver, String screenshotName) throws Throwable
	   {
		   String path=".\\sreenshot\\"+screenshotName+".png";
		   TakesScreenshot ts= (TakesScreenshot) driver;
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        File dst = new File(path);
	        Files.copy(src, dst);
	        return path;
	   } 
	   /**
	    * This Method will perform random scroll
	    * @param driver
	    */
	      public void scrollAction(WebDriver driver)
	   {
		   JavascriptExecutor js= (JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,500)", "");
	   }
	      /**
	       * This Method will scroll until the specified element is found
	       * @param driver
	       * @param element
	       */
	      public void scrollAction(WebDriver driver,WebElement element)
	      {
	    	  JavascriptExecutor js=(JavascriptExecutor) driver;
	    	 int y = element.getLocation().getY();
	    	 js.executeScript("window.scrollBy(0,"+y+")", element);
	    	 //js.executescript(argument[0].scrollintoview()",element();
	      }
	      public void mouse(WebDriver driver,WebElement element, WebElement ele2)
		   {
			  Actions act=new Actions(driver);
			  act.moveToElement(element).moveToElement(ele2).click().perform();
		   }
		   /**
		    * This will perform drag and drop action
		    * @param driver
		    * @param src
		    * @param target
		 * @throws IOException 
		    */
	      
	      public String takeScreenshot(WebDriver driver, String scriptName) throws IOException {
	    	  EventFiringWebDriver event=new EventFiringWebDriver(driver);
	    	  File src = event.getScreenshotAs(OutputType.FILE);
	    	  File dest = new File("./screenshots/"+scriptName+".png");
	    	  Files.copy(src, dest);
	    	  return dest.getAbsolutePath();
	      }
	      public void scrollToEnd(WebDriver driver) {
	    	  JavascriptExecutor script = (JavascriptExecutor) driver;
	    	  script.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	      }
	      public void changeToWindow(WebDriver driver, WebElement element) {
	    	  driver.switchTo().frame(element);
	      }
	}



