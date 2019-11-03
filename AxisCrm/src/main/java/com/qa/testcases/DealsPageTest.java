package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.DealsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.crmUtil;

public class DealsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	crmUtil crmutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	String sheetName = "deals";
	
	
	
	public DealsPageTest() {
		
		
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() {
		
		initialization();
		crmutil = new crmUtil();
		loginpage= new LoginPage();
		homepage= new HomePage();
		contactspage=new ContactsPage();
		dealspage= new DealsPage();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		crmutil.switchToFrame();
		dealspage=homepage.clickonDealsLink();
		
	}
	
//	@Test
//	public void VerifyDealsPage() {
//		
//		Assert.assertTrue(dealspage.VerifyDealsLabel(), "Deals Page Not Found");
//		
//	}
	
	@DataProvider
	public Object[][] getDealsData() {
		Object data[][] = crmUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(dataProvider="getDealsData")
	public void ValidateClickOnNewDealsTest(String TI, String Com, String PC, String Id) {
		
		homepage.clickOnNewDealsLink();
		dealspage.NewDeals(TI, Com, PC, Id);
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	
	
	
	
	
}
