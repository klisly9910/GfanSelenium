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
import com.gfan.pub.*;

public class TestLogin {
	WebDriver driver;
	String url = "http://my.gfan.com/login";

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		Driver.getDriver("firefox");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void testLogin() throws InterruptedException {
		driver.get(url);
		String name = "imopan501";
		String password = "123456";
		Login.Logingfan(driver, name, password);
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath(".//*[@id='u_name']")).getText();
		Assert.assertEquals(text, "imopan501");
		String text1 = driver.findElement(By.xpath("html/body/div[4]/div[1]/div/div[2]/div/p")).getText();
		Assert.assertEquals(text1, "imopan501");
		Thread.sleep(5000);
		Login.logout(driver);
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
