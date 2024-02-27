package com.qa.Links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int brokenLink=0;
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 List <WebElement> links= driver.findElements(By.tagName("a"));
		
		 int totLinks = links.size();
		 
		 System.out.println(totLinks);
		 
		 for (WebElement ele : links)
		 {
			 	String url	 = ele.getAttribute("href");
			 	
			 	if (url == null || url.isEmpty())
			 	{
			 		System.out.println("URL is Empty");
			 	}
			 	
			 	  URL ul = new URL(url);
			 	   HttpURLConnection httpCode = (HttpURLConnection) ul.openConnection();
			 	   
			 	   httpCode.connect();
			 	   
			 	   if(httpCode.getResponseCode() >= 400) {
			 		   
			 		   System.out.println(httpCode.getResponseCode()+  "--> " + url +"  is broken link");
			 		   brokenLink++;
			 	   }
			 	  
			 	   else {
			 		   System.out.println(httpCode.getResponseCode()+ "-->" +url + "is not a broken link");
			 	   }
		 }

		 System.out.println(brokenLink);
		 driver.close();
	}

}
