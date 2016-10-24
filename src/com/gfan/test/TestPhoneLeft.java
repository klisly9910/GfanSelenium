package com.gfan.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.driver.Driver;

/**
 * phone channel left top box size
 * @author xiaohua
 *
 */
public class TestPhoneLeft {

	static WebDriver driver;
	String url = "http://phone.gfan.com/";

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		Driver.getDriver("firefox");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public static void phoneLeft() {
		WebElement toutiao = driver.findElement(By
				.xpath("html/body/div[3]/div[1]/div[1]/h1"));
		String text = toutiao.getText();
		Assert.assertEquals(text, "手机头条");

		List<WebElement> phone01_left = driver.findElements(By
				.xpath("html/body/div[3]/div[1]/div[1]"));

		List<WebElement> iphone01_box = driver.findElements(By
				.xpath("html/body/div[3]/div[1]/div[1]/div"));
		for (int i = 0; i < phone01_left.size(); i++) {
			for (int j = 0; j < iphone01_box.size(); j++) {
				// System.out.println("第" + j + "个box");
				Assert.assertEquals(iphone01_box.size(), 3);
			}
			System.out.println("一共有" + iphone01_box.size() + "个模块");
		}

	}

	@AfterClass
	public void close() {
		driver.close();
	}

}
