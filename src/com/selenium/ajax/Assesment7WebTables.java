package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assesment7WebTables {

	public static void main(String[] args) {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By
				.xpath("//table[@id='product']"));
		int rowCount = table.findElements(By.tagName("tr")).size();
		System.out.println("Number of rows : " + rowCount);
		int columnCount = table.findElements(By.tagName("tr")).get(0)
				.findElements(By.tagName("th")).size();
		System.out.println("Number of columns : " + columnCount);
		System.out.println("Row 2 value is : ");
		for (int i = 0; i < columnCount; i++) {
			String rowValue = table.findElements(By.tagName("tr")).get(2)
					.findElements(By.tagName("td")).get(i).getText();
			System.out.print(rowValue + "||");
		}
		driver.quit();
	}

}
