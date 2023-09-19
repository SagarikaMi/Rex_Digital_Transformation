package com.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.GenericLibrary.IpathConstants;
	/**
	 * This file will read date from property file and return to user
	 * @author sree harsha
	 *
	 */
	public class PropertyfileUtil
	{
		/**
		 * This method will read the data from property file for the key given by user
		 * @param key
		 * @return
		 * @throws IOException 
		 * @throws Throwable
		 */
	   public String readfrompropertyfile(String key) throws IOException 
	   {
		   FileInputStream fis = new FileInputStream(IpathConstants.PropertyFile);
	       Properties Plib=new Properties();
	       Plib.load(fis);
	       String value = Plib.getProperty(key);
	       return value;
	   }
	}


