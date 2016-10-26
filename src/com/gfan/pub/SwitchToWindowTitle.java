package com.gfan.pub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gfan.test.MainPage;

public class SwitchToWindowTitle {
	public static WebElement beforeSwitchTitle;
	public static WebElement afterSwitchTitle;
//	static WebDriver driver;

	public static void getTitle() {
		MainPage mainPage = new MainPage();
		String beforeTitle = beforeSwitchTitle.getText();
		beforeSwitchTitle.click();
		SwitchToWindow.switchToWindow(mainPage.driver);
		boolean hasSameChar = false;
		for (int i = 0; i < beforeTitle.length(); i++) {
			for (int j = 0; j < SwitchToWindow.window.getTitle().length(); j++) {
				if (beforeTitle.charAt(i) == SwitchToWindow.window.getTitle()
						.charAt(j)) {
					char s1 = beforeTitle.charAt(i);
					char s2 = SwitchToWindow.window.getTitle().charAt(j);
					System.out.println("s1 = " + s1 + "," + "s2 = " + s2);
					hasSameChar = true;

				}
			}

		}
		if (hasSameChar) {
			System.out.println("跳转正确");
		} else {
			System.out.println("跳转不正确");
		}

	}

}
