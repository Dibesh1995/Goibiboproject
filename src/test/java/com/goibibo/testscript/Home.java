package com.goibibo.testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.goibibo.generic.BaseClass;
import com.goibibo.pom.HotelsPage;
import com.goibibo.resource.ExtentReportListner;
public class Home extends BaseClass {
	private static Logger log= LogManager.getLogger(Home.class.getName());
	ExtentReports extent=ExtentReportListner.extentReport();

	@Test
	public void homepage() throws IOException, AWTException
	{
		ExtentTest test=extent.createTest("homepage");
		log.info("opening the browser");
		driver.get("https://www.goibibo.com/hotels/"); //Enter the url
		log.info("enter to the hotels page");
		HotelsPage h1=new HotelsPage(); //create an object of HotelsPage POM class
		PageFactory.initElements(driver, h1); // initialize the element
		Reporter.log(h1.setdata(),true); // print the statement
		extent.flush();
		

	}

}
