package com.qa.Synchroniztion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_Wait2 {

	static String uname= "test@gmail.com";
	static String pass1 = "pass@123";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		 By input1 = By.id("email");
		 By input2 = By.id("pass");
		 
		 WaitforElement(driver, 5, input1);
		 driver.findElement(input1).sendKeys(uname);
		 WaitforElement(driver, 10, input2);	
		 driver.findElement(input2).sendKeys(pass1);
		 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//button[@name=\"login\"]"));
		 Thread.sleep(3000);
		 driver.close();
	}

	public static WebElement WaitforElement(WebDriver driver,int timeout, By Locator)
	{
		WebDriverWait wt  =  new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement el= wt.until(ExpectedConditions.presenceOfElementLocated(Locator));
		return driver.findElement(Locator);
	}
}
