package com.simplilearn.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGridExample {
	
//	Create an object for remote webdriver
	public static RemoteWebDriver driver;
	
	@Test
	
	public void GridTestCase() throws MalformedURLException {
		
		String url = "http://192.168.0.107:4444/wd/hub";
		//create an object for desired Capabilities to send the appropriate command to Node machine
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setPlatform(Platform.WINDOWS); //Set plantform 
		caps.setBrowserName("chrome"); //set name for browser
		
		ChromeOptions options = new ChromeOptions();
		options.merge(caps);
		 
		driver = new RemoteWebDriver(new URL(url), caps);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.cssSelector("#login > button")).click();
		
		driver.close();

	}

}
