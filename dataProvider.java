package com.cisco.page;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class dataProvider 
{
	@Test(dataProvider="data")
	
	public void setUp(String username , String password)
	{
		System.setProperty("webdriver.chrome.driver", ".//Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://testing-ground.scraping.pro/login");
		driver.findElement(By.xpath("//input[@id='usr']")).sendKeys(username);
		WebElement pwd=driver.findElement(By.xpath("//input[@id='pwd']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("arguments[0].value= '"password"';", pwd);
		pwd.sendKeys(password);
		WebElement btn = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click();",btn);
		String txt = driver.findElement(By.xpath("//h3")).getText();
		System.out.println(txt);
		Assert.assertEquals(txt,"WELCOME :)","Hey man its not matching");
		driver.quit();
	}
	@DataProvider
	public Object [][] data()
	{
		return new Object[][]
				{
					{"admin","12345"},{"admin","123"},{"adm","12345"},{"ad","12"},{"a","1"},{"12345","admin"},{"admin","12345"}
				};
	}

}
