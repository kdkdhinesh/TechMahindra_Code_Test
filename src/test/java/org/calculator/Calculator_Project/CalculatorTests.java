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
    public void calculate(String input) {    	
    	
    	String expected = String.valueOf(op.performOperation(input));    	
    	
        Assert.assertEquals(getResult(), expected);
    }
    
    
    private String getResult() {
        WebElement resultField = DriverFactory.getInstance().getDriver().findElement(By.xpath("//div[@id='display']/div"));
        
        System.err.println("Result -> "+resultField.getText());
        
        return resultField.getText();
    }

    @Test(enabled=false)
    
    public void testAddition() {
    	op.performOperation("5", "+", "3");
        Assert.assertEquals(getResult(),"8");
    }

    @Test(enabled=false)
    public void testSubtraction() {
    	op.performOperation("9", "-", "4");
        Assert.assertEquals(getResult(),"5");
    }

    @Test(enabled=false)
    public void testMultiplication() {
    	op.performOperation("7", "*", "6");
        Assert.assertEquals( getResult(),"42");
    }

    @Test(enabled=false)
    public void testDivision() {
    	op.performOperation("8", "/", "2");
        Assert.assertEquals(getResult(), "4");
    }
    

}

