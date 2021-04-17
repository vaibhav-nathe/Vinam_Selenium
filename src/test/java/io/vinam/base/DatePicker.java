package io.vinam.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		
		String month = "Apr 2021";
		String day = "20";
		
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse_workspace\\Selenium\\io.vinam\\src\\test\\resources\\executable\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dash.vinmail.io/automation-create");
		
		driver.findElement(By.id("input-3")).sendKeys("vaibhav.nathe@gmai.com");
		
	}
}
