package com.qa.Synchroniztion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_Wait1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		 WebDriver driver = new ChromeDriver();
		 
		 driver.manage().window().maximize();
		 driver.get("https://www.facebook.com/");
		
		
		 WebDriverWait wt= new WebDriverWait(driver, Duration.ofSeconds(20));
		 WebElement  el1= wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

		el1.sendKeys("test123@gmail.com");
		 
		 
		 
		WebElement el2 = wt.until(ExpectedConditions.presenceOfElementLocated(By.id("pass")));
		el2.sendKeys("Newuser@159$");		
		
		driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Completed2........!!");
		
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

//visibilityOfElementLocated, elementToBeClickable, elementToBeSelected
	
}
