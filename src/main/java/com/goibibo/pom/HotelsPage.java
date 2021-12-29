package com.goibibo.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.goibibo.generic.BaseClass;

public class HotelsPage extends BaseClass {
	
	// here declare all the element and made it private

	@FindBy(xpath="//h4[text()='India']")   
	private WebElement radiobtn;
	@FindBy(xpath="//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")
	private WebElement wheredropdown;
	@FindBy(xpath="//span[contains(text(),'Puri')]")
	private WebElement Loc;
	@FindBy (xpath="//div[text()='Check-in']")
	private WebElement checkin;
	@FindBy (xpath="//span[@data-testid='date_1_0_2022']")
	private WebElement checkindate;
	@FindBy (xpath="//span[@data-testid='date_5_0_2022']")
	private WebElement checkoutdate;
	@FindBy (xpath="//span[text()='Guests & Rooms']")
	private WebElement guestandroom;
	@FindBy (xpath="(//span[text()='+'])[1]")
	private WebElement addadults;
	@FindBy (xpath="(//span[text()='+'])[2]")
	private WebElement addrooms;
	@FindBy (xpath="(//span[text()='+'])[3]")
	private WebElement addchilds;
	@FindBy (xpath="//button[text()='Done']/../../div[4]/div/h4")
	private WebElement childDropdown1;
	@FindBy (xpath="//button[text()='Done']/../../div[4]/ul/li[.='2']")
	private WebElement childage1;
	@FindBy (xpath="//button[text()='Done']/../../div[5]/div/h4")
	private WebElement childDropdown2;
	@FindBy (xpath="//button[text()='Done']/../../div[5]/ul/li[.='5']")
	private WebElement childage2;
	@FindBy (xpath="//button[text()='Done']")
	private WebElement donebtn;
	@FindBy (xpath="//button[text()='Search Hotels']")
	private WebElement searchbtn;
	@FindBy (xpath="//div[contains(text(),'Night')]")
	private WebElement nightcount;



	public  String setdata() throws AWTException

	{
		radiobtn.click(); // use to click on radio button
		wheredropdown.sendKeys("puri"+Keys.ENTER); //send data to the where dropdown field
		Loc.click();  //select city from the drop down
		checkin.click();
		checkindate.click(); 
		checkoutdate.click();
		guestandroom.click();
		String nightcounts = nightcount.getText();  // to count the nights
		addadults.click(); 
		addrooms.click();
		for(int i=0;i<2;i++)  // to select the childs
		{
			addchilds.click();
		}
		childDropdown1.click();
		boolean check1=childDropdown1.isEnabled(); // to check the child  drop down is enabled or not
		childage1.click();  //select child age
		childDropdown2.click();
		boolean check2=childDropdown2.isEnabled();  // to check the child  drop down is enabled or not
		if(check1==true && check2==true)
		{
			Reporter.log("child dropdown is enabled and pass",true);
		}
		childage2.click(); 
		donebtn.click();
		searchbtn.click();
		return nightcounts;
	}


}


