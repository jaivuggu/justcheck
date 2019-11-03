package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.WebEventListener;
import com.qa.util.crmUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener; 

	
	public TestBase() {

		try {

			System.out.println("on git");
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Jai\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}



public static void initialization() {
	
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Other files\\chromedriver.exe");
		
		driver = new ChromeDriver();
	}else if (browserName.equals("FF")) {

		System.setProperty("webdriver.gecko.driver", "F:\\Other files\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
	}
	
	e_driver=new EventFiringWebDriver(driver);

	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver=e_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(crmUtil.Page_Load_TimeOut, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(crmUtil.Implicit_Wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));



}


}