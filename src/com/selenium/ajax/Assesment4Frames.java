package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assesment4Frames {

	public static void main(String[] args) {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Nested Frames")).click();
		// System.out.println(driver.findElements(By.tagName("frame")).size());
		// //There are 2 outer frames

		// driver.switchTo().frame("frame-top");
		driver.switchTo().frame(
				driver.findElement(By.cssSelector("[name='frame-top']")));
		driver.switchTo().frame(
				driver.findElement(By.cssSelector("[name='frame-middle']")));
		// driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());

		driver.quit();
	}

}
