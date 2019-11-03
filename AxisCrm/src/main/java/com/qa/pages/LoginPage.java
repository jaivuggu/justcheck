package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	//page factory or repository
	
	
	@FindBy(name="username")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//div/input[@type='submit']")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//div/ul/li[2]/a[contains (text(),'Sign Up')]")
	WebElement SignUp;
	
	@FindBy (xpath="//div/a[@class='navbar-brand']")
	WebElement Logo;
	
	@FindBy (xpath="//div[contains(@class,'intercom-borderless-dismiss-button')]/span")
	WebElement closechatbox;

	//Actions action = new Actions(driver);
	//action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
	
public LoginPage() {
PageFactory.initElements(driver, this);
}


public String ValidateLoginPage() {
	return driver.getTitle();
}


public boolean ValidateLogoImage() {
	return Logo.isDisplayed();
}


public HomePage login(String UN, String PSWD)  {

	UserName.sendKeys(UN);
	Password.sendKeys(PSWD);
	

	driver.switchTo().frame("intercom-borderless-frame");
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
	//driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]/span")).click();
	closechatbox.click();
	SubmitBtn.click();
	
	return new HomePage();
}






}