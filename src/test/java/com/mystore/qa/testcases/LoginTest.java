package com.mystore.qa.testcases;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.Base;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.SigninPage;
import com.mystore.qa.util.VaibhavExcelUtility;

public class LoginTest extends Base {

	HomePage homepage;
	SigninPage signinpage;
	MyAccountPage myaccountpage;
	
	File fl;
	
	// call test base constructor by using super method
	
	public LoginTest() 
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialize();
		homepage = new HomePage();
		//signinpage = new SigninPage();  
	}
	
	@Test(priority=1)
	public void checkcorrectloginTest() throws Exception
	{
		signinpage = homepage.clickonloginlink();
		String filename = System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\qa\\testdata\\testdata.xlsx";
		fl = new File(filename);
		
		ArrayList<String> credentials = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "Accountinformation");
		String userEmail = credentials.get(1);
		String userPassword = credentials.get(2);
		myaccountpage = signinpage.dologin(userEmail, userPassword);
		String userName = myaccountpage.username();
		System.out.println(userName +" logged in successfully");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();	
	}
	
}
