package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoOfLocators {

	public static void main(String[] args) {
		
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path+"\\jars\\chromedriver\\chromedriver.exe");
		WebDriver dri = new ChromeDriver();
		dri.get("http://facebook.com");
		
		dri.findElement(By.name("email")).sendKeys("hnpallavi94@gmail.com");
		dri.findElement(By.id("pass")).sendKeys("hello123");
		//dri.findElement(By.xpath("//input[@value='Log In']")).click();
		dri.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//dri.findElement(By.cssSelector("#loginbutton")).click();
		
		/*dri.get("https://login.salesforce.com");
		dri.findElement(By.id("username")).sendKeys("abcd");
		dri.findElement(By.name("pw")).sendKeys("1234");
		dri.findElement(By.xpath("//*[@id='Login']")).click();
		System.out.println(dri.findElement(By.cssSelector("div#error.loginError")).getText());*/
		
		
		
		//dri.quit();
		
		
	}
}
