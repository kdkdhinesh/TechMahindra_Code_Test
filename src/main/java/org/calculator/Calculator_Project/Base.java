package org.calculator.Calculator_Project;

import java.time.Duration;

import org.constants.Constants;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base extends Actions{

	BrowserFactory bf = new BrowserFactory();

	@BeforeTest
	public void LaunchApplication() throws Exception {

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance("chrome"));
		System.out.println("Driver @ Base Class: "+DriverFactory.getInstance().getDriver());
		
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		DriverFactory.getInstance().getDriver().get(Constants.Production_url);
		
		}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		DriverFactory.getInstance().closeBrowser();
	}
	
	@AfterMethod
	public void clearField() throws InterruptedException {
		
		click_custom(DriverFactory.getInstance().getDriver().findElement(By.xpath("//input[@class='double-x']")), "Clear");
	}


}
