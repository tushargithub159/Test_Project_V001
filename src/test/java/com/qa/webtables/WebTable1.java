package com.qa.webtables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement el=driver.findElement(By.xpath("//p[@class=\"intro\"]"));
		js.executeScript("arguments[0].scrollIntoView(true);",el );
		
			Thread.sleep(3000);
		
		  List <WebElement> lst  = driver.findElements(By.xpath("//table[@id=\"customers\"]//tbody//tr"));
		
		  int Rows= lst.size();
		
		  for (WebElement el2: lst)
		  {
			  System.out.println(el2.getText());
		  }
		  
		  
		   List<WebElement>lst2=driver.findElements(By.xpath("//table[@id=\"customers\"]//tbody//tr//th"));
		  
		  int colmn = lst2.size();
		  
		  for (int i=2; i<=Rows;i++)
		  {
			  for (int j=1;j<=colmn;j++)
			  {
				 String data = driver.findElement(By.xpath("//table[@id=\"customers\"]/tbody/tr["+i+"]/td["+j+"]")).getText();;
				 
				 System.out.print(data+ " |  ");
			  }
			  System.out.println();
		  }
		  
		System.out.println("completed.!");
		driver.close();
	}

}
