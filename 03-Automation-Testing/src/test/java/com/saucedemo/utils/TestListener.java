package com.saucedemo.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.saucedemo.tests.BaseTest;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		Object testInstance = result.getInstance();

		if (testInstance instanceof BaseTest) {

			BaseTest baseTest = (BaseTest) testInstance;

			String testName = result.getMethod().getMethodName();

			System.out.println("TEST FAILED: " + testName);

			ScreenshotUtil.captureScreenshot(baseTest.getDriver(), testName);
		}
	}
}
