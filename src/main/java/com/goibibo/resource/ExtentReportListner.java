 package com.goibibo.resource;

import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListner {
	
	public static ExtentReports extent;
	
	
	@BeforeMethod
	public static  ExtentReports extentReport()
	{
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Omayo Test Results");
	reporter.config().setDocumentTitle("A Test Results");
	extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Operating System","Windows 11");
	extent.setSystemInfo("Tested By","Dibesh Pradhan");
	return extent;
	}
	
	
	
	

}
