package com.automation.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.automation.util.UtilKit;


public class MyStoreMainPage {

	WebDriver driver;

	public MyStoreMainPage(WebDriver driver){
		this.driver = driver;
	}

	/* Page Elements list */
	 private By signInLinkL = UtilKit.UIMap("SIGNIN_LINK");
	 
	 private By emailTextBoxL = UtilKit.UIMap("EMAIL_TEXTBOX");
	 private By passwdTextBoxL = UtilKit.UIMap("PASSWD_TEXTBOX");
	 private By submitLoginButtomL = UtilKit.UIMap("SUBMITLOGIN_BUTTOM");
	 private By signOutLinkL = UtilKit.UIMap("SIGNOUT_LINK");
	 
	 
	 private By createEmailTextBoxL = UtilKit.UIMap("CREATEEMAIL_TEXTBOX");
	 private By createSubmitButtomL = UtilKit.UIMap("CREATESUBMIT_BUTTOM");
	 private By submitAccountButtomL = UtilKit.UIMap("SUBMITACCOUNT_BUTTOM");
	 private By genderId1RadioButtomL = UtilKit.UIMap("GENDER_ID1_RADIOBUTTOM");
	 private By genderId2RadioButtomL = UtilKit.UIMap("GENDER_ID2_RADIOBUTTOM");
	 private By firstNameTextBoxL = UtilKit.UIMap("FIRSTNAME_TEXTBOX");
	 private By lastnameTextBoxL = UtilKit.UIMap("LASTNAME_TEXTBOX");
	 private By createPasswdTextBoxL = UtilKit.UIMap("PASSWD_TEXTBOX");
	 private By dateDaysSelectL = UtilKit.UIMap("DATEDAYS_SELECT");
	 private By dateMonthsSelectL = UtilKit.UIMap("DATEMONTHS_SELECT");
	 private By dateYearsSelectL = UtilKit.UIMap("DATEYEARS_SELECT");
	 private By newsLetterCheckBoxL = UtilKit.UIMap("NEWSLETTER_CHECKBOX");
	 private By specialOffersCheckBoxL = UtilKit.UIMap("SPECIALOFFERS_CHECKBOX");
	 private By addrFirstNTextBoxL = UtilKit.UIMap("ADDRFIRSTN_TEXTBOX");
	 private By addrLastNTextBoxL = UtilKit.UIMap("ADDRLASTN_TEXTBOX");
	 private By companyTextBoxL = UtilKit.UIMap("COMPANY_TEXTBOX");
	 private By address1TextBoxL = UtilKit.UIMap("ADDRESS1_TEXTBOX");
	 private By address2TextBoxL = UtilKit.UIMap("ADDRESS2_TEXTBOX");
	 private By cityTextBoxL = UtilKit.UIMap("CITY_TEXTBOX");
	 private By stateSelectL = UtilKit.UIMap("STATE_SELECT");
	 private By postcodeTextBoxL = UtilKit.UIMap("POSTCODE_TEXTBOX");
	 private By countrySelectL = UtilKit.UIMap("COUNTRY_SELECT");
	 private By addInfoTextBoxL = UtilKit.UIMap("ADDINFO_TEXTBOX");
	 private By homePhoneTextBoxL = UtilKit.UIMap("HOMEPHONE_TEXTBOX");
	 private By mobilePhoneTextBoxL = UtilKit.UIMap("MOBILEPHONE_TEXTBOX");
	 private By aliasTextBoxL = UtilKit.UIMap("ALIAS_TEXTBOX");
	 private By registerSubmitButtomL = UtilKit.UIMap("REGISTERSUBMIT_BUTTOM");
	 private By createAcccountErrorTextboxL = UtilKit.UIMap("CREATEACCCOUNTERROR_TEXTBOX");
	 
	 public WebElement createAcccountErrorTextbox(){
		 
		 UtilKit.waitForElement(createAcccountErrorTextboxL, driver, "Displayed", 3); // Wait for max of 3 secs to ensure the error is displayed.
		 return driver.findElement(createAcccountErrorTextboxL);
	 }
			 
	public WebElement emailTextBox(){
		UtilKit.scrollToElement((driver.findElement(emailTextBoxL)),driver);
		return driver.findElement(emailTextBoxL);
	}
	public WebElement passwdTextBox(){
		return driver.findElement(passwdTextBoxL);
	}
	public WebElement submitLoginButtom(){
		return driver.findElement(submitLoginButtomL);
	}
	
	
	 public WebElement signInLink(){
		 return driver.findElement(signInLinkL);
		 
	 }
	 public WebElement signOutLink(){
		 UtilKit.waitForElement(signOutLinkL, driver, "Displayed", 5);
		 return driver.findElement(signOutLinkL);
		 
	 }
	 public WebElement createEmailTextBox(){
		 UtilKit.waitForElement(createEmailTextBoxL, driver, "Displayed", 5);
		 UtilKit.scrollToElement(driver.findElement(createEmailTextBoxL), driver);
		 return driver.findElement(createEmailTextBoxL);
	 }
	 
	 public WebElement createSubmitButtom(){
		 return driver.findElement(createSubmitButtomL);
	 }
	 
	 public WebElement genderId1RadioButtom(){
		 return driver.findElement(genderId1RadioButtomL);
	 }
	 
	 public WebElement firstNameTextBox(){
		 return driver.findElement(firstNameTextBoxL);
	 }

	 public WebElement genderId2RadioButtom(){
		 return driver.findElement(genderId2RadioButtomL);
	 }
	 
	 public WebElement lastnameTextBox(){
		 return driver.findElement(lastnameTextBoxL);
	 }
	 
	 public WebElement createPasswdTextBox() {
		 return driver.findElement(createPasswdTextBoxL);
	 }

	 public void dateDaysSelect(String days){
		 Select mySelect = new Select(driver.findElement(dateDaysSelectL));
		 mySelect.selectByValue(days);
	 }
	 public void dateMonthsSelect(String months){
		 Select mySelect = new Select(driver.findElement(dateMonthsSelectL));
		 mySelect.selectByVisibleText(months + " "); // the Month is displayed with a padded space 
	 }
	 public void dateYearsSelect(String years){
		 Select mySelect = new Select(driver.findElement(dateYearsSelectL));
		 mySelect.selectByValue(years);
	 }

	 public WebElement newsLetterCheckBox() {
		 return driver.findElement(newsLetterCheckBoxL);
	 }
	 
	 public WebElement specialOffersCheckBox(){
		 return driver.findElement(specialOffersCheckBoxL);
	 }
	 
	 public WebElement addrFirstNTextBox(){
		 return driver.findElement(addrFirstNTextBoxL);
	 }
	 
	 public WebElement addrLastNTextBox(){
		 return driver.findElement(addrLastNTextBoxL);
	 }
	 
	 public WebElement companyTextBox(){
		 return driver.findElement(companyTextBoxL);
	 }

	 public WebElement address1TextBox(){
		 return driver.findElement(address1TextBoxL);
	 }

	 public WebElement address2TextBox(){
		 return driver.findElement(address2TextBoxL);
	 }
	 public WebElement cityTextBox(){
		 return driver.findElement(cityTextBoxL);
	 }

	 public void stateSelect(String inState){
		 Select mySelect = new Select(driver.findElement(stateSelectL));
		 mySelect.selectByVisibleText(inState);
	 }
	 
	 public WebElement postcodeTextBox(){
		 return driver.findElement(postcodeTextBoxL);
	 }
	 
	 public void countrySelect(String inCountry){
		 
		 Select MySelect = new Select(driver.findElement(countrySelectL));
		 MySelect.selectByVisibleText(inCountry);
	 }
	 
	 public WebElement addInfoTextBox(){
		 return driver.findElement(addInfoTextBoxL);
	 }
	 
	 public WebElement homePhoneTextBox(){
		 return driver.findElement(homePhoneTextBoxL);
	 }
	 
	 public WebElement mobilePhoneTextBox(){
		 return driver.findElement(mobilePhoneTextBoxL);
	 }
	 
	 public WebElement aliasTextBox(){
		 return driver.findElement(aliasTextBoxL);
	 }
	 
	 public WebElement registerSubmitButtom(){
		 return driver.findElement(registerSubmitButtomL);
	 }
	 
	 public boolean  verifyWelcomeMessage(){

		 WebDriverWait titleWait = new WebDriverWait(driver, 10);
		 return titleWait.until(ExpectedConditions.titleContains("My account - My Store"));
	 }

	 public boolean  verifyLoginPage(){

		// WebDriverWait titleWait = new WebDriverWait(driver, 10);
		 // return titleWait.until(ExpectedConditions.titleContains("Login - My Store"));
		return UtilKit.waitForPageToLoad(driver, 10);

	 }

	 public boolean verifyRegisterPage(){
		 ArrayList<WebElement> myElements = (ArrayList<WebElement>)driver.findElements(submitAccountButtomL);
		 if(myElements.isEmpty()) 
			 return false;
		 else
			 return true;
	 }
	 
	 /*
	  * return True If the Mr. Gender only is selected 
	  */
	 public boolean verifyMrGender(){
		if ((driver.findElement(genderId1RadioButtomL).isSelected())
				&& 
			!(driver.findElement(genderId2RadioButtomL).isSelected())){
			return true;
		}
		else
			return false;
	 }

	 /*
	  * return True If the Mrs. Gender only is selected 
	  */
	 public boolean verifyMrsGender(){
		if ((driver.findElement(genderId2RadioButtomL).isSelected())
				&& 
			!(driver.findElement(genderId1RadioButtomL).isSelected())){
			return true;
		}
		else
			return false;
	 }
	 
	 public void defaultSignIn(){
			
			signInLink().click();
			
			UtilKit.suspendAction(1000);
			Assert.assertTrue(verifyLoginPage(), "Unable to navegate to login Page");

			UtilKit.waitForElement(emailTextBox(), "Displayed", 5);
			emailTextBox().sendKeys("efrain583@yahoo.com");
			passwdTextBox().sendKeys("Eframy12");
			submitLoginButtom().click();
	 }

	public boolean verifyExistingMessge() {
		
		return createAcccountErrorTextbox().getText().contains("An account using this email address has already been registered");
	}		
	
}
