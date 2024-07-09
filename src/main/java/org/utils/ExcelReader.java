package org.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.constants.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
	 XSSFWorkbook workbook;
	 XSSFSheet sheet;
	 XSSFRow row;
	 XSSFCell cell;
	 int LastRow;
	 int LastColumn;
	 String cellValue;

	public String [][] ReadData() throws IOException, InterruptedException {

		FileInputStream file = new FileInputStream(new File(Constants.FilePath_TestData));

		workbook = new XSSFWorkbook(file);
		
		sheet = workbook.getSheet("TestData");
		LastRow = sheet.getLastRowNum();
		LastColumn = sheet.getRow(0).getLastCellNum();
		
		String data[][] = new String[LastRow][LastColumn];
		
		for (int i = 1; i <= LastRow; i++) {

			row = sheet.getRow(i);

		
				for (int j = 0; j < LastColumn; j++) {

									
					cellValue = row.getCell(0).getStringCellValue();
					
					cell = row.getCell(j);
					
					DataFormatter dft = new DataFormatter();
					
					String Value = dft.formatCellValue(cell);

					System.err.println(Value);
					data[i-1][j] = Value;

			}
		}

		workbook.close();
		file.close();
		return data;

	}

}
