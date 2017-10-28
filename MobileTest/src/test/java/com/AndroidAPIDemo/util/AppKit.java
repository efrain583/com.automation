package com.AndroidAPIDemo.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppKit {
	
	private static String projectFolder = "/Users/efrain/git/";
	private static String projectName = null;
	private static String application = null;
	private static String className = null;
	private static long startTime = (long)0;
	private static long endTime = (long)0;
	public static Logger logger = null;
	
	
	public static AndroidDriver initAndroidTest(String project, String inApplication, String inClassName) {

	DesiredCapabilities cap = new DesiredCapabilities();

	application = inApplication;
	className = inClassName;
	File myFile = new File(projectFolder +"appiumTest/appiumTest/andriodApps/com.touchboarder.android.api.demos-13.apk");
	
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
	cap.setCapability(MobileCapabilityType.APP,myFile.getAbsolutePath() );
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "30");
	
	System.out.println(".apk File : " + myFile.getAbsolutePath());
	System.out.println("Starting Test for " + project  + "." + inApplication +  "."  + inClassName);

	try {
		return (new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap));
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return (AndroidDriver)null;
	}
		
	}

	public static AndroidElement androidScrollTo(AndroidDriver driver, String UIAScript){
		/* 
		 * Scroll down to the first Element Android UI script
		 */
		System.out.println("Scroll To Script :" + UIAScript );
		
		AndroidElement scrollToElement = (AndroidElement) driver.findElementByAndroidUIAutomator(UIAScript); 
		return scrollToElement;
		
	}

	public static void terminateAndriodTest(AndroidDriver driver) {
		driver.manage().deleteAllCookies();
		driver.closeApp(); // Close App
		driver.quit(); // End Session Safely
	}
	public static void initAndroidMethod(String testMethodName) {

		startTime = System.currentTimeMillis();
		if (logger == null) {
			logger = Logger.getLogger(application + "." + testMethodName);
			PropertyConfigurator.configure(projectFolder + projectName  + "/properties/log4j.properties");
			Logger.getRootLogger().setLevel(Level.DEBUG);
		}	
		logger.info("Test Method : " + className + ":" + testMethodName + " Started at " + getDateTime());

		/* Adjust the log Level here if needed, The default is INFO
		 * Levels (FATAL, ERROR, WARN, INFO, DEBUG)
		 */
		Logger.getRootLogger().setLevel(Level.DEBUG); // Debug level
	}
	
	// ITestResult is a Testng Object This class describes the result of a test.
		public static void terminateAndriodMethod(AndroidDriver driver, ITestResult result) {

			endTime = System.currentTimeMillis();

			/*
			 * If there is a need to take a look at the results then un-comment this
			 * block Set<String> atNames = result.getAttributeNames(); for (String
			 * namestr : atNames) { System.out.println("Result Attribute : " +
			 * namestr); }
			 */

			logger.info("Test Method : " + className + "."+ result.getMethod().getMethodName() + " Completed at : " + getDateTime()
					+ " Elapsed Time in Seconds : " + (float) (endTime - startTime) / 1000 + "  Success Status = "
					+ result.isSuccess() + "\n\n");

			// Print current screen if the test case was not successful
			if (!result.isSuccess()) {
				printScreen(driver, result.getMethod().getMethodName());

			}

		}

	
	public static String getDateTime() {
		SimpleDateFormat dateTimeForm = new SimpleDateFormat("MM/dd/YYYY HH:mm:ss");
		Date myDateTime = Calendar.getInstance().getTime();

		return (dateTimeForm.format(myDateTime));
	}

	public static String getPlainDateTime() {
		SimpleDateFormat dateTimeForm = new SimpleDateFormat("YYYYMMddHHmmss");
		Date myDateTime = Calendar.getInstance().getTime();

		return (dateTimeForm.format(myDateTime));
	}

	// Take the Screen Shot and capture in a file
	static public void printScreen(WebDriver driver, String methodName) {
		try {
			String destFileName = projectFolder + projectName + "/screenPrints/" + methodName + "_" + getPlainDateTime()
					+ ".png";
			File destFile = new File(destFileName);

			System.out.println("File Name : " + destFileName);
			destFile.createNewFile();

			/*
			 * Since Driver Classes like FirefoxDriver and
			 * InternetExplorerDriver implement WebDriver and TakesScreenshot
			 * interfaces, then we can cast the driver object as a
			 * TakesScreenshot object to be able to invoke getScreenshotiAs().
			 */

			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Copy the screen shot the the destination file
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void swipeText(AndroidDriver driver, ArrayList<WebElement> preferenceElementList, String text, int seconds, String direction ){
		
			for( int i =0; i < preferenceElementList.size(); i++){
				AndroidElement myElement = (AndroidElement) preferenceElementList.get(i);
				if(myElement.getText().contains(text)){
					if(direction.equals("UP"))
						myElement.swipe(SwipeElementDirection.UP, seconds * 1000);
					if(direction.equals("DOWN"))
						myElement.swipe(SwipeElementDirection.DOWN, seconds * 1000);
				}
			}
	}
	public static void swipeText(AndroidDriver driver, ArrayList<AndroidElement> elements, String text, int startPos, int endPos, int seconds, String direction ){
		
			for( int i =0; i < elements.size(); i++){
				AndroidElement myElement = elements.get(i);
				if(myElement.getText().contains(text)){
					if(direction.equals("UP"))
						myElement.swipe(SwipeElementDirection.UP, seconds * 1000);
					//myElement.swipe(direction, offsetFromStartBorder, offsetFromEndBorder, duration);
					if(direction.equals("DOWN"))
						myElement.swipe(SwipeElementDirection.DOWN, seconds * 1000);
				}
			}
	}
	public static void textTouchswipe(String movingText, String targetText, ArrayList<WebElement> elementsList, TouchAction myActions){
		Point targetCoordinates = null;
		for(WebElement myElement : elementsList){
			System.out.println("Element : " + myElement.getText() + " Coordinates : " + myElement.getLocation().x + " , " + myElement.getLocation().y);
			if(myElement.getText().contains(targetText)){
				targetCoordinates = myElement.getLocation();
				break;
			}	
		}
		for(WebElement myElement : elementsList){
				//myActions.moveTo(myElement, 48, 349).perform();
			if(myElement.getText().contains(movingText)){
				System.out.println("Moving " + movingText + " to : " + targetCoordinates.x  + " , " + targetCoordinates.y);
				//The generates Invalid Coordinates exception
				myActions.longPress(myElement).moveTo(targetCoordinates.x, targetCoordinates.y).release().perform();
				System.out.println(movingText + " was moved to top ....");
				return;
			}
		}
	}

	public static void navegateBackToPage(String pageTitle, AndroidDriver driver) throws InterruptedException {
		
		while(true){
			if(driver.findElementsById("com.touchboarder.android.api.demos:id/action_bar").size() == 1) {
				AndroidElement actionBar = (AndroidElement) driver.findElementById("com.touchboarder.android.api.demos:id/action_bar");
				AndroidElement textWidget = (AndroidElement) actionBar.findElementByClassName("android.widget.TextView");
				if(textWidget.getText().contains(pageTitle)){
					System.out.println(pageTitle + " REACHED, Backwards Navegation Stoped");
					return;
				}
			}	

			driver.navigate().back();
			Thread.sleep(2000);
		}
		
	}
}
