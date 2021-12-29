package com.goibibo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
 {
	public WebDriver driver;             //common declaration for driver
	@BeforeClass
	 public WebDriver intialiserDriver() throws IOException
	 {
		 FileInputStream fis=new FileInputStream("./data/Goibibo.property");	 // taking data from property file
		 Properties p=new Properties(); 
		 p.load(fis);
		String browser = p.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))   // code for opening browser in chrome
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))  // code for opening browser in firefox
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("InternetExplorer")) //// code for opening browser in IE
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();  //maximize the browser
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //for synchronization
		
		return driver;
		
		
	 }
     public void takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
	
	}
	@AfterClass
	  public void closeBrowser()  // to close the browser
	  {
		  driver.quit();
	  }

}
