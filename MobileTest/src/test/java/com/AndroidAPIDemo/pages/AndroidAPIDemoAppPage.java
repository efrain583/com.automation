package com.AndroidAPIDemo.pages;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAPIDemoAppPage {
	
	AndroidDriver driver = null;
	TouchAction appActions = null;
	
	public AndroidAPIDemoAppPage(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		appActions = new TouchAction(driver);
		
	}
	
	@AndroidFindAll ({
		@AndroidFindBy(id = "android:id/text1")
	})
	ArrayList<AndroidElement> appOptionsList;
	
	public AndroidElement appOptionsList(String inText){
		for(AndroidElement myElement: appOptionsList){
			if(myElement.getText().contains(inText)){
				return myElement;
			}
		}
		return (AndroidElement)null;
	}

}
