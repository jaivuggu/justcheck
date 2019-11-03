package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement Company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement Save;
	
	
	
	
	//@FindBy(xpath="//form[@id='vContactsForm']//preceding-sibling::tr[2]/td[@class='datalistrow']//input[@name='contact_id' and@value='52681575']")
	//WebElement 
	////a[text()='Chanu Kumar']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']
	
	public ContactsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public boolean verifyContactsLabel() {
		
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
	}

	public void createNewContact(String title, String FIRSTNAME, String LASTNAME, String COMPANY) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		FirstName.sendKeys(FIRSTNAME);
		LastName.sendKeys(LASTNAME);
		Company.sendKeys(COMPANY);
		//Save.click();
		
	}
}
 