package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.crmUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	crmUtil crmutil;
	ContactsPage contactspage;

	public HomePageTest() {

		super();

	}

	@BeforeMethod
	public void SetUp()  {

		initialization();
		crmutil = new crmUtil();
		loginpage = new LoginPage();
		contactspage=new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
 
	}

	@Test//(priority = 1)
	public void verifyHomePageTitleTest() {

		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Title is not matching");

	}

	@Test//(priority = 2)

	public void VerifyCorrectUserNameTest() {
		crmutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());

	}
	
	
	@Test //(priority = 3)
	public void verifyContactlinkTest() {
		crmutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
