package com.qa.Synchroniztion;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.util.TimeUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/");
		
		FluentWait wt = new FluentWait(driver);
		
		
		wt.withTimeout(Duration.ofSeconds(20));
		wt.pollingEvery(Duration.ofSeconds(5));
		wt.ignoring(NoSuchElementException.class);
		
		wt.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),\"Facebook helps you connect and share with the people in your life.\")]")));
		System.out.println("verification done...!!");
		
		driver.close();
	}

}
