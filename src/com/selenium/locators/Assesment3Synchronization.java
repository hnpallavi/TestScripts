package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assesment3Synchronization {

	public static void main(String[] args) {
		String usr_dir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_dir
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.findElement(By.cssSelector("a[href*='loadAjax']")).click();
		/*driver.findElement(
				By.xpath("//*[text()='Click to load get data via Ajax!']"))
				.click();*/
		WebDriverWait obj = new WebDriverWait(driver, 3);
		//obj.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='results']")));

		obj.until(ExpectedConditions.visibilityOf(driver.findElement(By
				.xpath("//div[@id='results']"))));
		System.out.println(driver.findElement(By.xpath("//div[@id='results']"))
				.getText());
		driver.quit();

	}

}
