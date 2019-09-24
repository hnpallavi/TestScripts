package com.selenium.locators;

import java.util.Arrays;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartScript {

	public static void main(String[] args) throws InterruptedException {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String[] toOrder = { "Cauliflower", "Potato", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> product = driver.findElements(By
				.cssSelector("h4.product-name"));

		int j = 0;
		for (int i = 0; i < product.size(); i++) {
			String[] itemSpilted = product.get(i).getText().split("-");

			String formatName = itemSpilted[0].trim();
			List<String> toOrderList = Arrays.asList(toOrder);

			if (toOrderList.contains(formatName)) {
				j++;
				driver.findElements(
						By.xpath("//div[@class='product-action']/button"))
						.get(i).click();
				if (j == toOrder.length) {
					break;
				}
			}

		}
		WebDriverWait temp = new WebDriverWait(driver, 5);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']"))
				.click();
		temp.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys(
				"abdgcgds");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		temp.until(ExpectedConditions.visibilityOfElementLocated(By
				.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo"))
				.getText());
		// driver.quit();
	}

}
