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

public class AndroidAPIDemoNavegationOptionsPage {

	AndroidDriver driver = null;
	TouchAction navegationActions = null;
	
	public AndroidAPIDemoNavegationOptionsPage(AndroidDriver driver){
		this.driver = driver;
		navegationActions = new TouchAction(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindAll ({
		@AndroidFindBy(id="android:id/text1")
	})
	ArrayList<AndroidElement> navegationOptions;
	
	public void selectNavegation(String inText){
		System.out.println("navegation Options size : "  + navegationOptions.size());
		Iterator<AndroidElement> myIterator = navegationOptions.iterator();
		while(myIterator.hasNext()){
			AndroidElement myElement = myIterator.next();
			System.out.println(" Navegation Option : " + myElement.getText());
			if(myElement.getText().contains(inText))
				// Use press() and release() to select the navigation option matching the given text.
				navegationActions.press(myElement).release().perform();

		}
	}
}

