package com.saucedemo.tests;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.CartPage;
import org.testng.annotations.Listeners;
import com.saucedemo.utils.TestListener;

@Listeners(TestListener.class)
public class CartTest extends BaseTest {

	// Membantu login sebelum melakukan pengujian cart
	private InventoryPage loginToInventory() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLogin();

		return new InventoryPage(driver, wait);
	}

	// Test 1: Menambahkan satu produk ke cart
	@Test(description = "Verify Adding One Product to Cart")
	public void testAddOneProductToCart() {

		InventoryPage inventoryPage = loginToInventory();

		inventoryPage.addToCart("Sauce Labs Backpack");
		inventoryPage.openShoppingCart();

		CartPage cartPage = new CartPage(driver, wait);

		Assert.assertEquals(cartPage.getCartItemCount(), 1, "Product was not successfully added to cart!");
	}

	// Test 2: Menambahkan beberapa produk ke cart
	@Test(description = "Verify Adding Multiple Products to Cart")
	public void testAddMultipleProductsToCart() {

		InventoryPage inventoryPage = loginToInventory();

		inventoryPage.addToCart("Sauce Labs Backpack");
		inventoryPage.addToCart("Sauce Labs Bike Light");
		inventoryPage.addToCart("Sauce Labs Bolt T-Shirt");

		inventoryPage.openShoppingCart();

		CartPage cartPage = new CartPage(driver, wait);

		Assert.assertEquals(cartPage.getCartItemCount(), 3, "Not all products were successfully added to cart!");
	}

	// Test 3: Menghapus produk dari inventory
	@Test(description = "Verify Removing Product from Inventory")
	public void testRemoveProductFromInventory() {

		InventoryPage inventoryPage = loginToInventory();

		inventoryPage.addToCart("Sauce Labs Backpack");
		inventoryPage.removeFromCart("Sauce Labs Backpack");
		inventoryPage.openShoppingCart();

		CartPage cartPage = new CartPage(driver, wait);

		Assert.assertEquals(cartPage.getCartItemCount(), 0, "Product was not successfully removed from cart!");
	}

	// Test 4: Menghapus produk dari halaman cart
	@Test(description = "Verify Removing Product from Cart")
	public void testRemoveProductFromCart() {

		InventoryPage inventoryPage = loginToInventory();

		inventoryPage.addToCart("Sauce Labs Backpack");
		inventoryPage.openShoppingCart();

		CartPage cartPage = new CartPage(driver, wait);

		Assert.assertEquals(cartPage.getCartItemCount(), 1, "Cart should contain one product before removal!");

		// Menghapus produk langsung dari halaman cart
		cartPage.removeProduct("Sauce Labs Backpack");

		Assert.assertEquals(cartPage.getCartItemCount(), 0, "Product was not successfully removed from cart!");
	}

	// Test 5: Memastikan halaman cart berhasil dibuka
	@Test(description = "Verify Shopping Cart Page")
	public void testShoppingCartPageDisplayed() {

		InventoryPage inventoryPage = loginToInventory();

		inventoryPage.openShoppingCart();

		CartPage cartPage = new CartPage(driver, wait);

		Assert.assertTrue(cartPage.isCartPageDisplayed(), "Shopping cart page was not displayed!");
	}

	// Test 6: Memastikan nama dan harga produk sesuai
	@Test(description = "Verify Cart Product Details")
	public void testCartProductDetails() {

		InventoryPage inventoryPage = loginToInventory();

		inventoryPage.addToCart("Sauce Labs Backpack");
		inventoryPage.openShoppingCart();

		CartPage cartPage = new CartPage(driver, wait);

		List<WebElement> names = cartPage.getCartItemNames();
		List<WebElement> prices = cartPage.getCartItemPrices();

		Assert.assertEquals(names.size(), 1);
		Assert.assertEquals(prices.size(), 1);

		Assert.assertEquals(names.get(0).getText(), "Sauce Labs Backpack");

		Assert.assertEquals(prices.get(0).getText(), "$29.99");
	}
}
