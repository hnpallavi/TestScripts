package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesHandling {

	public static void main(String[] args) {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");

		// switch to frame and then search for web element
		System.out.println(driver.findElements(By.tagName("iframe")).size());  //gives number of frames
		driver.switchTo().frame(0);  //using index but not recommended , better use WebElement
		/*driver.switchTo()
				.frame(driver.findElement(By
						.cssSelector("iframe[class='demo-frame']")));*/
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(src, dest).build().perform(); // drag and drop action
		driver.switchTo().defaultContent(); // switches back from frame to web
											// page
		driver.findElement(By.xpath("//a[contains(@href,'sortable')]")).click();
		driver.quit();

	}

}
