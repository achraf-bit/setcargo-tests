package orders

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class Orders {

	def value

	@Keyword
	def accessToOrders() {
		WebUI.click(findTestObject('Object Repository/Home Page/Navbar/button Orders'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Orders/Dashboard/first Cell in Dashboard Orders'), 0)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Home Page/Orders/Dashboard/first Cell in Dashboard Orders'))
	}

	@Keyword
	def searchInDashboard() {
		WebUI.setText(findTestObject('Object Repository/Home Page/Orders/Dashboard/input Search in Dashboad'), '23000616')
		WebUI.sendKeys(findTestObject('Object Repository/Home Page/Orders/Dashboard/input Search in Dashboad'), Keys.chord(Keys.ENTER))
		WebUI.delay(10)
		value = WebUI.getAttribute(findTestObject('Object Repository/Home Page/Orders/Dashboard/first Cell in Dashboard Orders'), 'innerText')
		WebUI.verifyMatch(value, '23000616', true, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	def advancedSearch(){
		WebUI.click(findTestObject('Object Repository/Home Page/Orders/Dashboard/button Advanced Search'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Orders/Form/input_N Order'),0)
		WebUI.setText(findTestObject('Object Repository/Home Page/Orders/Form/input_N Order'), '000027967')
		WebUI.click(findTestObject('Object Repository/Home Page/Orders/Form/button Search in advanced Search'))
		WebUI.delay(5)
		value = WebUI.getAttribute(findTestObject('Object Repository/Home Page/Orders/Dashboard/first Cell in Dashboard Orders'), 'innerText')
		WebUI.verifyMatch(value, '000027967', true, FailureHandling.CONTINUE_ON_FAILURE)
	}
}
