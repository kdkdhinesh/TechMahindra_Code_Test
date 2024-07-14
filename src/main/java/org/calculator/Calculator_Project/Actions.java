package org.calculator.Calculator_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

	private WebDriverWait wait = null;

	private WebDriverWait getWebDriverWait() {

		return this.wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
	}

	public void click_custom(By byLocator, String expectedKey) throws InterruptedException {

		try {
			
			getWebDriverWait();

			WebElement element = this.wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));

			element.click();

			// Print success message
			System.out.println("'" + expectedKey + "'" + " -> Clicked Successfully! ");

		} catch (Exception e) {
			// Print failure message

			System.out.println("Unable to click on field: " + expectedKey + " Exception thrown: " + e);

		}
	}

	public String getText_custom(WebElement resultField) {

		System.err.println("Result -> " + resultField.getText());

		return resultField.getText();
	}
}
