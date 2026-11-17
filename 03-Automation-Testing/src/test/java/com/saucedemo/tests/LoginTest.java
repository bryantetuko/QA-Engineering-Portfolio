package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.saucedemo.pages.LoginPage;
import org.testng.annotations.Listeners;
import com.saucedemo.utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	// Menyediakan variasi data untuk pengujian login
	@DataProvider(name = "loginData")
	public Object[][] getLoginData() {

		return new Object[][] { { "standard_user", "secret_sauce", "SUCCESS" },
				{ "standard_user", "wrong_password", "Username and password do not match any user in this service" },
				{ "", "secret_sauce", "Username is required" }, { "standard_user", "", "Password is required" },
				{ "unknown_user", "secret_sauce", "Username and password do not match any user in this service" } };
	}

	// Menjalankan pengujian login menggunakan DataProvider
	@Test(dataProvider = "loginData", description = "Verify Login with Multiple Credential Combinations")
	public void testLoginWithMultipleCredentials(String username, String password, String expectedResult) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();

		if (expectedResult.equals("SUCCESS")) {

			Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login should be successful!");

		} else {

			String actualErrorMessage = loginPage.getErrorMessageText();

			Assert.assertTrue(actualErrorMessage.contains(expectedResult), "Expected error message was not displayed!");
		}
	}
}
