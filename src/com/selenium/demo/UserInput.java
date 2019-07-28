package com.selenium.demo;

import org.openqa.selenium.WebDriver;

import com.selenium.config.ConfigClass;

public class UserInput {

	public void run() {
		String browser;
		String driver_path;
		WebDriver driver;
		int choice;
		ConfigClass c = new ConfigClass();
		browser = c.getBrowserValue();
		driver_path = c.getdriverPathValue();
		driver = c.setBrowserConfig(browser, driver_path);
		choice = c.getUserChoice();

		SeleniumRunScripts sc = null;

		switch (choice) {
		case 1:
			sc = new DriverApiScript();

			break;

		case 2:
			sc = new FbLoginScript();

			break;

		default:
			System.out.println("Invalid choice!");
			driver.quit();
		}
		sc.runScripts(driver);
	}
}
