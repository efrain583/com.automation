package com.AndriodAPIDemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.AndroidAPIDemo.pages.AndroidAPIDemoActionPage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoAppPage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoContentPage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoDefaultPage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoDisplayOptionsPage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoFromCodePage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoMenuPage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoNavegationOptionsPage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoPreferencePage;
import com.AndroidAPIDemo.pages.AndroidAPIDemoScreenPage;
import com.AndroidAPIDemo.util.AppKit;

public class AndroidAPIDemo extends AndroidAPIDemoBase {
	
	@Test(enabled=true)
	public void mobileGesturesTest() throws InterruptedException {
		
		// Assume we are in the API Demos Menu Page
		AndroidAPIDemoMenuPage menuPage = new AndroidAPIDemoMenuPage(driver);
		AndroidAPIDemoPreferencePage preferencePage = new AndroidAPIDemoPreferencePage(driver);
		AndroidAPIDemoFromCodePage fromCodePage = new AndroidAPIDemoFromCodePage(driver);
			
	
		// Access  The Preference Page
		menuPage.menuScrollTo("Preference").click();
		Thread.sleep(2000);
		
		// From the preference menu, do Some mobile gestures swipe, zoom, tap
		// This swipe is easy to code but it does not swipe all the way up.
		preferencePage.preferenceSwipeUp("6. Advanced preferences");
		Thread.sleep(2000);
		preferencePage.preferenceSwipeDown("6. Advanced preferences");
		Thread.sleep(2000);
		
		preferencePage.preferenceScrollTo("9. Switch");
		
		// Tried to use touch Action Tap as a substitute to click() on the Image But it didn't work
//		preferencePage.tapOnImageView();
//		System.out.println(" tapOnImageView was just Called !!!! \n ");
//		Thread.sleep(10000);

		// Tried to use Touch Action longPress as a substitute to click() on the image But it didn't work
//		preferencePage.longPressOnImageView();
//		System.out.println(" longPressOnImageView was just Called !!!! \n ");
//		Thread.sleep(10000);
//		
		
		// Since touch Actions are not working use click() to access the githup web site
		preferencePage.imageView().click();
		Thread.sleep(1000);
		preferencePage.imageTitle().click();
		Thread.sleep(10000);
		driver.navigate().back();
		Thread.sleep(10000);

		// The following touch action tap does work
		preferencePage.tapByText("5. Preferences from code"); // in this case Tap is the same as click()
		System.out.println(" tap was just Called !!!! \n ");
		Thread.sleep(10000);
		
		fromCodePage.printFromCodeTitleList();
		// Play around with the touch Actions in the formCode page
		//fromCodePage.tapOnCheckBoxPreference(); // Tap is not behaving exactly like click(). it checks the box but then it get unchecked by itself ...
		fromCodePage.checkBoxPreference().click();

		fromCodePage.tapOnSwitchPreference();

		// Test Edit Text feature
		fromCodePage.clickFromCode("Edit text preference");
		Thread.sleep(2000);
		// Don't need to cancel if we would like to continue testing this page.
		//fromCodePage.cancelButton().click();
		//Thread.sleep(5000);
		fromCodePage.editField().sendKeys("ORANGUTAN");
		fromCodePage.OKButton().click();
		
		// Test the Radio Button feature
		fromCodePage.clickFromCode("List preference");
		Thread.sleep(5000);
		//fromCodePage.cancelButton().click();
		fromCodePage.clickFromCodeCheck("Beta Option 02");
		Thread.sleep(5000);
		
		// Scroll Down to the end of the page to test the remaining features
		//fromCodePage.fromCodeScrollToSumary("Screen preference");
		
		// Test the Screen Preference feature
		fromCodePage.clickFromCode("Screen preference");
		Thread.sleep(3000);
		AndroidAPIDemoScreenPage screenPage = new AndroidAPIDemoScreenPage(driver);
		screenPage.screenCheckBox().click();
		
		// Back to Preference from Code Page
		driver.navigate().back();
		Thread.sleep(5000);
		
		// The below swipe calls are not working on this page
		//Swipe Up the "Screen Preference" option to access the rest of the page
		//fromCodePage.fromCodeTextSwipe("Screen preference");
		//Thread.sleep(3000);
		//fromCodePage.textTouchswipeUp("Screen preference", "Edit text preference");
		Thread.sleep(3000);

		fromCodePage.fromCodeScrollToSumary("Parent checkbox preference");
		Thread.sleep(3000);
		
		// Back to API Demos Menu Page
		AppKit.navegateBackToPage("API Demos", driver);

	}

	@Test (enabled=true)
	public void editText() throws InterruptedException {
		
		// Assuming you are in API Demos Menu Page to run this test case

		AndroidAPIDemoMenuPage menuPage = new AndroidAPIDemoMenuPage(driver);
		AndroidAPIDemoPreferencePage preferencePage = new AndroidAPIDemoPreferencePage(driver);
		AndroidAPIDemoDefaultPage defaultPage = new AndroidAPIDemoDefaultPage(driver);
		
		// In Menu Page Scroll Down to "Preferences" and click on it 
		System.out.println("\n\n--------------------Menu Page Before Scroll -----------------\n");
		menuPage.printMenuList();
		System.out.println("\n--------------------------------------------------------------\n");
		menuPage.menuScrollTo("Preference").click();
		System.out.println("\n--------------------Menu Page After Scroll -----------------\n");
		menuPage.printMenuList();
		System.out.println("\n--------------------------------------------------------------\n");
		
		// From Preference page Test the "default edit text" feature
		//AndroidAPIDemoPreferencePage preferencePage = new AndroidAPIDemoPreferencePage(driver);
		preferencePage.printPreferenceElement();
		
		//On Preference page click on default values
		preferencePage.clickPreferenceElement("4. Default values");
		
		// From  default Values page Print the options and click on "Edit text Preference option 
		//AndroidAPIDemoDefaultPage defaultPage = new AndroidAPIDemoDefaultPage(driver); 
		defaultPage.printDefaultList();
		defaultPage.defaultList("Edit text preference").click();
		
		// Click on cancel button for now
		//defaultPage.cancelButton().click();
		
		// Edit Default Animal text field
		defaultPage.editDefaultAnimal.clear();
		defaultPage.editDefaultAnimal.sendKeys("orangutan");
		defaultPage.OKButton.click();
		
		// Exit Default page back to preference
		driver.navigate().back();

		//On Preference page click on default values again
		preferencePage.clickPreferenceElement("4. Default values");
		
		// From  default Values page click on "Edit text Preference option 
		defaultPage.defaultList("Edit text preference").click();
		// Print the value in the edit text field to verify is the same value entered
		System.out.println("Edit text value : " + defaultPage.editDefaultAnimal.getText());
		Assert.assertEquals("orangutan", defaultPage.editDefaultAnimal.getText());

		// Exit Default page back to API menu Page
		AppKit.navegateBackToPage("API Demos", driver);
		
}

	@Test(enabled = true)
	public void checkContent() {
		
		// Assuming you are in API Demos Menu Page to run this test case

		AndroidAPIDemoMenuPage menuPage  = new AndroidAPIDemoMenuPage(driver);
		AndroidAPIDemoContentPage contentPage = new AndroidAPIDemoContentPage(driver);
		
		menuPage.contentElement().click();
		
		//AndroidAPIDemoContentPage contentPage =  new AndroidAPIDemoContentPage(driver);
		contentPage.printContentList();
		contentPage.exitImageButton().click(); // click back to main menu
	}

	@Test(enabled=true)
	public void elementSwipe() throws InterruptedException {

		// Assuming you are in API Demos Main Page to run this test case
		AndroidAPIDemoMenuPage menuPage = new AndroidAPIDemoMenuPage(driver);
		
		menuPage.menuElementSwipe("Hardware", "App"); // Will try to swipe "Hardware" up to where "App" is located
	}

	@Test(enabled=true)
	public void elementZoom() throws InterruptedException {

		// Assuming you are in API Demos Main Page to run this test case
		AndroidAPIDemoMenuPage menuPage = new AndroidAPIDemoMenuPage(driver);
		
		// test the zoom call here - 
		menuPage.menuElementZoom("App");
	}

	@Test(enabled=true)
	public void printMenuOptions() {
		
		// Assuming you are in API Demos Page to run this test case
		AndroidAPIDemoMenuPage menuPage = new AndroidAPIDemoMenuPage(driver);
		
		menuPage.printMenuList();
		menuPage.printMenuList2();
	}

	@Test(enabled=false)
		public void selectNavegation() throws InterruptedException{

		// Assuming you are in API Demos Menu Page to run this test case
		AndroidAPIDemoMenuPage menuPage = new AndroidAPIDemoMenuPage(driver);
		AndroidAPIDemoAppPage appPage = new AndroidAPIDemoAppPage(driver);
		AndroidAPIDemoActionPage actionPage = new AndroidAPIDemoActionPage(driver);
		AndroidAPIDemoDisplayOptionsPage optionsPage = new AndroidAPIDemoDisplayOptionsPage(driver);
		AndroidAPIDemoNavegationOptionsPage navegationPage = new AndroidAPIDemoNavegationOptionsPage(driver);
		

		// The following block will try to test all gestures using mostly the TouchAction methods
		//menuPage.menuElementsList("App").click();
		menuPage.menuScrollTo("App").click();
		Thread.sleep(3000);
		appPage.appOptionsList("Action Bar").click();
		Thread.sleep(3000);
		actionPage.actionList("Display Options").click();
		Thread.sleep(3000);
		optionsPage.toggleNavegation();
		Thread.sleep(3000);
		navegationPage.selectNavegation("NAVIGATION_MODE_LIST");
		Thread.sleep(3000);

		// Exit back to API menu Page
		AppKit.navegateBackToPage("API Demos", driver);
	}

}
