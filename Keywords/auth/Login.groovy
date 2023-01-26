package auth

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

public class Login {
	@Keyword
	def loginSuperAdmin() {
		login(GlobalVariable.superadmin_1_email, GlobalVariable.superadmin_1_password)
	}

	def login(String email, String password) {
		WebUI.openBrowser(GlobalVariable.app_url)
		WebUI.setText(findTestObject('Object Repository/Login Page/input_E-mail'), email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Login Page/input_Password'), password)
		WebUI.click(findTestObject('Object Repository/Login Page/button_SignIn'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Home Page/Navbar/logo Setgargo'), 0)
	}

	@Keyword
	def loginFromHomePage() {
		WebUI.setText(findTestObject('Object Repository/Home Page/Navbar/input Select User'), 'flamant')
		WebUI.waitForElementNotPresent(findTestObject('Object Repository/Home Page/Navbar/loader'), 0)	
		WebUI.sendKeys(findTestObject('Object Repository/Home Page/Navbar/input Select User'), Keys.chord(Keys.ENTER))
		WebUI.click(findTestObject('Object Repository/Home Page/Navbar/button SignIn User'))
		WebUI.waitForElementPresent(findTestObject('Object Repository/Home Page/Navbar/button Orders'),0)
	}
}
