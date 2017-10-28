package com.AndroidAPIDemo.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAPIDemoScreenPage {
	
	AndroidDriver driver;
	
	public AndroidAPIDemoScreenPage(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id ="android:id/checkbox")
		AndroidElement screenCheckBox;
	

	public AndroidElement screenCheckBox(){
		return screenCheckBox;
	}

}
