package com.gfan.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPage {
	WebDriver driver;
	String url = "http://www.gfan.com/new/";

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();
	}

	@Test
	public void testCase() {
		WebElement topBanner = driver.findElement(By
				.xpath("html/body/div[3]/div[1]/a/img"));
		// top banner exists,size&location
		Assert.assertEquals(true, topBanner.isDisplayed());
		System.out.println("top banner size = " + topBanner.getSize());
		System.out.println("top banner location = " + topBanner.getLocation());

		// main-left banner exists,size
		List<WebElement> tagA = driver.findElements(By
				.xpath("html/body/div[3]/div[2]/div[1]/div/a"));
		System.out.println("left banner = " + tagA.size() + "张图片");
		Assert.assertEquals(tagA.size(), 3);

		// right banner size,title
		WebElement fengtoutiao = driver.findElement(By
				.xpath("html/body/div[3]/div[2]/div[2]/h1"));
		Assert.assertEquals(fengtoutiao.getText(), "锋头条");
		List<WebElement> rightBox = driver.findElements(By
				.xpath("html/body/div[3]/div[2]/div[2]/div"));
		System.out.println("right box = " + rightBox.size() + "个box");
		Assert.assertEquals(rightBox.size(), 3);

		// middle banner
		WebElement middleBanner = driver.findElement(By
				.xpath("html/body/div[3]/div[3]/a/img"));
		Assert.assertEquals(true, middleBanner.isDisplayed());

	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
