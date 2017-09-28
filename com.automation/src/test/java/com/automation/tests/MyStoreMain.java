package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.pages.MyStoreMainPage;
import com.automation.util.UtilKit;

public class MyStoreMain extends MyStoreBase {
	

	@Test(enabled = true, dataProvider= "signInDataProvider")
	public void testSignIn(String email, String passwd){
		
		MyStoreMainPage MSMP = new MyStoreMainPage(driver);
		MSMP.signInLink().click();
		
		Assert.assertTrue(MSMP.verifyLoginPage(), "Unable to navegate to login Page ... ");
		
		MSMP.emailTextBox().sendKeys(email);
		MSMP.passwdTextBox().sendKeys(passwd);
		MSMP.submitLoginButtom().click();
		
		System.out.println("Title : " + driver.getTitle());
		Assert.assertTrue(MSMP.verifyWelcomeMessage(), "Unabled to Login ");
		
		MSMP.signOutLink().click(); // For now until delete cookies work in IE
		
	}
		
	@Test(enabled = true, dataProvider = "existingRegisterDataProvider")
	public void testExistingRegister(String email, String firstName, String lastName, String createPasswd,
								String dateDays, String dateMonths, String dateYears,
								String address1, String city, String state, String postCode,
								String country, String homePhone, String alias){
		
		MyStoreMainPage MSMP = new MyStoreMainPage(driver);
		MSMP.signInLink().click();
		
		Assert.assertTrue(MSMP.verifyLoginPage(), "Unable to navegate to login Page... ");
		
		MSMP.createEmailTextBox().sendKeys(email);
		MSMP.createSubmitButtom().click();
		
		Assert.assertTrue(MSMP.verifyExistingMessge(), "Unabled to Verify new User exists ... ");
	}
		
	@Test(enabled = true, dataProvider = "registerDataProvider")
	public void testRegister(String email, String firstName, String lastName, String createPasswd,
								String dateDays, String dateMonths, String dateYears,
								String address1, String city, String state, String postCode,
								String country, String homePhone, String alias){
		
		MyStoreMainPage MSMP = new MyStoreMainPage(driver);
		MSMP.signInLink().click();
		
		Assert.assertTrue(MSMP.verifyLoginPage(), "Unable to navegate to login Page... ");
		
		MSMP.createEmailTextBox().sendKeys(email);
		MSMP.createSubmitButtom().click();
		
		Assert.assertTrue(MSMP.verifyRegisterPage(), "Unabled to Activate Register Form ... ");
		
		// Enter the Registering Info.
		MSMP.genderId1RadioButtom().click();
		
		Assert.assertTrue(MSMP.verifyMrGender(), "Unable to Verify Mr. gender... ");
		
		MSMP.firstNameTextBox().sendKeys(firstName);
		MSMP.lastnameTextBox().sendKeys(lastName);
		MSMP.createPasswdTextBox().sendKeys(createPasswd);

		MSMP.dateDaysSelect(dateDays);
		MSMP.dateMonthsSelect(dateMonths);
		MSMP.dateYearsSelect(dateYears);

		MSMP.newsLetterCheckBox().click();
		MSMP.specialOffersCheckBox().click();
		
		
		MSMP.addrFirstNTextBox().clear();
		MSMP.addrFirstNTextBox().sendKeys(firstName);
		MSMP.addrLastNTextBox().clear();
		MSMP.addrLastNTextBox().sendKeys(lastName);
		MSMP.address1TextBox().sendKeys(address1);
		MSMP.cityTextBox().sendKeys(city);
		MSMP.stateSelect(state);
		MSMP.postcodeTextBox().sendKeys(postCode);
		MSMP.countrySelect(country);
		MSMP.homePhoneTextBox().sendKeys(homePhone);
		MSMP.aliasTextBox().clear();
		MSMP.aliasTextBox().sendKeys(alias);
		MSMP.registerSubmitButtom().click();


		System.out.println("Title : " + driver.getTitle());
		
	}

	@Test(enabled = true, dataProvider = "abortRegisterDataProvider")
	public void testAbortRegister(String email, String firstName, String lastName, String createPasswd,
								String dateDays, String dateMonths, String dateYears,
								String address1, String city, String state, String postCode,
								String country, String homePhone, String alias){
		
		MyStoreMainPage MSMP = new MyStoreMainPage(driver);
		MSMP.signInLink().click();
		
		Assert.assertTrue(MSMP.verifyLoginPage(), "Unable to navegate to login Page... ");
		
		MSMP.createEmailTextBox().sendKeys(email);
		MSMP.createSubmitButtom().click();
		
		Assert.assertTrue(MSMP.verifyRegisterPage(), "Unabled to Activate Register Form ... ");
		
		// Enter the Registering Info.
		MSMP.genderId1RadioButtom().click();
		
		Assert.assertTrue(MSMP.verifyMrGender(), "Unable to Verify Mr. gender... ");
		
		MSMP.firstNameTextBox().sendKeys(firstName);
		MSMP.lastnameTextBox().sendKeys(lastName);
		MSMP.createPasswdTextBox().sendKeys(createPasswd);

		MSMP.dateDaysSelect(dateDays);
		MSMP.dateMonthsSelect(dateMonths);
		MSMP.dateYearsSelect(dateYears);

		MSMP.newsLetterCheckBox().click();
		MSMP.specialOffersCheckBox().click();
		
		
		MSMP.addrFirstNTextBox().clear();
		MSMP.addrFirstNTextBox().sendKeys(firstName);
		MSMP.addrLastNTextBox().clear();
		MSMP.addrLastNTextBox().sendKeys(lastName);
		MSMP.address1TextBox().sendKeys(address1);
		MSMP.cityTextBox().sendKeys(city);
		MSMP.stateSelect(state);
		MSMP.postcodeTextBox().sendKeys(postCode);
		MSMP.countrySelect(country);
		MSMP.homePhoneTextBox().sendKeys(homePhone);
		MSMP.aliasTextBox().clear();
		MSMP.aliasTextBox().sendKeys(alias);
		
	}
	@DataProvider
	public Object [][] signInDataProvider(){
		return UtilKit.getTestData("TestStore", "Store", "signIn");
		
	}
	@DataProvider
	public Object [][] registerDataProvider(){
		return UtilKit.getTestData("TestStore", "Store", "register");
		
	}
	@DataProvider
	public Object [][] abortRegisterDataProvider(){
		return UtilKit.getTestData("TestStore", "Store", "abortRegister");
	}
		
	@DataProvider
	public Object [][] existingRegisterDataProvider(){
		return UtilKit.getTestData("TestStore", "Store", "existingRegister");
	}

}
