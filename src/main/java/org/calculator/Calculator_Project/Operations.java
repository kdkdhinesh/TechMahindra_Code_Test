package org.calculator.Calculator_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Operations extends Base {

	 By divide = By.id("divide");
	 By multiply = By.id("multiply");
	 By subtract = By.id("subtract");
	 By add = By.id("add");
	 By equalTo = By.xpath("//input[@class='double-y']");
	
     

	// Method to do operation with more than 2 numbers

	public void performOperation(String input) throws InterruptedException  {


		for (Character ch : input.toCharArray()) {

			if (!String.valueOf(ch).isEmpty()) {

				if (String.valueOf(ch).equals("+") || String.valueOf(ch).equals("-") || String.valueOf(ch).equals("*")
						|| String.valueOf(ch).equals("/")) {

					switch (String.valueOf(ch)) {
					case "+":
						click_custom(add,"+");
						break;
					case "-":
						click_custom(subtract,"-");
						break;
					case "*":
						click_custom(multiply,"x");
						break;
					case "/":
						click_custom(divide,"/");
						break;
					}

				} else {

					click_custom(By.xpath("//div[@class='row']/input[@value='" + String.valueOf(ch) + "']")
							,String.valueOf(ch));
				}

			} else {

				break;
			}

		}
		
		click_custom(equalTo,"=");
		
		double expectedResult = expectedOutput(input);
		
		double actual = Double.parseDouble(getText_custom(DriverFactory.getInstance().getDriver().findElement(displayedValue )));
    	
    	try {
    		
        Assert.assertEquals(actual , expectedResult);
        
    	}catch(Exception e) {
    		
    		System.err.print(e);
    		
    	}
	}

	public static double expectedOutput(String expression) {
		double result = 0;
		double currentNumber = 0;
		char operator = '+';

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (Character.isDigit(ch)) {
				currentNumber = currentNumber * 10 + (ch - '0');
			}

			if (!Character.isDigit(ch) && ch != ' ' || i == expression.length() - 1) {
				switch (operator) {
				case '+':
					result += currentNumber;
					break;
				case '-':
					result -= currentNumber;
					break;
				case '*':
					result *= currentNumber;
					break;
				case '/':
					result /= currentNumber;
					break;
				}
				operator = ch;
				currentNumber = 0;
			}
		}

		return result;
	}

}
