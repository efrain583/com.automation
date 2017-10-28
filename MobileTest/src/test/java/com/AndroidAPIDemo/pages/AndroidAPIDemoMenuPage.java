package com.AndroidAPIDemo.pages;

import java.util.ArrayList;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.AndroidAPIDemo.util.AppKit;

public class AndroidAPIDemoMenuPage {
	AndroidDriver driver = (AndroidDriver)null;
	TouchAction myActions = null;
	MultiTouchAction myMulti = null;

	
	// The constructor will take the driver as a parameter and initialize this driver with it.
	
	public AndroidAPIDemoMenuPage(AndroidDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		myActions = new TouchAction(driver);
		myMulti = new MultiTouchAction(driver);

	}
	
	@AndroidFindAll({
		@AndroidFindBy(id="android:id/text1")
	})
	ArrayList<AndroidElement> menuElementsList;
	
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Content\")")
	AndroidElement contentElement;
	
	@AndroidFindBy(className="android.widget.ImageButton")
			AndroidElement exitImageButton;
	
	//To have the list of all Elements in the page Try this outside the scope of page Factory
	//ArrayList<AndroidElement> menuList2 = new ArrayList<AndroidElement>(); <=== NO WORKING
	ArrayList<String> menuList2 = new ArrayList<String>(); // <== To Make the test case work store only the text 
	
	public void printMenuList2(){
		
		int addCount = 0;
		ArrayList<WebElement> interinList = new ArrayList<WebElement>();

		while (true){
			addCount = 0;
			System.out.println("Initial menuList2 List size : " + menuList2.size());
			interinList = (ArrayList<WebElement>) driver.findElementsById("android:id/text1");
			System.out.println("Initial Interin List size : " + interinList.size());
			
			for(int i = 0; i < interinList.size(); i++){
				AndroidElement myElement = new AndroidElement();
				myElement = (AndroidElement) interinList.get(i);
				boolean foundFlag = false;
				for(String elementText : menuList2 ){
					if(elementText.equals(myElement.getText())){
						System.out.println("Element : " + myElement.getText() + " found in menuList2 as :" + elementText);
						foundFlag = true;
						break;
					}
				}
				if(foundFlag == false){
						//if(menuList2.add(myElement)){
						//if(menuList2.add(myElement)){
						boolean addVal = menuList2.add(myElement.getText());
						System.out.println("add boolean value :" + addVal);
						if(addVal == true){
							addCount++;
							System.out.println("Element : " + myElement.getText() + " Added in menuList2"  + " Size : " +  menuList2.size());
						}
					
				}
				
//				if(menuList2.contains(myElement)){
//					System.out.println("Element : " + myElement.getText() + " found in menuList2");
//				}
//				else {
//						if(menuList2.add(myElement)){
//							addCount++;
//							System.out.println("Element : " + myElement.getText() + " Added in menuList2");
//						}
//				}
			}
			
			System.out.println("Before Swipe menuList2 size :" + menuList2.size());
			for(String elementText : menuList2){
				System.out.println(" Before Swipe MenuList2 Element : " + elementText);
			}

			if(addCount > 0){
				// Swipe up
				AndroidElement topElement = (AndroidElement) interinList.get(0);
				AndroidElement bottomElement = (AndroidElement) interinList.get(interinList.size() -1);
				System.out.println("top Element : " + topElement.getText() + " Bottom Element : " + bottomElement.getText());
				AppKit.textTouchswipe(bottomElement.getText(), topElement.getText(), interinList, myActions);
				interinList.clear();
				continue;
			}
			for(String elementText : menuList2){
				System.out.println(" Final MenuList2 Element : " + elementText);
			}
			break;
		}
	}

	public AndroidElement contentElement(){
		return contentElement;
	}
	
	public int printMenuList(){
		int i =1;
		System.out.println("\nPrinting Menu List : ");
		for (AndroidElement menuElement: menuElementsList){
			System.out.println("Menu Demo Element " + i + " Value : " + menuElement.getText());
			i++;
		}
		return i;
	}
	
	public AndroidElement menuElementsList(String matchingText){
		
		for (AndroidElement menuElement: menuElementsList){
			if( menuElement.getText().contains(matchingText)) {
				return menuElement;
			}
		}
		// TODO raise an exception here instead of returning a NULL value
		return (AndroidElement)null;
		
	}
	
	public void menuElementZoom(String matchingText) throws InterruptedException{
		
		for (AndroidElement menuElement: menuElementsList){
			if( menuElement.getText().contains(matchingText)) {
				//driver.zoom(menuElement);
				Point position = menuElement.getLocation();
				Dimension elementDimension = menuElement.getSize();
				
				System.out.println(menuElement.getText() + " Location : " + position.x + " , " + position.y );
				System.out.println(menuElement.getText() + " Height : " + elementDimension.height  + " Width : " + elementDimension.width);
				
				int centerXcoordinate = position.getX() + (elementDimension.width /2);
				int centerYcoordinate = position.getY() + (elementDimension.height /2);
				
				System.out.println("Element Center : " + centerXcoordinate + " , " + centerYcoordinate);

				driver.zoom(centerXcoordinate, centerYcoordinate); 
				Thread.sleep(5000);
				driver.pinch(centerXcoordinate, centerYcoordinate);
				Thread.sleep(5000);
	
				System.out.println("ZOOM Called");
				return; 
			}
		}
		
	}
	// Swipe to the the element matching the fromText to the location matching the toText
	public void menuElementSwipe(String fromText, String toText) throws InterruptedException{
		
		for (AndroidElement menuElement : menuElementsList) {
			if (menuElement.getText().contains(fromText)) {
				Point fromPoint = menuElement.getLocation();
				Dimension fromDimension = menuElement.getSize();

				System.out.println(menuElement.getText() + " Location : " + fromPoint.x + " , " + fromPoint.y);
				System.out.println(menuElement.getText() + " Height : " + fromDimension.height + " Width : "
						+ fromDimension.width);

				int fromCenterXcoordinate = fromPoint.getX() + (fromDimension.width / 2);
				int fromCenterYcoordinate = fromPoint.getY() + (fromDimension.height / 2);

				System.out.println("From Element Center : " + fromCenterXcoordinate + " , " + fromCenterYcoordinate);

				for (int i = 0; i < menuElementsList.size(); i++) {
					if (menuElementsList.get(i).getText().contains(toText)) {

						AndroidElement menuElement2 = menuElementsList.get(i);

						Point toPoint = menuElement2.getLocation();

						System.out.println(menuElement2.getText() + " Location : " + toPoint.x + " , " + toPoint.y);

						// Calculate the center coordinates of the target.  
						// Notice that it needs the Dimension(width and height) of the from Element.
						int toCenterXcoordinate = toPoint.getX() + (fromDimension.width / 2);
						int toCenterYcoordinate = toPoint.getY() + (fromDimension.height / 2);

						System.out.println("To Element Center : " + toCenterXcoordinate + " , " + toCenterYcoordinate);

						// use TouchActions to perform a swipe
						//myActions.longPress(fromCenterXcoordinate, fromCenterYcoordinate).moveTo(toCenterXcoordinate, toCenterYcoordinate).release().perform();
						
						// User driver to perform a swipe
						driver.swipe(fromCenterXcoordinate, fromCenterYcoordinate, toCenterXcoordinate, toCenterYcoordinate, 5000);

						Thread.sleep(5000);

					}
				}

				return;
			}
		}
	}
		

	public AndroidElement menuScrollTo(String inText){
		/* 
		 * Scroll down to the first Element with text matching the given text in inText argument
		 */
		// Build the Android IU Script that performs the scroll
		String UIAScript = new String("new UiScrollable(new UiSelector().className(\"android.widget.ListView\")).scrollIntoView(new UiSelector().text(\"" + inText + "\"));");
			
		System.out.println("Scroll To Script :" + UIAScript );
		
		return AppKit.androidScrollTo(driver, UIAScript); 
		
	}
	
	public AndroidElement exitImageButton(){
		return exitImageButton;
	}

}
