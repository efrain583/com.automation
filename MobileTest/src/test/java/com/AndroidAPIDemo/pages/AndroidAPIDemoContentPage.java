package com.AndroidAPIDemo.pages;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAPIDemoContentPage {
AndroidDriver driver = (AndroidDriver)null;
	
	// The constructor will take the driver as a parameter and initialize this driver with it.
	
	public AndroidAPIDemoContentPage(AndroidDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="android:id/text1")
		ArrayList<AndroidElement> contentElementsList;
	
	
	@AndroidFindBy(className="android.widget.ImageButton")
			AndroidElement exitImageButton;
	
	
	public int printContentList(){
		int i =1;
		System.out.println("\n Printing Content List");
		for (AndroidElement contentElement: contentElementsList){
			System.out.println("Content Element " + i + " Value : " + contentElement.getText());
			i++;
		}
		return i;
	}
	
	public AndroidElement contentElementsList(String matchingText){
		
		for (AndroidElement menuElement: contentElementsList){
			if( menuElement.getText().contains(matchingText)) {
				return menuElement;
			}
		}
		// TODO raise an exception here insted of returninga NULL value
		return (AndroidElement)null;
		
	}
	
	public AndroidElement exitImageButton(){
		return exitImageButton;
	}

}
