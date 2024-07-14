package org.calculator.Calculator_Project;

import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author: Dhinesh Kumar
 */
public class DriverFactory {

	//Singleton design Pattern
	//private constructor so that no one else can create object of this class
	private DriverFactory() {
		
	}
	
	private static DriverFactory instance  = new DriverFactory();
	
	public static DriverFactory getInstance() {
		return instance;
	}
		
	//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
	ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public RemoteWebDriver getDriver() {
			return driver.get();
	}
	
	public void setDriver(RemoteWebDriver driverParm) {
		driver.set(driverParm);
	}
	
	
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
		
	}
}