package com.gfan.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.driver.Driver;

public class TestSearch {
	WebDriver driver;
	String url = "http://www.gfan.com";

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		Driver.getDriver("firefox");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testCase(WebDriver driver) throws InterruptedException {
		driver.get(url);
		driver.findElement(By.name("Q")).click();
		driver.findElement(By.name("Q")).sendKeys("天仙变");
		driver.findElement(
				By.xpath("html/body/div[2]/div/div[1]/div/form/input[12]"))
				.click();
		Thread.sleep(5000);
		String text = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(text, "搜索结果");
	}

	@AfterTest
	public void close(WebDriver driver) {
		driver.close();
	}

}
