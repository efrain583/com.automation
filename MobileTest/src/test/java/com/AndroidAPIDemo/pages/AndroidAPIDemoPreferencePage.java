package com.AndroidAPIDemo.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.AndroidAPIDemo.util.AppKit;

public class AndroidAPIDemoPreferencePage {

	
	AndroidDriver driver;
	TouchAction myAndroidActions;
	
	public AndroidAPIDemoPreferencePage(AndroidDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
		myAndroidActions = new TouchAction(driver);
		

		
	}
	
	@AndroidFindBy(className="android.widget.ImageView")
		AndroidElement imageView;

	@AndroidFindBy(id="com.touchboarder.android.api.demos:id/title")
		AndroidElement imageTitle;
	
	@AndroidFindAll({
		@AndroidFindBy(id="android:id/text1")
		})
	ArrayList<WebElement> preferenceElementList;

	public AndroidElement imageView(){
		return imageView;
	}
	public AndroidElement imageTitle(){
		return imageTitle;
	}
	public void printPreferenceElement(){
		int i = 0;
		System.out.println("Printing Preference list :");
		for(WebElement myElement: preferenceElementList){
			System.out.println("Preference Element no. " + i++ + ": " + myElement.getText());
		}
	}
	
	public void clickPreferenceElement(String text){
		for(WebElement myElement: preferenceElementList){
			if(myElement.getText().equals(text)){
				myElement.click();
				break;
			}
		}
	}
	
	public void preferenceSwipeUp(String inText) {
		
		AppKit.swipeText(driver, preferenceElementList, inText, 4, "UP");
		
	}
	public void preferenceSwipeDown(String inText) {
		
		AppKit.swipeText(driver, preferenceElementList, inText, 4, "DOWN");
		
	}
	
	public void tapByText(String inText){
		for(WebElement myElement: preferenceElementList ){
			if(myElement.getText().contains(inText)){
				myAndroidActions.tap(myElement).perform(); // Is the same as click()
				break;
			}

		}
	}
	
	public void tapOnImageView(){
		myAndroidActions.tap(imageView).perform(); /// Tap is the same as click()
	}

	public void longPressOnImageView(){
		myAndroidActions.longPress(imageView).perform(); 
	}

	public AndroidElement preferenceScrollTo(String inText){
		/* 
		 * Scroll down to the first Element with text matching the given text in inText argument
		 */
		// Build the Android IU Script that performs the scroll
		String UIAScript = new String("new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).scrollIntoView(new UiSelector().text(\"" + inText + "\"));");
			
		System.out.println("Scroll To Script :" + UIAScript );
		
		return AppKit.androidScrollTo(driver, UIAScript); 
		
	}
}