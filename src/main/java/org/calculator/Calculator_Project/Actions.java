package org.calculator.Calculator_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Actions {
	
	 By displayedValue = By.xpath("//div[@id='display']/div");

	public void click_custom(WebElement element, String expectedKey) throws InterruptedException {
		try {
			element.click();
			// Print success message
			System.out.println("'" + expectedKey + "'" + " -> Clicked Successfully! ");
			

		} catch (Exception e) {
			// Print failure message

			System.out.println("Unable to click on field: " + expectedKey + " Exception thrown: " + e);

		}
	}
	
	public String getText_custom(WebElement resultField) {
		
       
        System.err.println("Result -> "+resultField.getText());
        
        return resultField.getText();
    }
}
