package com.selenium.handson;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;



public class RealTimeExample {

	public static void main(String[] args) throws InterruptedException {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", pkg_path
				+ "\\jars\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin",
				"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");
		System.out.println("Number of links present in this page : "
				+ driver.findElements(By.tagName("a")).size());

		// If we need to limit scope to particular section then need to create
		// WebElement first and repeat respective action

		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println("NUmber of links in footer : "
				+ footer.findElements(By.tagName("a")).size());
		WebElement column1 = footer.findElement(By
				.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Number of links in first column : "
				+ column1.findElements(By.tagName("a")).size());
		int i = column1.findElements(By.tagName("a")).size();
		for (int j = 1; j < i; j++) {
			String clickAction = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column1.findElements(By.tagName("a")).get(j).sendKeys(clickAction); // opens
																				// all
																				// the
																				// links
																				// in
																				// separate
																				// tabs
			Thread.sleep(5000L);
		}

		Set<String> id = driver.getWindowHandles(); // returns ids of all opened
													// tabs
		Iterator<String> it = id.iterator(); // moves to the base index

		while (it.hasNext()) { // checks whether next index is present
			driver.switchTo().window(it.next()); // moves to next index
			System.out.println(driver.getTitle());
		}

		driver.quit();

	}

}
