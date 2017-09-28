package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.MyStoreMainPage;
import com.automation.pages.MyStoreOrderingPage;
import com.automation.util.UtilKit;

public class MyStoreOrdering extends MyStoreBase {
	

	@Test(enabled = true, dataProvider = "byIndexDataProvider", invocationCount = 1)
	public void orderSummerDressByIndex(String index){

		MyStoreMainPage MSMP = new MyStoreMainPage(driver);
		MyStoreOrderingPage MSOP = new MyStoreOrderingPage(driver);

		MSMP.defaultSignIn();
		Assert.assertTrue(MSMP.verifyWelcomeMessage(), "Unabled to Login ");
		
		try {
			/*
			 * Strange and weird
			 * On IE Selenium click() is not working for the woman link Element.
			 * To get around it javaScript was used to click on this element
			 */
			//MSOP.womenLink().click();
			UtilKit.javaScriptClick(driver, MSOP.womenLink());
			UtilKit.suspendAction(2000); // needed this here

			MSOP.dressesImage().click();
			MSOP.summerDressesImage().click();
			UtilKit.suspendAction(1000); // needed this here
			//MSOP.addToCartByIndex(Integer.parseInt(index)).click(); 
			MSOP.addToCartByIndex(2).click(); // Add to Cart the item in the first column
			MSOP.proceedToCheckOutButtom().click(); // At the Dialog Window proceed to check out
			MSOP.proceedToCheckOutButtom2().click(); // Do it again on the next page
			MSOP.proceedToCheckOutButtom3().click(); // Do it again on the address confirmation page
			MSOP.termsCheckBox().click(); // Check the terms of service agreement box
			MSOP.proceedToCheckOutButtom4().click(); // Do it again on the Delivery Carrier confirmation page  
			MSOP.payByWireLink().click();
			MSOP.confirmOrderButtonL().click();
			
			Assert.assertTrue(MSOP.confirmOrderCompletion(), "Order was not confirmed");
		} catch (Exception e) {

			UtilKit.exceptionLogger(e);
			MSMP.signOutLink().click();
		}

		UtilKit.suspendAction(1000);// so we can see
		MSMP.signOutLink().click();
		UtilKit.suspendAction(1000);// so we can see
		
	}

	@Test(enabled = true, dataProvider= "byPriceDataProvider")
	public void orderSummerDressByPrice(String price){

		MyStoreMainPage MSMP = new MyStoreMainPage(driver);
		MyStoreOrderingPage MSOP = new MyStoreOrderingPage(driver);

		MSMP.defaultSignIn();
		Assert.assertTrue(MSMP.verifyWelcomeMessage(), "Unabled to Login ");
		
		try {
			/*
			 * Strange and weird
			 * On IE Selenium click() is not working for the woman link Element.
			 * To get around it javaScript was used to click on this element
			 */
			//MSOP.womenLink().click();
			UtilKit.javaScriptClick(driver, MSOP.womenLink());
			UtilKit.suspendAction(2000);

			MSOP.dressesImage().click();
			MSOP.summerDressesImage().click();
			UtilKit.suspendAction(1000);
			MSOP.addToCartByPrice(price).click(); // Add to Cart the item in the first column
			MSOP.proceedToCheckOutButtom().click(); // At the Dialog Window proceed to check out
			MSOP.proceedToCheckOutButtom2().click(); // Do it again on the next page
			MSOP.proceedToCheckOutButtom3().click(); // Do it again on the address confirmation page
			MSOP.termsCheckBox().click(); // Check the terms of service agreement box
			MSOP.proceedToCheckOutButtom4().click(); // Do it again on the Delivery Carrier confirmation page  
			MSOP.payByWireLink().click();
			MSOP.confirmOrderButtonL().click();
			
			Assert.assertTrue(MSOP.confirmOrderCompletion(), "Order was not confirmed");
		} catch (Exception e) {
			UtilKit.exceptionLogger(e);
			MSMP.signOutLink().click();
		}

		UtilKit.suspendAction(1000);// so we can see
		MSMP.signOutLink().click();
		UtilKit.suspendAction(1000);// so we can see
		
	}
	
	@Test(enabled = true, dataProvider = "byNameDataProvider")
	public void orderSummerDressByName(String name){

		MyStoreMainPage MSMP = new MyStoreMainPage(driver);
		MyStoreOrderingPage MSOP = new MyStoreOrderingPage(driver);

		MSMP.defaultSignIn();
		Assert.assertTrue(MSMP.verifyWelcomeMessage(), "Unabled to Login ");
		
		try {
			/*
			 * Strange and weird
			 * On IE Selenium click() is not working for the woman link Element.
			 * To get around it javaScript was used to click on this element
			 */
			//MSOP.womenLink().click();
			UtilKit.javaScriptClick(driver, MSOP.womenLink());
			UtilKit.suspendAction(2000);

			MSOP.dressesImage().click();
			MSOP.summerDressesImage().click();
			UtilKit.suspendAction(1000);
			MSOP.addToCartByName(name).click(); // Add to Cart the item with the given name
			//MSOP.addToCartByName("summer").click();
			// Add to Cart the item with the given name
			MSOP.proceedToCheckOutButtom().click(); // At the Dialog Window proceed to check out
			MSOP.proceedToCheckOutButtom2().click(); // Do it again on the next page
			MSOP.proceedToCheckOutButtom3().click(); // Do it again on the address confirmation  page
			MSOP.termsCheckBox().click(); // Check the terms of service  agreement box
			MSOP.proceedToCheckOutButtom4().click(); // Do it again on the Delivery Carrier confirmation page
			MSOP.payByWireLink().click();
			MSOP.confirmOrderButtonL().click();

			Assert.assertTrue(MSOP.confirmOrderCompletion(), "Order was not confirmed");
		} catch (Exception e) {
			UtilKit.exceptionLogger(e);
			MSMP.signOutLink().click();
		}

		UtilKit.suspendAction(1000);// so we can see
		MSMP.signOutLink().click();
		UtilKit.suspendAction(1000);// so we can see
		
	}
	@DataProvider
	public Object[][] byIndexDataProvider(){
		return UtilKit.getTestData("TestStore", "store", "byIndex");
		
	}
	@DataProvider
	public Object[][] byNameDataProvider(){
		return UtilKit.getTestData("TestStore", "store", "byName");
		
	}	
	@DataProvider
	public Object[][] byPriceDataProvider(){
		return UtilKit.getTestData("TestStore", "store", "byPrice");
		
	}	
}
