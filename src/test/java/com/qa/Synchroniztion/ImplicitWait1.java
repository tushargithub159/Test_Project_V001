package com.qa.Synchroniztion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement el1 = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		el1.sendKeys("test123@gmail.com");
		
		WebElement el2 = driver.findElement(By.xpath("//input[@id=\"pass\"]"));
		el2.sendKeys("Newuser@159$");
		
		driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
		
		Thread.sleep(2000);
		
		System.out.println("Completed........!!");
		
		try
		{
			driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
