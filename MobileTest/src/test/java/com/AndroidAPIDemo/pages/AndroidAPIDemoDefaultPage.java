package com.AndroidAPIDemo.pages;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAPIDemoDefaultPage {

	AndroidDriver driver;
	
	public AndroidAPIDemoDefaultPage(AndroidDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindAll({
		@AndroidFindBy(id = "android:id/title")
	})
	private ArrayList<AndroidElement>  defaultElementList;
	
	@AndroidFindBy(id = "android:id/button2")
	private AndroidElement cancelButton;
	
	@AndroidFindBy(id = "android:id/edit")
	public AndroidElement editDefaultAnimal;
	
	@AndroidFindBy(id = "android:id/button1")
	public AndroidElement OKButton;
	
	public void printDefaultList(){
		System.out.println("Printing Default List : ");
		for(int i = 0; i < defaultElementList.size(); i++){
			System.out.println("Default Element no : " + i + " : " + defaultElementList.get(i).getText());
		}
	}
	
	public AndroidElement defaultList(String inText){
		
		for(AndroidElement myElement: defaultElementList){
			if (myElement.getText().equals(inText))
				return myElement;
		}
		return (AndroidElement) null;
		
	}

	public AndroidElement cancelButton(){
		return cancelButton;
	}
}
