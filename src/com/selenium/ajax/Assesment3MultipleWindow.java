package com.selenium.ajax;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assesment3MultipleWindow {

	public static void main(String[] args) {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		Set<String> id = driver.getWindowHandles();
		Iterator<String> index = id.iterator();
		String parent = index.next();
		String child = index.next();
		driver.switchTo().window(child);
		System.out.println(driver.findElement(By.cssSelector("div.example h3"))
				.getText());
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.cssSelector("div.example h3"))
				.getText());
		driver.quit();

	}

}
