package com.selenium.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCartScript {

	public static void main(String[] args) {
		String usr_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", usr_path
				+ "//jars//chromedriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String search = "Beetroot";
		List<WebElement> array = driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<array.size();i++){
			String value = array.get(i).getText();
			
			if(value.contains(search)){
				driver.findElements(By.xpath("//*[text()='ADD TO CART']")).get(i).click();
				break;

			}
			
				
		}

	}

}
