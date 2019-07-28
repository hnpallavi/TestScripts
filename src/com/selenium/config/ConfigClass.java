package com.selenium.config;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigClass {

	static String browser;
	static String driver_path;
	static String pkg_path;
	WebDriver driver;
	int choice;
	ResourceBundle rb = ResourceBundle.getBundle("application");

	public ConfigClass() {
		browser = rb.getString("browser");
		pkg_path = System.getProperty("user.dir");
		driver_path = rb.getString("driver_path");
		choice = Integer.parseInt(rb.getString("choice"));

	}
	
	public int getUserChoice(){
		return choice;
	}

	public String getBrowserValue() {
		return browser;
	}

	public String getdriverPathValue() {
		return driver_path;
	}

	public WebDriver setBrowserConfig(String browser, String driver_path) {
		ConfigClass.browser = browser;
		ConfigClass.driver_path = driver_path;
		if (ConfigClass.browser.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", pkg_path
					+ ConfigClass.driver_path);
			System.setProperty("webdriver.firefox.bin",
					"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			driver = new FirefoxDriver();

		} else if (ConfigClass.browser.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", pkg_path
					+ ConfigClass.driver_path);
			driver = new ChromeDriver();
		}
		return driver;
	}

}
