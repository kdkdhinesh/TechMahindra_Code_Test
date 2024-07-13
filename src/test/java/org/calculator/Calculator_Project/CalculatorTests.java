package org.calculator.Calculator_Project;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.ExcelReader;

public class CalculatorTests extends Base {

	Operations op = new Operations();

	@DataProvider(parallel = true)
	public String[][] dp() throws InterruptedException, IOException {

		ExcelReader excelData = new ExcelReader();

		String[][] ExcelData = excelData.ReadData();

		return ExcelData;
	}

	/* Test method that handles the calculation for any number of operation */

	@Test(dataProvider = "dp")

	public void calculate(String input) throws Exception {

		LaunchApplication();

		op.performOperation(input);

		closeBrowserTab();

	}

}
