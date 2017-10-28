package com.AndriodAPIDemo.tests;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.AndroidAPIDemo.pages.AndroidAPIDemoPage;
import com.AndroidAPIDemo.util.AppKit;

import io.appium.java_client.android.AndroidDriver;

public class AndroidAPIDemoBase {
	
	
	AndroidDriver driver = null;
	@BeforeClass
	public void startTest() throws InterruptedException{
		
		driver = AppKit.initAndroidTest("appiumTest", "com.touchboarder.android.api.demos-13.apk", getClass().getName());
		AndroidAPIDemoPage APIPage = new AndroidAPIDemoPage(driver);
		
		//Print the driver basic info
		System.out.println("Driver started : " + "CONTEXT : " + driver.getContext() /* +  " URL : " + driver.getCurrentUrl() + " TITLE :" +driver.getTitle()*/ );

		/* Click on this default positive just to bring on the main menu 
		 * This is common to all test cases
		*/
		ArrayList<WebElement> myList = (ArrayList<WebElement>) driver.findElements(By.id("com.touchboarder.android.api.demos:id/buttonDefaultPositive"));
		if (myList.size() == 1){
			 myList.get(0).click();
			 Thread.sleep(2000);
		}
		APIPage.clickOnDemoLink("API Demos");
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void endTest(){
		System.out.println("Test Class Execution Ended");
		driver.closeApp();
	}

	
}
