package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableHandling {

	public static void main(String[] args) {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		int sum = 0;
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22744/ind-vs-rsa-2nd-test-south-africa-tour-of-india-2019");
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By
				.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		// int rowCount =
		// table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		int columnCount = table
				.findElements(
						By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
				.size();//parent child traversing using cssSelector
		for (int i = 0; i < columnCount - 2; i++) {
			String score = table
					.findElements(
							By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
					.get(i).getText();
			sum = sum + (Integer.parseInt(score));

		}
		int extras = Integer.parseInt(table.findElement(
				By.xpath("//div[text()='Extras']/following-sibling::div"))
				.getText());

		int totalScoreDisplayed = Integer.parseInt(table.findElement(
				By.xpath("//div[text()='Total']/following-sibling::div"))
				.getText());

		int totalSum = sum + extras;
		System.out.println("Calculated score is : " + totalSum);
		System.out.println("Total score displayed is : " + totalScoreDisplayed);
		if (totalSum == totalScoreDisplayed) {
			System.out.println("Test passed!");
		} else {
			System.out.println("Test Failed...");
		}
		driver.quit();
	}

}
