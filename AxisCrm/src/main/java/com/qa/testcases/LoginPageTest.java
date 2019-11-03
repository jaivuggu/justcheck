package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage LP;
	HomePage HP;
	
	public LoginPageTest() {
		
		
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		LP= new LoginPage();
		
	}
	
	
	@Test(priority=1,enabled = true)
	
	public void LoginTest() {
		String title =LP.ValidateLoginPage();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test//(priority=2, enabled = true)
	public void LogoTest() {
		
		boolean flag = LP.ValidateLogoImage();
		Assert.assertTrue(flag, "LOGO NOT DISPLAYED");
		
	}
	
	@Test//(priority=3)
	public void LoginCredentialsTest()  {
		
		HP=LP.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
}
