package com.mystore.qa.testcases;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.Base;
import com.mystore.qa.pages.CreateAccountPage;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.SigninPage;
import com.mystore.qa.util.VaibhavExcelUtility;

public class CreateAccountTest extends Base{
	HomePage homepage;
	SigninPage signinpage;
	File fl;
	CreateAccountPage createaccountpage;
	MyAccountPage myaccountpage;
	
	public CreateAccountTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup() throws Exception
	{
		initialize();
		homepage = new HomePage();
		//signinpage = new SigninPage();  
	}
	
	@Test
	public void CreateAccount() throws Exception
	{

		String filename = System.getProperty("user.dir")+"\\src\\main\\java\\com\\mystore\\qa\\testdata\\testdata.xlsx";
		fl = new File(filename);
		
		// go to loginpage
		signinpage = homepage.clickonloginlink();
		
		
		// get new emailid to create account from excel file 
		ArrayList<String> createaccountdata = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "NewAccountEmail" );
		String newEmailIdToCreateAccount = createaccountdata.get(1);

		//enter newemailid and proceed...
		signinpage.createaccount(newEmailIdToCreateAccount);
		createaccountpage = signinpage.clickoncreateaccountbtn();
		
		
		// get all personal information in arraylist 
		ArrayList<String> personalInformationData = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "PersonalInformation" );
		

				
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String Usertype = personalInformationData.get(1);
		wait.until(ExpectedConditions.elementToBeClickable(createaccountpage.mrradio()));
		
		if(Usertype.equals("Mr"))
		{
			createaccountpage.selectmr();
		}
		else
		{
			createaccountpage.selectmrs();
		}
	
		String customerFirstName = personalInformationData.get(2);
		createaccountpage.entercustomerfirstName(customerFirstName);

		String customerLastName = personalInformationData.get(3);
		createaccountpage.entercustomerlastName(customerLastName);
		
		String customerPassword = personalInformationData.get(4);
		createaccountpage.entercCustomerpassword(customerPassword);
		
		String customerDayOfBirth = personalInformationData.get(5);
		createaccountpage.selectday(customerDayOfBirth);
		
		String customerMonthOfBirth = personalInformationData.get(6);
		createaccountpage.selectmonth(customerMonthOfBirth);
		
		String customerYearOfBirth = personalInformationData.get(7);
		createaccountpage.selectyear(customerYearOfBirth);
		
		
		ArrayList<String> addressInformationData = VaibhavExcelUtility.getdata(fl, "Sheet1", "Testcase", "AddressInformation");
		
		String addressFirstName = addressInformationData.get(1);
		createaccountpage.enteraddressfirstname(addressFirstName);
		
		String addressLastName = addressInformationData.get(2);
		createaccountpage.enteraddresslastname(addressLastName);
		
		String addressFirstLine = addressInformationData.get(3);
		createaccountpage.enteraddressline1(addressFirstLine);
		
		String addressCity = addressInformationData.get(4);
		createaccountpage.enteraddresscity(addressCity);
		
		String addressSelectState = addressInformationData.get(5);
		createaccountpage.selectstate(addressSelectState);
		
		String addressPostalCode = addressInformationData.get(6);
		createaccountpage.enteraddresspostalcode(addressPostalCode);
		
		String addressSelectCountry = addressInformationData.get(7);
		createaccountpage.selectcountry(addressSelectCountry);
		
		String addressMobilePhone = addressInformationData.get(8);
		createaccountpage.entermobilephonenumber(addressMobilePhone);
		
		myaccountpage =createaccountpage.clickonregisterbtn();
		
	}
	
	@AfterMethod
	public void teardown()
	{
	driver.quit();	
	}
}
