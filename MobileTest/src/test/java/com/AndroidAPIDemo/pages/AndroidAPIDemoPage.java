package com.AndroidAPIDemo.pages;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidAPIDemoPage {
	
	AndroidDriver driver;
	
	public AndroidAPIDemoPage(AndroidDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindAll({
		@AndroidFindBy(className="android.widget.TextView")
	})
		ArrayList<AndroidElement> DemoOptionsList;

	public void clickOnDemoLink(String inText) {
		
		System.out.println("List Size is " + DemoOptionsList.size());
		for(AndroidElement myElement : DemoOptionsList){
			if(myElement.getText().contains(inText)){
				myElement.click();
				return;
			}
		}
		
	}

}
