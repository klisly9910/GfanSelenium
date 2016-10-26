package com.gfan.pub;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gfan.test.MainPage;

public class SwitchToWindow {
	public static WebDriver driver;
	public static WebDriver window;

	public static void switchToWindow(WebDriver driver) {
		// MainPage mainPage = new MainPage();
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
			window = driver.switchTo().window(handle);
			System.out.println("title,url = " + window.getTitle() + ","
					+ window.getCurrentUrl());

		}
	}

}
