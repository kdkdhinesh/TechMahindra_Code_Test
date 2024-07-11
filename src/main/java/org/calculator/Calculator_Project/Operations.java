package org.calculator.Calculator_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Operations extends Base {

	 By divide = By.id("divide");
	 By multiply = By.id("multiply");
	 By subtract = By.id("subtract");
	 By add = By.id("add");
	 By equalTo = By.xpath("//input[@class='double-y']");
	 By clear = By.xpath("//input[@class='double-x']");
	
     

	// Method to do operation with 2 numbers

	public void performOperation(String firstNumber, String operator, String secondNumber) throws InterruptedException {

		WebElement firstInput = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[@class='row']/input[@value='" + firstNumber + "']"));
		WebElement secondInput = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[@class='row']/input[@value='" + secondNumber + "']"));

		firstInput.click();

		switch (operator) {
		case "+":
			click_custom(DriverFactory.getInstance().getDriver().findElement(add),"+");
			break;
		case "-":
			click_custom(DriverFactory.getInstance().getDriver().findElement(subtract),"-");
			break;
		case "*":
			click_custom(DriverFactory.getInstance().getDriver().findElement(multiply),"x");
			break;
		case "/":
			click_custom(DriverFactory.getInstance().getDriver().findElement(divide),"/");
			break;
		}
		secondInput.click();

		click_custom(DriverFactory.getInstance().getDriver().findElement(equalTo),"=");

	}

	// Method to do operation with more than 2 numbers

	public int performOperation(String input) throws InterruptedException  {

		int expectedResult = expectedOutput(input);

		for (Character ch : input.toCharArray()) {

			if (!String.valueOf(ch).isEmpty()) {

				if (String.valueOf(ch).equals("+") || String.valueOf(ch).equals("-") || String.valueOf(ch).equals("*")
						|| String.valueOf(ch).equals("/")) {

					switch (String.valueOf(ch)) {
					case "+":
						click_custom(DriverFactory.getInstance().getDriver().findElement(add),"+");
						break;
					case "-":
						click_custom(DriverFactory.getInstance().getDriver().findElement(subtract),"-");
						break;
					case "*":
						click_custom(DriverFactory.getInstance().getDriver().findElement(multiply),"x");
						break;
					case "/":
						click_custom(DriverFactory.getInstance().getDriver().findElement(divide),"/");
						break;
					}

				} else {

					click_custom(DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//div[@class='row']/input[@value='" + String.valueOf(ch) + "']"))
							,String.valueOf(ch));
				}

			} else {

				break;
			}

		}
		click_custom(DriverFactory.getInstance().getDriver().findElement(equalTo),"=");
		
		try {
			
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
						
		}

		return expectedResult;
	}

	public static int expectedOutput(String expression) {
		int result = 0;
		int currentNumber = 0;
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
