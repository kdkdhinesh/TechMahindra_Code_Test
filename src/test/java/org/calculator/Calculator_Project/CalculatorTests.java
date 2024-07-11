package org.calculator.Calculator_Project;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utils.ExcelReader;


public class CalculatorTests extends Base{

	
	Operations op = new Operations();
	
    @DataProvider
	public String[][] dp() throws InterruptedException, IOException {
	
		ExcelReader excelData = new ExcelReader();
		
		String[][] ExcelData = excelData.ReadData();
		
		return ExcelData;
	}
    
    /* Test method that handles the calculation for any number of operation */
    
    @Test(dataProvider = "dp")
    public void calculate(String input) throws InterruptedException {    	
    	
    	String expected = String.valueOf(op.performOperation(input));    	
    	
        Assert.assertEquals(getText_custom(DriverFactory.getInstance().getDriver().findElement(displayedValue )), expected);
    }
    
    
     @Test(enabled=false)
    
    public void testAddition() throws InterruptedException {
    	op.performOperation("5", "+", "3");
        Assert.assertEquals(getText_custom(DriverFactory.getInstance().getDriver().findElement(displayedValue )),"8");
    }

    @Test(enabled=false)
    public void testSubtraction() throws InterruptedException {
    	op.performOperation("9", "-", "4");
        Assert.assertEquals(getText_custom(DriverFactory.getInstance().getDriver().findElement(displayedValue )),"5");
    }

    @Test(enabled=false)
    public void testMultiplication() throws InterruptedException {
    	op.performOperation("7", "*", "6");
        Assert.assertEquals( getText_custom(DriverFactory.getInstance().getDriver().findElement(displayedValue )),"42");
    }

    @Test(enabled=false)
    public void testDivision() throws InterruptedException {
    	op.performOperation("8", "/", "2");
        Assert.assertEquals(getText_custom(DriverFactory.getInstance().getDriver().findElement(displayedValue )), "4");
    }
    

}

