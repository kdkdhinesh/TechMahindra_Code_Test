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

	public void performOperation(String firstNumber, String operator, String secondNumber) {

		WebElement firstInput = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[@class='row']/input[@value='" + firstNumber + "']"));
		WebElement secondInput = DriverFactory.getInstance().getDriver()
				.findElement(By.xpath("//div[@class='row']/input[@value='" + secondNumber + "']"));

		firstInput.click();

		switch (operator) {
		case "+":
			DriverFactory.getInstance().getDriver().findElement(add).click();
			break;
		case "-":
			DriverFactory.getInstance().getDriver().findElement(subtract).click();
			break;
		case "*":
			DriverFactory.getInstance().getDriver().findElement(multiply).click();
			break;
		case "/":
			DriverFactory.getInstance().getDriver().findElement(divide).click();
			break;
		}
		secondInput.click();

		DriverFactory.getInstance().getDriver().findElement(equalTo).click();

	}

	// Method to do operation with more than 2 numbers

	public int performOperation(String input) {

		int expectedResult = expectedOutput(input);

		for (Character ch : input.toCharArray()) {

			if (!String.valueOf(ch).isEmpty()) {

				if (String.valueOf(ch).equals("+") || String.valueOf(ch).equals("-") || String.valueOf(ch).equals("*")
						|| String.valueOf(ch).equals("/")) {

					switch (String.valueOf(ch)) {
					case "+":
						DriverFactory.getInstance().getDriver().findElement(add).click();
						break;
					case "-":
						DriverFactory.getInstance().getDriver().findElement(subtract).click();
						break;
					case "*":
						DriverFactory.getInstance().getDriver().findElement(multiply).click();
						break;
					case "/":
						DriverFactory.getInstance().getDriver().findElement(divide).click();
						break;
					}

				} else {

					DriverFactory.getInstance().getDriver()
							.findElement(By.xpath("//div[@class='row']/input[@value='" + String.valueOf(ch) + "']"))
							.click();
				}

			} else {

				break;
			}

		}
		DriverFactory.getInstance().getDriver().findElement(equalTo).click();

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
