package org.calculator.Calculator_Project;

import org.openqa.selenium.WebElement;

public class Actions {

	public void click_custom(WebElement element, String fieldName) throws InterruptedException {
		try {
			element.click();
			// Print success message
			System.out.println("'" + fieldName + "'" + " -> Clicked Successfully! ");

		} catch (Exception e) {
			// Print failure message

			System.out.println("Unable to click on field: " + fieldName + " Exception thrown: " + e);

		}
	}
}
