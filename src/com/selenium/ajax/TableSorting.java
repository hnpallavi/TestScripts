package com.selenium.ajax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.asserts.Assertion;

public class TableSorting {

	public static void main(String[] args) {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();  //1st click makes list in descending order
		//driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();  //now it makes list ascend order
		
		List<WebElement> tableList = driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		ArrayList<String> vegValues = new ArrayList<String>();
		ArrayList<String> copiedList = new ArrayList<String>();
		for(int i=0;i<tableList.size();i++){
			vegValues.add(tableList.get(i).getText());
			
		}
		copiedList.addAll(vegValues);
		//sorts by default ascending
		Collections.sort(copiedList);
		for(String as : copiedList){
			System.out.println(as);
		}
		System.out.println("**************");
		//reverse so that it becomes descending
		Collections.reverse(copiedList);
		for(String ds : copiedList){
			System.out.println(ds);
		}
		
		Assert.assertTrue(copiedList.equals(vegValues));
		System.out.println("Veggies are in descending order");
	
		driver.quit();
	}

}
