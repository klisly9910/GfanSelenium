package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	DriverFactory df = new DriverFactory();
	static WebDriver driver = null;

	private DriverFactory() {
	}

	public static WebDriver getDriver(String d) {
		if (d == "chromea") {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (d == "firefoxa") {
			System.setProperty("webdriver.firefox.bin",
					"C:\\Program Files (x86)\\Mozilla Firefox\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		return driver;

	}
}
