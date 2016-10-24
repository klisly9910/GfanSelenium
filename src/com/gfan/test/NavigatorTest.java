package com.gfan.test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.driver.Driver;

/**
 * click logo and top navigator->get title & url
 * 
 * @author xiaohua
 * 
 */
public class NavigatorTest {

	WebDriver driver;
	String url = "http://www.gfan.com/new/";

	@BeforeMethod
	public void setUp() {
		Driver.getDriver("firefox");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test(enabled = false)
	public void clickLogo() {
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/a/img")).click();
		// 得到当前窗口的句柄
		String currentWindow = driver.getWindowHandle();
		// System.out.println("curr title = " + driver.getTitle());
		// 得到所有窗口的句柄
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		System.out.println("size :" + handles.size());
		while (it.hasNext()) {// hasNext()检查序列中是否还有元素
			String handle = it.next();// 使用next()获得序列中的下一个元素
			if (currentWindow.equals(handle))// 判断遍历的handle元素是否与currentWindow
												// 元素一致
				continue;
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "机锋网");
			System.out.println(" phone title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();// 关闭窗口

	}

	@Test(enabled = true)
	public void clickPhone() throws InterruptedException {
		// driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/ul/li[1]/a"))
				.click();
		// 得到当前窗口的句柄
		String currentWindow = driver.getWindowHandle();
		// System.out.println("curr title = " + driver.getTitle());
		// 得到所有窗口的句柄
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		System.out.println("size :" + handles.size());
		while (it.hasNext()) {// hasNext()检查序列中是否还有元素
			String handle = it.next();// 使用next()获得序列中的下一个元素
			if (currentWindow.equals(handle))// 判断遍历的handle元素是否与currentWindow
												// 元素一致
				continue;
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "手机 - 机锋网");
			System.out.println(" phone title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();

	}

	@Test(enabled = true, dependsOnMethods = "clickPhone")
	public void clickComputer() throws InterruptedException {
		// driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/ul/li[2]/a"))
				.click();
		// driver.findElement(By.xpath("html/body/div[2]/div/ul/li[2]/a")).click();
		// 得到当前窗口的句柄
		String currentWindow = driver.getWindowHandle();
		// 得到所有窗口的句柄
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size :" + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (currentWindow.equals(handle))
				continue;
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "电脑 - 机锋网");
			System.out.println("computer title,url = " + window.getTitle()
					+ "," + window.getCurrentUrl());
		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();
	}

	@Test(enabled = true, dependsOnMethods = "clickComputer")
	public void clickSmart() {
		// driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/ul/li[3]/a"))
				.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size :" + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (handle.equals(currentWindow)) {
				continue;
			}
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "智能 - 机锋网");
			System.out.println("smart title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();
	}

	@Test(dependsOnMethods = "clickSmart")
	public void clickWemedia() {
		// driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/ul/li[4]/a"))
				.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size :" + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (handle.equals(currentWindow)) {
				continue;
			}
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "新媒体 - 机锋网");
			System.out.println("weMedia title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();
	}

	@Test(dependsOnMethods = "clickWemedia")
	public void clickJiaDian() {
		// driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/ul/li[5]/a"))
				.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size :" + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (handle.equals(currentWindow)) {
				continue;
			}
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "家电 - 机锋网");
			System.out.println("jiadian title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();
	}

	@Test(dependsOnMethods = "clickJiaDian")
	public void clickOffice() {
		// driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/ul/li[6]/a"))
				.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size :" + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (handle.equals(currentWindow)) {
				continue;
			}
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "办公 - 机锋网");
			System.out.println("office title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();
	}

	@Test(dependsOnMethods = "clickOffice")
	public void clickBBS() {
		// driver.get(url);
		driver.findElement(By.xpath(".//*[@id='nav-top']/div/ul/li[7]/a"))
				.click();
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("size :" + handles.size());
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			if (handle.equals(currentWindow)) {
				continue;
			}
			WebDriver window = driver.switchTo().window(handle);
			Assert.assertEquals(window.getTitle(), "机锋论坛 - 机锋网");
			System.out.println("BBS title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
		WebDriver backWindow = driver.switchTo().window(currentWindow);
		System.out.println("backWindown = " + backWindow.getTitle() + ","
				+ backWindow.getCurrentUrl());
		driver.close();
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
}
