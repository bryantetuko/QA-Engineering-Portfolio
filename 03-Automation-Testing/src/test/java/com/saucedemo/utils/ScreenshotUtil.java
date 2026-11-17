package com.saucedemo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {

		// Membuat nama file berdasarkan nama test dan waktu
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String fileName = testName + "_" + timestamp + ".png";

		// Lokasi penyimpanan screenshot
		Path screenshotDirectory = Paths.get("screenshots");

		try {
			// Membuat folder jika belum tersedia
			Files.createDirectories(screenshotDirectory);

			// Mengambil screenshot dari browser
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Menentukan lokasi file tujuan
			Path destination = screenshotDirectory.resolve(fileName);

			// Menyalin screenshot ke folder tujuan
			Files.copy(source.toPath(), destination);

			System.out.println("Screenshot saved: " + destination.toAbsolutePath());

			return destination.toString();

		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());

			return null;
		}
	}
}
