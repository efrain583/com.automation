package com.AndroidAPIDemo.pages;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAPIDemoDisplayOptionsPage {
	
	AndroidDriver driver = null;
	TouchAction displayOptionsActions = null;
	
	public AndroidAPIDemoDisplayOptionsPage(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		displayOptionsActions = new TouchAction(driver);
	}
	
	@AndroidFindBy(id ="com.touchboarder.android.api.demos:id/toggle_navigation")
	AndroidElement toggleNavegation;
	
	public void toggleNavegation() throws InterruptedException{
		
		// longPress() can be used to take a look at the navigation options page but it does not activate it.
		displayOptionsActions.longPress(toggleNavegation).perform();
		Thread.sleep(2000);
		// To activate the navigation page use tap().
		displayOptionsActions.tap(toggleNavegation).perform();
		}
}
