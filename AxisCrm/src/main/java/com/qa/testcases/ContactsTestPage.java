 package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.crmUtil;

public class ContactsTestPage extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	crmUtil crmutil;
	ContactsPage contactspage;
	String sheetName="contacts";
	
	public ContactsTestPage() {
		
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		
		initialization();
		crmutil = new crmUtil();
		loginpage= new LoginPage();
		homepage= new HomePage();
		contactspage=new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		crmutil.switchToFrame();
		contactspage= homepage.clickOnContactsLink();
	}
	
	@Test
	// 
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactspage.verifyContactsLabel(),"Contacts Page Not Found");
		
		
	}
	
	@Test//(priority=2, enabled=false)
	public void selectSingleContactsTest() {
		contactspage.selectContactsByName("Chanu Kumar");
		
	}
	
	@Test//(priority=3, enabled=false)
	public void selectMultipleContactsTest() {
		contactspage.selectContactsByName("Chanu Kumar");
		contactspage.selectContactsByName("Harsha Kumar");
	}
	
	
	
	@DataProvider
	
	public Object[][] getCRMTestData() {
		Object data[][] = crmUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	
	public void createNewContactTest(String title, String firstname, String lastname, String company) {
		homepage.clickonNewContacts();
		contactspage.createNewContact(title, firstname, lastname, company);
   	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
