package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assesment2UIDropDowns {

	public static void main(String[] args) {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByIndex(2);
		s = new Select(driver.findElement(By.id("Childrens")));
		s.selectByValue("1");
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(
				By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active"))
				.click();
		driver.findElement(By.id("MoreOptionsLink")).click();
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");
		driver.findElement(By.id("SearchBtn")).click();
		System.out.println(driver.findElement(By.id("homeErrorMessage"))
				.getText());
		driver.quit();

	}

}
