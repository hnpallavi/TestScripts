package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentSiblingExample {

	public static void main(String[] args) {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path+"\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/interview.php");
		driver.manage().window().maximize();
		// Traversing using sibling concept
		driver.findElement(By.xpath("//li[@id='tablist1-tab1']")).click();
		driver.findElement(
				By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[1]"))
				.click();
		driver.findElement(
				By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[2]"))
				.click();
		driver.findElement(
				By.xpath("//li[@id='tablist1-tab1']/following-sibling::li[3]"))
				.click();
		System.out.println("Current URL is : " + driver.getCurrentUrl());

		// Traversing parent to child

		driver.findElement(
				By.xpath("//section[@id='content']/div/div/div/div/ul/li[3]"))
				.click();

		// Traversing from child to parent

		driver.findElement(By.xpath("//li[@id='tablist1-tab4']/parent::ul"))
				.click();

		driver.quit();

	}

}
