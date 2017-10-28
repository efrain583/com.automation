package com.AndroidAPIDemo.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AndroidAPIDemoEditText {
	
	AndroidDriver driver;
	
	public AndroidAPIDemoEditText(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@AndroidFindBy(id = "android:id/edit")
	private AndroidElement editTextElement;
	
	@AndroidFindBy(id = "android:id/button1")
	private AndroidElement OKButton;
	
	
	public AndroidElement editTextElement(){
		return editTextElement;
	}
	
	public void editSendText(String inText){
		editTextElement().sendKeys(inText);
	}
	
	public AndroidElement OKButton(){
		return OKButton;
	}
	
	public void exitEditText(){
		
		// ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		driver.navigate().back();
		
	}

}
