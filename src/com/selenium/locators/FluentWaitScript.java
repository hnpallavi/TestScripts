package com.selenium.locators;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class FluentWaitScript {

	public static void main(String[] args) {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		Wait<WebDriver> obj = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
		WebElement text = obj.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
		    	   return driver.findElement(By.cssSelector("[id='finish'] h4"));
		       }
		       else{
		    	   return null;
		       }
		    	   
		     }
		   });
		System.out.println(text.getText());

		//System.out.println(obj.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[id='finish'] h4")))).getText());
		//In fluent wait we can use Expected condition but it is not recommended

		driver.quit();

	}

}
