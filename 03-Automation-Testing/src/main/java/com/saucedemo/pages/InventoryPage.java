package com.saucedemo.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage {
	private WebDriver driver;
	private WebDriverWait wait;

	// Locator elemen halaman inventory
	private By inventoryContainer = By.id("inventory_container");
	private By productItems = By.className("inventory_item");
	private By productNames = By.className("inventory_item_name");
	private By productPrices = By.className("inventory_item_price");
	private By shoppingCartLink = By.className("shopping_cart_link");

	// Constructor
	public InventoryPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// Memastikan halaman inventory sudah tampil
	public boolean isInventoryPageDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer)).isDisplayed();
	}

	// Mengambil jumlah seluruh produk
	public int getProductCount() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
		return driver.findElements(productItems).size();
	}

	// Mengambil seluruh nama produk
	public List<WebElement> getProductNames() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
		return driver.findElements(productNames);
	}

	// Mengambil seluruh harga produk
	public List<WebElement> getProductPrices() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
		return driver.findElements(productPrices);
	}

	// Menambahkan produk ke shopping cart berdasarkan nama
	public void addToCart(String productName) {
		String productId = getProductId(productName);

		By addButton = By.id("add-to-cart-" + productId);

		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
	}

	// Menghapus produk dari shopping cart melalui halaman inventory
	public void removeFromCart(String productName) {
		String productId = getProductId(productName);

		By removeButton = By.id("remove-" + productId);

		wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
	}

	// Membuka halaman shopping cart
	public void openShoppingCart() {
		wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
	}

	// Mengubah nama produk menjadi ID tombol SauceDemo
	private String getProductId(String productName) {
		return productName.toLowerCase().replace(" ", "-");
	}
}