package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class DealsPage extends TestBase {
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement ClickOnDeals;
	
	@FindBy(xpath="//td[contains(text(),'State')]")
	WebElement DealsLabel;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement NewDeal;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement Title;
	
	@FindBy(xpath="//tr/td[2]/input[@type='text' and @name='client_lookup']")
	WebElement Company;
	
	@FindBy(xpath="//td/input[@name='contact_lookup']")
	WebElement NameOf;
	
	@FindBy(xpath="//input[@id='amount']")
	WebElement Amount;
	
	@FindBy(xpath="//tr/td[2]/input[@name='identifier']")
	WebElement Identify;
	
	@FindBy(xpath="//tr[1]/td/input[@type='submit' and @value='Save' and @class='button']")
	WebElement Save;
	
	
	public DealsPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public boolean VerifyDealsLabel(){
		
		return  DealsLabel.isDisplayed();
		
	}
	
	
	public void NewDeals(String Tit, String Comp, String Nam, String Ind) {
		
		Title.sendKeys(Tit);
		Company.sendKeys(Comp);
		NameOf.sendKeys(Nam);
		Identify.sendKeys(Ind);
	//    Save.click();
//		
		
		
		
		
//		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
//		driver.findElement(By.xpath("//td/input[@id='title']")).sendKeys("Microsoft");
//		driver.findElement(By.xpath("//td/input[@name='contact_lookup']")).sendKeys("VJ");
//	driver.findElement(By.xpath("//tr[1]/td/input[@type='submit' and @value='Save' and @class='button']")).click();
//	
	}
	
	
	
	
	
}
