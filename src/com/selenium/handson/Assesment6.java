package com.selenium.handson;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assesment6 {

	public static void main(String[] args) {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.findElement(By.id("checkBoxOption2")).click();
		String inputText = driver.findElement(
				By.xpath("//input[@id='checkBoxOption3']/parent::label"))
				.getText();
		System.out.println("Input text is : " + inputText);
		Select dropDown = new Select(driver.findElement(By
				.id("dropdown-class-example")));
		dropDown.selectByVisibleText(inputText);
		driver.findElement(By.cssSelector("input#name")).sendKeys(inputText);
		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println("Alert text is : " + alertText);
		if (alertText.contains(inputText)) {
			System.out.println("Input text \"" + inputText
					+ "\" is present in alert text!");
		} else {
			System.out.println("Input text \"" + inputText
					+ "\" is not present in alert text!");
		}
		driver.quit();
	}

}
