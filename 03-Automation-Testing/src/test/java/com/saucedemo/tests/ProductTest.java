package com.saucedemo.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.InventoryPage;
import org.testng.annotations.Listeners;
import com.saucedemo.utils.TestListener;

@Listeners(TestListener.class)
public class ProductTest extends BaseTest {

	// Test 1: Memastikan halaman inventory berhasil dibuka
	@Test(description = "Verify Inventory Page Is Displayed")
	public void testInventoryPageDisplayed() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		InventoryPage inventoryPage = new InventoryPage(driver, wait);

		Assert.assertTrue(inventoryPage.isInventoryPageDisplayed(), "Inventory page was not displayed!");
	}

	// Test 2: Memastikan jumlah produk adalah 6
	@Test(description = "Verify Total Number of Products")
	public void testProductCount() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		InventoryPage inventoryPage = new InventoryPage(driver, wait);

		Assert.assertEquals(inventoryPage.getProductCount(), 6, "The total number of products is incorrect!");
	}

	// Test 3: Memastikan seluruh nama produk berhasil ditampilkan
	@Test(description = "Verify Product Names Are Displayed")
	public void testProductNamesDisplayed() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		InventoryPage inventoryPage = new InventoryPage(driver, wait);

		List<WebElement> productNames = inventoryPage.getProductNames();

		Assert.assertEquals(productNames.size(), 6, "Not all product names are displayed!");

		for (WebElement product : productNames) {
			Assert.assertFalse(product.getText().trim().isEmpty(), "A product name is empty!");
		}
	}

	// Test 4: Memastikan seluruh harga produk berhasil ditampilkan
	@Test(description = "Verify Product Prices Are Displayed")
	public void testProductPricesDisplayed() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		InventoryPage inventoryPage = new InventoryPage(driver, wait);

		List<WebElement> productPrices = inventoryPage.getProductPrices();

		Assert.assertEquals(productPrices.size(), 6, "Not all product prices are displayed!");

		for (WebElement price : productPrices) {
			Assert.assertFalse(price.getText().trim().isEmpty(), "A product price is empty!");
		}
	}
}
