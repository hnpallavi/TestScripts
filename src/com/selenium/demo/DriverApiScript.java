package com.selenium.demo;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class DriverApiScript implements SeleniumRunScripts {

	public void runScripts(WebDriver driver) {
		Dimension d = new Dimension(640, 640);
		driver.manage().window().setSize(d);
		driver.get("http://seleniumhq.org/");
		driver.manage().window().fullscreen();

		System.out.println("Curretntly used URL is  : "
				+ driver.getCurrentUrl());
		System.out.println("Page title : " + driver.getTitle());
		System.out.println("Session ID is : " + driver.getWindowHandle());
		driver.quit();
	}

}
