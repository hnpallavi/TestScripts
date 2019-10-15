package com.selenium.handson;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalender {

	public static void main(String[] args) {
		String pkg_path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", pkg_path
				+ "\\jars\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		boolean case1 = driver.findElement(By.cssSelector("div.ui-datepicker-header.ui-widget-header.ui-helper-clearfix.ui-corner-left div.ui-datepicker-title")).getText().contains("November");
		WebElement case2 = driver.findElement(By.cssSelector("div.ui-datepicker-header.ui-widget-header.ui-helper-clearfix.ui-corner-right div.ui-datepicker-title"));
		if(case1){
			System.out.println("current month");
		}
		else{
			while(!case2.getText().contains("November")){
				driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
			}
			
		}	
		List<WebElement> dates = driver.findElements(By.className("ui-state-default"));
		int datesCount = dates.size();
		for(int i =0;i<datesCount;i++){
			String selectedDate = dates.get(i).getText();
			if(selectedDate.equals("23")){
				dates.get(i).click();
				break;
			}
		}

	}

}
