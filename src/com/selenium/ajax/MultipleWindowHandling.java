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
		Set<String> id = driver.getWindowHandles();   //returns ids of all opened windows
		Iterator<String> temp = id.iterator();			//stores base index
		String parentId = temp.next();					//moves to 0th index - first id will be parent window's
		String childId = temp.next();					//traverse to first child windows id
		driver.switchTo().window(childId);  			//switch to particular window with respective id
		System.out.print("After switching to child window: ");
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentId);
		System.out.print("Swicthing back to parent window: ");
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
