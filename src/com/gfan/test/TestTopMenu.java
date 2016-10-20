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

/**
 * test top menu click menu
 * 
 * @author xiaohua
 * 
 */
public class TestTopMenu {
	WebDriver driver;
	String url = "http://www.gfan.com";

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		Driver.getDriver("firefox");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void testCase() {
		driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/div/div[1]/h1/a"))
				.click();
		String gfan = driver.getCurrentUrl();
		Assert.assertEquals(gfan, "http://gfan.com");
		driver.get(url);

		driver.findElement(By.xpath(".//*[@id='nav-top']/div/div/div[2]/a"))
				.click();
		String bbs = driver.getCurrentUrl();
		Assert.assertEquals(bbs, "http://bbs.gfan.com");
		driver.get(url);

		driver.findElement(By.xpath(".//*[@id='nav-top']/div/div/div[3]/a"))
				.click();
		String store = driver.getCurrentUrl();
		Assert.assertEquals(store, "http://www.gfanstore.com/");
		driver.get(url);

		driver.findElement(By.xpath(".//*[@id='nav-top']/div/div/p[1]/a"))
				.click();
		String u_name = driver.getCurrentUrl();
		Assert.assertEquals(u_name, "http://www.uyou.com/");
		driver.get(url);

		driver.findElement(By.xpath(".//*[@id='nav-top']/div/div/p[2]/a"))
				.click();
		String pay = driver.getCurrentUrl();
		Assert.assertEquals(pay, "http://www.pay.gfan.com");
		driver.get(url);

		driver.findElement(By.xpath(".//*[@id='nav-top']/div/div/p[3]/a"))
				.click();
		String dev = driver.getCurrentUrl();
		Assert.assertEquals(dev, "http://dev.gfan.com");
		driver.get(url);

		driver.findElement(By.xpath(".//*[@id='nav-top']/div/div/p[4]/a"))
				.click();
		String game = driver.getCurrentUrl();
		Assert.assertEquals(game, "http://game.gfan.com/gds/index.html");
		driver.get(url);

	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
