//package com.GenericLibrary;
//
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.GenericLibrary.IpathContrants.IpathofContrants;
//
///**
// * This class contains genricmethod to read data from db     
// * @author sree.harsha
// *
// */
//
//public class DataBaseUtility 
//{
//	Connection con=null;
//	public void connectToDB() throws Throwable
//	{
//		Driver driver=new Driver();
//		DriverManager.registerDriver(driver);
//		con=DriverManager.getConnection(IpathofContrants.Excelpath);
//
//	}
//	/**
//	 * This Method will close database connection
//	 * @throws Throwable
//	 */
//	public void closedb() throws Throwable
//	{
//		con.close();
//	}
//	/**
//	 * This Method will execute the query and return the mathing data to user
//	 * @param query
//	 * @param columnindex
//	 * @param Expdata
//	 * @throws Throwable
//	 */
//	public String executequeryAndGetdata(String query,int columnindex,String Expdata) throws Throwable
//	{
//		String data = null;
//		boolean flag= false;
//		ResultSet result = con.createStatement().executeQuery(query);
//		while(result.next())
//		{
//			data=result.getString(columnindex);
//			{
//				flag=true;//flag rising
//				break;
//			}
//		}	
//		if(flag)
//		{
//			System.out.println(data +"------> data verified");
//			return Expdata;
//		}else{
//			System.out.println("data not verifind");
//			return"";
//		}
//	}
//}
//
//
