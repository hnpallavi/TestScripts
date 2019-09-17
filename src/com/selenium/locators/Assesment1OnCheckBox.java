package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assesment1OnCheckBox {

	public static void main(String[] args) {
		String usr_dir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_dir
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		WebElement checkBox = driver.findElement(By.id("checkBoxOption1"));
		checkBox.click();
		if (checkBox.isSelected()) {
			System.out.println("Succesfully checked the first checkbox");
		}
		checkBox.click();
		if (!checkBox.isSelected()) {
			System.out.println("Succesfully unchecked the check box");
		}

		System.out.println("Number of check box : "
				+ driver.findElements(By.xpath("//input[@type='checkbox']"))
						.size());

		driver.quit();
	}

}
