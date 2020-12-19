package com.demowebshop.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demowebshop.pages.DashBoardPage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Guru99LoginTest extends TestBase {

	LoginPage loginPage;

	DashBoardPage dPage;

	@BeforeSuite
	public void setup() throws IOException {
		// Invoke the Browser
		try {
			invoke();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage = new LoginPage(driver);
		dPage = new DashBoardPage(driver);
	}

	@DataProvider (name = "Login")

	public Object[][] LoginMethod() {

	return new Object [][] { {"Guru99 Bank Home Page","mngr300680","AgArAru","Guru99 Bank Manager HomePage"},
		};

	}
	
	@Test(dataProvider = "Login", description = "Login -> Verify Login sucessfull with valid credentials")
	public void VerifyLoginsucessfullwithvalidcredentials(String loginTitle, String uname, String password,
			String dPageTitle) {

		try {

			test = extent.startTest("TC01_VerifyLoginsucessfullwithvalidcredentials");
			test.log(LogStatus.PASS, "Verify the Login Page Title " + loginPage.Title());

			Assert.assertEquals(loginPage.Title(), loginTitle);
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Enter the Username :" + uname);
			loginPage.enterUsername(uname);
            Thread.sleep(2000);
			test.log(LogStatus.PASS, "Enter the Password :" + password);
			loginPage.enterPassword(password);
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "click login button :");
			loginPage.clickLogin();
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Verify the title of the Dash board page : " + dPage.Title());

			Assert.assertEquals(dPage.Title(), dPageTitle);
			dPage.clickLogout();
			Thread.sleep(3000);
			dPage.clickAlertok();
			Thread.sleep(4000);
			
		} catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to login or Login failed");
		}
	}
	
	@AfterSuite
	public void tearDown() {
		extent.endTest(test);
		extent.flush();
		driver.close();
	}

}
