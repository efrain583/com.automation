package com.AndroidAPIDemo.pages;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAPIDemoActionPage {
	
	AndroidDriver driver = null;
	TouchAction actionActions = null;
	
	public AndroidAPIDemoActionPage(AndroidDriver driver){
		this.driver = driver;
		actionActions = new TouchAction(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindAll ({
		@AndroidFindBy(id = "android:id/text1")
	})
	ArrayList<AndroidElement> actionList;
	
	// return an Element from the actionList to the caller
	public AndroidElement actionList(String inText){
		
		Iterator<AndroidElement> myIterator = actionList.iterator(); 
		do{
			AndroidElement myElement = myIterator.next();
			System.out.println("Action List Element : " + myElement.getText());
			if(myElement.getText().contains(inText)){
				return myElement;
			}
		}while(myIterator.hasNext());
		return (AndroidElement)null;
		
	}
	
	

}
