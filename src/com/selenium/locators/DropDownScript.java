package com.selenium.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownScript {

	public static void main(String[] args) throws InterruptedException {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		// Static drop-down handling using Select class
		Select s = new Select(driver.findElement(By
				.id("ctl00_mainContent_DropDownListCurrency")));
		s.selectByValue("AED");
		s.selectByVisibleText("INR");
		s.selectByIndex(3);

		// Incrementally selecting option when there is no Select tag for Static
		// drop down
		driver.findElement(By.id("divpaxinfo")).click();
		System.out.println("Initial selected Adults : "
				+ driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(2000L);
		for (int i = 0; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("Number of Adults selected is : "
				+ driver.findElement(By.id("divpaxinfo")).getText());

		// Dynamic drop down

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"))
				.click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		// using index is not recommended
		driver.findElement(
				By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();// parent-child relationship

		driver.quit();
	}

}
