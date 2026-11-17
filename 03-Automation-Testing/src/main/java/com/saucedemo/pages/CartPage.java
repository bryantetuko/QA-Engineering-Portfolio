package com.saucedemo.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locator elemen halaman shopping cart
	private By cartContainer = By.id("cart_contents_container");
	private By cartItems = By.className("cart_item");
	private By cartItemNames = By.className("inventory_item_name");
	private By cartItemPrices = By.className("inventory_item_price");
	private By checkoutButton = By.id("checkout");
	private By continueShoppingButton = By.id("continue-shopping");
	private By removeButton = By.cssSelector("button[id^='remove-']");

	// Constructor
	public CartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// Memastikan halaman cart berhasil ditampilkan
	public boolean isCartPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer)).isDisplayed();
	}

	// Menghitung jumlah produk di cart
	public int getCartItemCount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer));
		return driver.findElements(cartItems).size();
	}

	// Mengambil nama produk di cart
	public List<WebElement> getCartItemNames() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer));
		return driver.findElements(cartItemNames);
	}

	// Mengambil harga produk di cart
	public List<WebElement> getCartItemPrices() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartContainer));
		return driver.findElements(cartItemPrices);
	}

	// Klik tombol checkout
	public void clickCheckout() {
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
	}

	// Klik tombol continue shopping
	public void clickContinueShopping() {
		wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
	}

	// Menghapus produk berdasarkan nama dari halaman cart
	public void removeProduct(String productName) {
		String productId = productName.toLowerCase().replace(" ", "-");

		By productRemoveButton = By.id("remove-" + productId);

		wait.until(ExpectedConditions.elementToBeClickable(productRemoveButton)).click();
	}
}
