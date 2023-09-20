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



import static org.hamcrest.CoreMatchers.*
import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4.class)
class login_ {
	public WebDriver driver
	public KeywordLogger log
	@Before

	void test_login() {
		WebUI.openBrowser("http://10.124.71.97:9025/login")
		Thread.sleep(2000)

		'Maximize current window'
		WebUI.maximizeWindow()
	}

	@Test
	void login_Iva() {
		WebDriver driver = DriverFactory.getWebDriver();

		WebElement username = driver.findElement(By.id("username"))
		WebElement password = driver.findElement(By.id("password"))
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"))


		Thread.sleep(2000)
		username.sendKeys("bigdata")
		println("username: " + username)
		password.sendKeys("Iv@2022#")
		Thread.sleep(2000)
		submit.click()
		Thread.sleep(4000)
		click_case()
		Thread.sleep(2000)
	}

	void click_case() {

		for(int i= 1; i <= 14; i++) {
			Thread.sleep(4000)
			WebElement img_case = driver.findElement(By.xpath("//div/div/div/div/div[2]/div/div/div[2]/div/div[2]/div["+i+"]/div/span/img"))
			Thread.sleep(1000)
			println("img_case: " + img_case)
			Thread.sleep(2000)
			img_case.click()
			Thread.sleep(2000)
			click_filter()
			Thread.sleep(2000)
		}
	}
	void click_filter() {
		Thread.sleep(2000)
		for(int i =  1 ; i <= 1; i++) {
			Thread.sleep(2000)
			WebElement filter_case = driver.findElement(By.xpath("//*[@id='root']/div/div/div/div[2]/div/div/div/aside[2]/div/div/div[2]/div["+i* 2+"]/div/span/b"))
			Thread.sleep(2000)
			println("filter_case: "+ filter_case)
			filter_case.click()
			Thread.sleep(2000)
			
		}
		Thread.sleep(2000)
	}


//	void select_list() {
//		List<WebElement> parentElements=driver.findElements(By.xpath("//div[@class='ant-checkbox-wrapper']"))
//		println("parentElements: "+ parentElements.size())
//	}
}