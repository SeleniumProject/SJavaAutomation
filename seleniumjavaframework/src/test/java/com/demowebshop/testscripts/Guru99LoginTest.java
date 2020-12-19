package com.demowebshop.testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
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
		invoke();
		loginPage = new LoginPage(driver);
		dPage = new DashBoardPage(driver);
	}

	@Test(description = "Login -> Verify Login sucessfull with valid credentials")
	public void VerifyLoginsucessfullwithvalidcredentials(String loginTitle, String uname, String password,
			String dPageTitle) {

		try {

			test = extent.startTest("TC01_VerifyLoginsucessfullwithvalidcredentials");
			test.log(LogStatus.PASS, "Verify the Login Page Title " + loginPage.Title());

			Assert.assertEquals(loginPage.Title(), loginTitle);

			test.log(LogStatus.PASS, "Enter the Username :" + uname);
			loginPage.enterUsername(uname);

			test.log(LogStatus.PASS, "Enter the Password :" + password);
			loginPage.enterUsername(password);

			test.log(LogStatus.PASS, "click login button :");
			loginPage.clickLogin();

			test.log(LogStatus.PASS, "Verify the title of the Dash board page : " + dPage.Title());

			Assert.assertEquals(dPage.Title(), dPageTitle);
		} catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to login or Login failed");
		}
	}

}
