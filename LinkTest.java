package com.cisco.page;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

public class LinkTest 
{
	
	@Test
	public void LinkTest()
	{
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
		
		//to find number of links
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		for(WebElement aa:list)
		{
			System.out.println(aa.getText());
		}
		
		driver.close();
	}

}
