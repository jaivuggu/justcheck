package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'prakash')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'New Contact')]")
	WebElement NewContact;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement NewDeals;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	public String verifyHomePageTitle() {
		
	return driver.getTitle();
		
	}
	
	public boolean verifyCorrectUserName() {
		
		return userNameLabel.isDisplayed();
	}
	
	
	
	public TaskPage clickOnTasksLink() {
		
		TasksLink.click();
		return new TaskPage();
	}
	
	
	public ContactsPage clickOnContactsLink() {
	
		ContactsLink.click();
		return new ContactsPage();
	
	}
		
	public void clickonNewContacts() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContact.click();
		
	}
	
	
	public DealsPage clickonDealsLink() {
		
		DealsLink.click();
		return new DealsPage();
		
	}
	
	
	public void clickOnNewDealsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(DealsLink).build().perform();
		NewDeals.click();
		
	
	}
}


