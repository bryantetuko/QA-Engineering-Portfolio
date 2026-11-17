package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Locator form informasi pembeli
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By postalCodeInput = By.id("postal-code");
	private By continueButton = By.id("continue");
	private By cancelButton = By.id("cancel");

	// Locator pesan error
	private By errorMessage = By.cssSelector("h3[data-test='error']");

	// Locator halaman checkout overview
	private By summaryContainer = By.id("checkout_summary_container");
	private By finishButton = By.id("finish");

	// Locator halaman checkout complete
	private By completeHeader = By.className("complete-header");
	private By backHomeButton = By.id("back-to-products");

	// Constructor
	public CheckoutPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	// Mengisi First Name
	public void enterFirstName(String firstName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(firstName);
	}

	// Mengisi Last Name
	public void enterLastName(String lastName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameInput)).sendKeys(lastName);
	}

	// Mengisi Postal Code
	public void enterPostalCode(String postalCode) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeInput)).sendKeys(postalCode);
	}

	// Klik tombol Continue
	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	}

	// Mengambil pesan error
	public String getErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
	}

	// Memeriksa halaman overview
	public boolean isOverviewDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(summaryContainer)).isDisplayed();
	}

	// Klik tombol Finish
	public void clickFinish() {
		wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
	}

	// Mengambil pesan konfirmasi pesanan
	public String getCompleteHeader() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).getText();
	}

	// Memeriksa halaman checkout complete
	public boolean isCheckoutCompleteDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(completeHeader)).isDisplayed();
	}

	// Kembali ke halaman inventory
	public void clickBackHome() {
		wait.until(ExpectedConditions.elementToBeClickable(backHomeButton)).click();
	}
}
