package com.selenium.ajax;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandling {

	public static void main(String[] args) {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// It will open separate tab/window but does not switch to child
		// window/tab
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dtopnav-about-n-en&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.xpath("//*[text()='Help']")).click();
		System.out.print("Before switching : ");
		System.out.println(driver.getTitle());
		Set<String> id = driver.getWindowHandles();
		Iterator<String> temp = id.iterator();
		String parentId = temp.next();
		String childId = temp.next();
		driver.switchTo().window(childId);
		System.out.print("After switching to child window: ");
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.print("Swicthing back to parent window: ");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
