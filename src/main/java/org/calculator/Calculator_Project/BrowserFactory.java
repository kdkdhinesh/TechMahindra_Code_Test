package org.calculator.Calculator_Project;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserFactory {
	

	protected RemoteWebDriver driver = null;
	
	//create webdriver object for given browser
	public RemoteWebDriver createBrowserInstance(String browser) throws FileNotFoundException, IOException {
	
			
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Workspace\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();

			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "C:\\Automation\\Workspace\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();

			break;
		case "firefox":
			System.setProperty("webdriver.firefox.driver", "C:\\Automation\\Workspace\\drivers\\chromedriver.exe");
			driver=new FirefoxDriver();

			break;
		default:
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Workspace\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
		}
		return driver;
	}
	
	

}