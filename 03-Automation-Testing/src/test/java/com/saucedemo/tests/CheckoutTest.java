package com.saucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import org.testng.annotations.Listeners;
import com.saucedemo.utils.TestListener;

@Listeners(TestListener.class)
public class CheckoutTest extends BaseTest {

	// Login dan menyiapkan satu produk di cart
	private CartPage prepareCart() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		InventoryPage inventoryPage = new InventoryPage(driver, wait);

		inventoryPage.addToCart("Sauce Labs Backpack");
		inventoryPage.openShoppingCart();

		return new CartPage(driver, wait);
	}

	// Membuka halaman checkout information
	private CheckoutPage openCheckout() {
		CartPage cartPage = prepareCart();

		cartPage.clickCheckout();

		return new CheckoutPage(driver, wait);
	}

	// Test 1: Checkout dengan data valid
	@Test(description = "Verify Checkout with Valid Information")
	public void testCheckoutWithValidInformation() {

		CheckoutPage checkoutPage = openCheckout();

		checkoutPage.enterFirstName("Bryan");
		checkoutPage.enterLastName("Tetuko");
		checkoutPage.enterPostalCode("17121");
		checkoutPage.clickContinue();

		Assert.assertTrue(checkoutPage.isOverviewDisplayed(), "Checkout overview page was not displayed!");
	}

	// Test 2: Checkout dengan First Name kosong
	@Test(description = "Verify Checkout with Empty First Name")
	public void testCheckoutWithEmptyFirstName() {

		CheckoutPage checkoutPage = openCheckout();

		checkoutPage.enterLastName("Tetuko");
		checkoutPage.enterPostalCode("17121");
		checkoutPage.clickContinue();

		Assert.assertTrue(checkoutPage.getErrorMessage().contains("First Name is required"),
				"Expected first name validation error was not displayed!");
	}

	// Test 3: Checkout dengan Last Name kosong
	@Test(description = "Verify Checkout with Empty Last Name")
	public void testCheckoutWithEmptyLastName() {

		CheckoutPage checkoutPage = openCheckout();

		checkoutPage.enterFirstName("Bryan");
		checkoutPage.enterPostalCode("17121");
		checkoutPage.clickContinue();

		Assert.assertTrue(checkoutPage.getErrorMessage().contains("Last Name is required"),
				"Expected last name validation error was not displayed!");
	}

	// Test 4: Checkout dengan Postal Code kosong
	@Test(description = "Verify Checkout with Empty Postal Code")
	public void testCheckoutWithEmptyPostalCode() {

		CheckoutPage checkoutPage = openCheckout();

		checkoutPage.enterFirstName("Bryan");
		checkoutPage.enterLastName("Tetuko");
		checkoutPage.clickContinue();

		Assert.assertTrue(checkoutPage.getErrorMessage().contains("Postal Code is required"),
				"Expected postal code validation error was not displayed!");
	}

	// Test 5: Memeriksa ringkasan pesanan
	@Test(description = "Verify Checkout Order Summary")
	public void testCheckoutOrderSummary() {

		CheckoutPage checkoutPage = openCheckout();

		checkoutPage.enterFirstName("Bryan");
		checkoutPage.enterLastName("Tetuko");
		checkoutPage.enterPostalCode("17121");
		checkoutPage.clickContinue();

		Assert.assertTrue(checkoutPage.isOverviewDisplayed(), "Checkout overview page was not displayed!");

		Assert.assertTrue(driver.getPageSource().contains("Sauce Labs Backpack"),
				"Expected product was not found in order summary!");

		Assert.assertTrue(driver.getPageSource().contains("$29.99"),
				"Expected product price was not found in order summary!");
	}

	// Test 6: Menyelesaikan checkout
	@Test(description = "Verify Successful Order Completion")
	public void testSuccessfulCheckout() {

		CheckoutPage checkoutPage = openCheckout();

		checkoutPage.enterFirstName("Bryan");
		checkoutPage.enterLastName("Tetuko");
		checkoutPage.enterPostalCode("17121");
		checkoutPage.clickContinue();

		checkoutPage.clickFinish();

		Assert.assertTrue(checkoutPage.isCheckoutCompleteDisplayed(), "Checkout completion page was not displayed!");

		Assert.assertEquals(checkoutPage.getCompleteHeader(), "Thank you for your order!",
				"Order confirmation message is incorrect!");
	}
}
