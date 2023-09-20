package demo
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import java.util.List;
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select;
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4.class)
class read_write_excel {
	

	
	public static void main(String[] args) {
        String inputFilePath = "./test_case.xlsx";
		
        removeRowsWithBlankData(inputFilePath);
		
    }
	public static void removeRowsWithBlankData(String inputFilePath) {
		try {
			FileInputStream fis = new FileInputStream(inputFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);

			for (int i = sheet.getLastRowNum(); i >= 0; i--) {
				XSSFRow row = sheet.getRow(i);
				boolean isRowBlank = true;

				if (row != null) {
					for (int j = 0; j < row.getLastCellNum(); j++) {
						XSSFCell cell = row.getCell(j);
						if (cell != null && cell.getCellTypeEnum() != CellType.BLANK) {
							isRowBlank = false;
							break;
						}
					}
				}

				if (isRowBlank) {
					sheet.removeRow(row);
				}
			}

			fis.close();
			FileOutputStream fos = new FileOutputStream("./ouput_flie.xlsx");
			workbook.write(fos);
			fos.close();
			workbook.close();

			println "Các dòng chỉ chứa ô trống đã được xóa và tệp mới đã được lưu."
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(5000)
		String file_edit = "./ouput_flie.xlsx";
		showExcel(file_edit)
	}
	
	public static void showExcel(String file_edit) {
		FileInputStream fis = new FileInputStream(file_edit);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//creating workbook instance that refers to .xls file
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//get all rows in the sheet
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		//iterate over all the row to print the data present in each cell.
		for(int i=0;i<=rowCount;i++){
			
			//get cell count in a row
			int cellcount=sheet.getRow(i).getLastCellNum();
			
			//iterate over each cell to print its value
			System.out.println("Row"+ i+" data is :");
			
			for(int j=0;j<cellcount;j++){
				System.out.print(sheet.getRow(i).getCell(j).getStringCellValue() +",");
			}
			System.out.println();
		}
	}
	
	
	
}