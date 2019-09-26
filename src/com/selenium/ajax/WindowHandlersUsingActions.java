package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class WindowHandlersUsingActions {

	public static void main(String[] args) {

		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Actions obj = new Actions(driver);

		// finds search box->click->enter char in upper case->select entered
		// text->
		obj.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
				.click().keyDown(Keys.SHIFT).sendKeys("water bottle")
				.doubleClick().build().perform();

		// move to hello sign in and just do right click
		obj.moveToElement(driver.findElement(By.id("nav-link-accountList")))
				.contextClick().build().perform();
		System.out.println(driver.getTitle());

		driver.quit();

	}

}
