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

public class AndroidAPIDemoFromCodePage {
	
	AndroidDriver driver;
	TouchAction myActions;

	public AndroidAPIDemoFromCodePage(AndroidDriver driver){
		this.driver = driver;
		myActions = new TouchAction(driver);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id ="android:id/checkbox")
		AndroidElement checkBoxPreference;
	
	@AndroidFindBy(id ="android:id/switchWidget")
		AndroidElement switchPreference;
	
	@AndroidFindBy(id="android:id/button2")
		AndroidElement cancelButton;
	
	@AndroidFindBy(id="android:id/button1")
		AndroidElement OKButton;

	@AndroidFindAll({
		@AndroidFindBy(id="android:id/title")
		})
	ArrayList<WebElement> demoFromList;
	
	@AndroidFindAll({
		@AndroidFindBy(className="android.widget.CheckedTextView")
		})
	ArrayList<AndroidElement> checkedList;

	@AndroidFindBy(id="android:id/edit")
		AndroidElement editField;
	
	public AndroidElement editField(){
		return editField;
	}

	public AndroidElement cancelButton(){
		return cancelButton;
	}
	public AndroidElement OKButton(){
		return OKButton;
	}
	
	public AndroidElement checkBoxPreference(){
		return checkBoxPreference;
	}
	public void tapOnCheckBoxPreference(){
		myActions.tap(checkBoxPreference).perform();
	}
	public void longPressOnCheckBoxPreference(){
		myActions.tap(checkBoxPreference).perform();
	}
	public void tapOnSwitchPreference(){
		myActions.tap(switchPreference).perform();
	}
	public void longPressOnSwithBoxPreference(){
		myActions.tap(switchPreference).perform();
	}
	
	public void printFromCodeTitleList(){
		for(WebElement myElement : demoFromList){
			System.out.println("Demo from list element : " + myElement.getText());
			}
	}

	public void clickFromCode(String inText){
		for(WebElement myElement : demoFromList){
			System.out.println("Current element in the list : " + myElement.getText());
			if(myElement.getText().contains(inText)){
				myElement.click();
				return;
			}
		}
			System.out.println("Warning : " + "No Element found matching text : " + inText);
	}

	public void clickFromCodeCheck(String inText){
		for(AndroidElement myElement : checkedList){
			System.out.println("Current element in the checked list : " + myElement.getText());
			if(myElement.getText().contains(inText)){
				myElement.click();
				return;
			}
		}
			System.out.println("Warning : " + "No Element found matching text : " + inText);
	}
	
	public AndroidElement fromCodeScrollToSumary(String inText){
		/* 
		 * Scroll down to the first Element with text matching the given text in inText argument
		 */
		// Build the Android IU Script that performs the scroll
		String UIAScript = new String("new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).scrollIntoView(new UiSelector().text(\"" + inText + "\"));");
			
		System.out.println("Scroll To Script :" + UIAScript );
		
		return AppKit.androidScrollTo(driver, UIAScript); 
		
	}
	
	public void fromCodeTextSwipe(String inText){
		//AppKit.swipeText(driver, demoFromList, inText, 879, 409,10, "UP"); //The generates Invalid Coordinates exception
		AppKit.swipeText(driver, demoFromList, inText, 3, "UP");
	}
	
	public void menuTextTouchswipeUp(String movingText, String targetText){
		AppKit.textTouchswipe(movingText, targetText, demoFromList, myActions);
		}
	
}
