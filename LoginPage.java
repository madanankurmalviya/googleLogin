package com.cisco.page;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.File;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginPage 
{
	public WebDriver driver;
	public Properties prop;
	public JavascriptExecutor js;
	
	
	public void propertiesMethod() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\ANKUR MALVIYA\\eclipse\\New\\CiscoProject\\src\\main\\java\\com\\cisco\\property\\prop");
		prop.load(fis);
	}
	
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		WebElement txt =driver.findElement(By.xpath(".//div[@class='gb_Ma gb_Ag gb_i gb_zg gb_Dg gb_Sf']"));
				
	}
	
	@Test(enabled=false)
	public void CiscoLogin()
	{
		WebElement element = driver.findElement(By.xpath("(.//input[@name='btnK'])[2]"));
		String ele = element.getAttribute("value");
		System.out.println("The message is :"+ele);
		Assert.assertEquals(ele, "Google Search");
		element.click();
	}
	
	@Test(enabled=false)
	public void checkPropertyTest() throws InterruptedException
	{
		WebElement search = driver.findElement(By.xpath("(.//input[@name='q'])[1]"));
		search.sendKeys("ankur malviya");
		WebElement element = driver.findElement(By.xpath("(.//input[@name='btnK'])[1]"));
		element.click();
		
		WebElement e = driver.findElement(By.xpath("(.//input[@type='text'])[1]"));
		e.clear();
		
//		e.sendKeys("123");

		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800);");
		Thread.sleep(3000);
		js.executeScript("arguments[0].value='Hello World'",e);
		Thread.sleep(3000);
	}
	
	@Test(enabled=false)
	public void print()
	{
		js=(JavascriptExecutor)driver;
		String print = js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println(print);
	}
	
	@Test(enabled=false)
	public void alertPrint() 
	{
		js= (JavascriptExecutor)driver;
		js.executeScript("alert('Hello World');");
	}
	
	@Test(enabled=false)
	public void returnUrl()
	{
		js = (JavascriptExecutor)driver;
		String url =js.executeScript("return document.URL;").toString();
		System.out.println(url);
	}
	
	@Test
	public void returnEntry()
	{
		js = (JavascriptExecutor)driver;
		js.executeScript("history.go()");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		TakesScreenshot sht =(TakesScreenshot) driver;
		File src = sht.getScreenshotAs(OutputType.FILE);
		File dest = new File (".//Driver/picture.jpeg");
		Files.copy(src,dest);		
		driver.quit();
	}
}
