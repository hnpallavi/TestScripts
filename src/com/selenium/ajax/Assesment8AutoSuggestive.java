package com.selenium.ajax;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class Assesment8AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		String input = "Slovakia (Slovak Republic)";
		WebElement selectedTextBox =  driver.findElement(By.cssSelector("input[class='inputs ui-autocomplete-input']"));
		selectedTextBox.sendKeys("rep");
		Thread.sleep(3000);
		selectedTextBox.sendKeys(Keys.DOWN);
		String value = selectedTextBox.getText();
		int i=0;
		while(!value.equalsIgnoreCase(input)){
			i++;
			selectedTextBox.sendKeys(Keys.DOWN);
			value = selectedTextBox.getText();
			if(i>15){
				break;
			}
		}
		if(i>15){
			System.out.println(input+" Element not found");
			}
			else{
				System.out.println(value+" Element found");
			}		
	
		
		
			driver.quit();

	}

}
