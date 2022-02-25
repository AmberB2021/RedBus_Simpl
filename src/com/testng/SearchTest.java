package com.testng;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchTest{

WebDriver driver;

List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Oct","Nov","Dec");
String expDate = null;
int expMonth;
int expYear;

String calDate = null;
int calMonth;
int calYear;

boolean dateNotFound;

@BeforeTest
public void loadRedBus(){
	System.setProperty("webdriver.chrome", System.getProperty("user.dir") + "/drivers/webdriver");
	driver = new ChromeDriver();

	driver.get("https://www.redbus.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
}

@Test(priority=1)
public void searchBus(){
	WebElement srcElement = driver.findElement(By.id("src"));
	srcElement.clear();
	srcElement.sendKeys("Limkheda");
	driver.findElement(By.xpath(".//*[@id=\"search\"]/div/div[1]/div/label")).click();
	
	
	WebElement dstElement = driver.findElement(By.id("dest"));
	dstElement.clear();
	dstElement.sendKeys("Dindigul");
	driver.findElement(By.xpath(".//*[@id=\"search\"]/div/div[2]/div/label")).click();
}

@Test(priority=2)
public void selectDateCal(){
	WebElement calendar = driver.findElement(By.xpath(".//*[@id=\"search\"]/div/div[3]"));
	calendar.click();
	
	expDate = "15";
	expMonth = 4;
	expYear=2022;
	dateNotFound = true;
	
	
	while(dateNotFound){
		WebElement monthYearEle = driver.findElement(By.xpath(".//*[@id=\"search\"]/div/div[3]/div/label"));
		String monthYear= monthYearEle.getAttribute("innerHTML");
		
		String[] s = monthYear.split(" ");
		String calMonth = s[0];
		int calYear = Integer.parseInt(s[1]);
		
		if(monthList.indexOf(calMonth)+1 ==expMonth && expYear==calYear){
			selectDate(expDate);
			dateNotFound = false;
		}
		
		else if(monthList.indexOf(calMonth)+1 <expMonth && expYear==calYear||expYear>calYear){
			calendar.findElement(By.xpath(".//*[@id=\"rb-calendar_onward_cal\"]")).click();
		}
		else if(monthList.indexOf(calMonth)+1 >expMonth && expYear==calYear||expYear<calYear){
			calendar.findElement(By.xpath(".//*[@id=\"rb-calendar_onward_cal\"]")).click();
		}
	}
	
	driver.findElement(By.xpath(".//*[@id=\"search_btn\"]")).click();
	
}

public void selectDate(String date){
	WebElement datePicker = driver.findElement(By.xpath(".//*[@id=\"rb-calendar_onward_cal\"]"));
	List<WebElement> dates = datePicker.findElements(By.tagName("/td"));
	for(WebElement temp:dates){
		if(temp.getText().equals(date)){
			temp.click();
			break;
		}
	}
}

@AfterTest
public void closeBrowser(){
	driver.close();
}

}
