package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestScriptRediff {
public static void main(String[] args) {
	
	String pkg_path = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", pkg_path+"\\jars\\chromedriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rediff.com");
	driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
	driver.findElement(By.xpath("//*[@id='login1']")).sendKeys("hello123");
	driver.findElement(By.cssSelector("#password")).sendKeys("pasww123");
	driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();
	driver.quit();
}
}
