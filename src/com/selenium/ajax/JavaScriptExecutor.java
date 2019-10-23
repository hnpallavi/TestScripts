package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/");
		driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
		Thread.sleep(3000);
		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
		String input = "BENGALURU";
		//System.out.println(driver.findElement(By.id("fromPlaceName")).getText());  -- this object is hidden so it is not displaying
				
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		String value = "return document.getElementById(\"fromPlaceName\").value;";
		
		String domText = (String) je.executeScript(value);
		int i=0;
		while(!domText.equalsIgnoreCase(input)){
			i++;
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
			domText = (String) je.executeScript(value);
			//System.out.println(domText);
			if(i>10){
				break;
			}
		}
		if(i>10){
		System.out.println(input+" Element not found");
		}
		else{
			System.out.println(input+" Element found");
		}		
		
		/*
		 * Handling SSL certificates
		DesiredCapabilities profileObj = DesiredCapabilities.firefox(); // defining generic profile
		obj.acceptInsecureCerts();									   // sets object to accept insecure sites and proceed
		//ChromeOptions local = new ChromeOptions();
		FirefoxOptions local = new FirefoxOptions();   //object for applying created profile on local browser
		local.merge(profileObj);  //merging 
		system.setProperties();
		WebDriver driver = new FirefoxDriver(local);
		driver.get();
		*/
		
		
		driver.quit();
	}

}
