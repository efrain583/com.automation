package com.automation.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.pages.MyStoreMainPage;
import com.automation.util.UtilKit;

public class MyStoreBase {

	WebDriver driver;
	String myBrowser = new String("firefox");

	String application = "com.automation";
	String project = application; // In this case the project is the same name
									// as the application
	String thisClassName = this.getClass().getName();

	// Optional parameter "browser", default value is "firefox"
	// This optional parameter is set in the testng.xml file
	@Parameters("browser")
	@BeforeClass
	public void startClass(@Optional("IE") String browser) {
		myBrowser = browser;
		driver = UtilKit.initTest(project, application, myBrowser, getClass().getName());
		if (myBrowser.equalsIgnoreCase("IE")) {
			System.out.println("INITIAL URL :" + driver.getCurrentUrl());
			if (!driver.getCurrentUrl().contains("authentication")) {
				// TODO This is done because IE is not clearing cookies properly
				// TODO then you need to sign out before you can sign in
				MyStoreMainPage MSMP = new MyStoreMainPage(driver);
				MSMP.signOutLink().click();
				UtilKit.waitForPageToLoad(driver, 5);
			}
		}

	}
	
	@BeforeMethod
	public void startMethod(Method method){
		UtilKit.initMethod(method.getName());
	}

	@AfterMethod
	public void stopMethod(ITestResult result) {
		UtilKit.terminateMethod(driver, result);
		UtilKit.navegateToBaseURL(driver);
	}
	
	@AfterClass
	public void stopClass(){
		UtilKit.terminateTest(driver);
	}
	
}
