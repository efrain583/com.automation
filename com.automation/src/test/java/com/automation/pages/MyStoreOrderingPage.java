package com.automation.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.util.UtilKit;

public class MyStoreOrderingPage {
	
	WebDriver driver;
	
	Actions mouseActions;
	
	// a displayed product item holds the add to cart locator string and By 
	public class ProductItem {
		Float price;
		int productId;
		String productName;
		String ATClocatorString; // Add to cart Locator
		String div2LocatorString; // Div2 Locator String. 
		By ATCproductWebElementL; // Add to Cart locator
		By ATCproductWebElementCssL; // Add to Cart alternate css type locator
		
		private ProductItem(){
			price = Float.valueOf("0.00");
			productId = 0;
			productName = "";
			ATClocatorString = ""; // Add To Cart (ATC) 
			div2LocatorString = ""; // Add To Cart (ATC) 
			ATCproductWebElementL = (By)null; // Add To Cart (ATC) 
			ATCproductWebElementCssL = (By)null; // Alternate CSS Add To Cart (ATC) 
			
		}
	}
	
	// Holds the list of products displayed in the Grid
	private ArrayList<ProductItem> productList = new ArrayList<ProductItem>(); 
	
	public MyStoreOrderingPage(WebDriver driver){
		
		this.driver = driver;
		this.mouseActions = new Actions(driver);

	}
	
	By womenLinkL = UtilKit.UIMap("WOMEN_LINK");
	By dressesImageL = UtilKit.UIMap("DRESSES_IMAGE");
	By summerDressesLinkL = UtilKit.UIMap("SUMMERDRESSES_LINK");
	By summerDressesImageL = UtilKit.UIMap("SUMMERDRESSES_IMAGE");
	By productListGridL = UtilKit.UIMap("PRODUCTLIST_GRID");
	By productPriceSpanL = UtilKit.UIMap("PRODUCTPRICE_SPAN");
	By productColumnL = UtilKit.UIMap("PRODUCT_COLUMN");
	By productNameLinkL = UtilKit.UIMap("PRODUCTNAME_LINK");
	By proceedToCheckOutButtomL = UtilKit.UIMap("PROCEEDTOCHECKOUT_BUTTOM");
	By proceedToCheckOutButtom2L = UtilKit.UIMap("PROCEEDTOCHECKOUT_BUTTOM2");
	By proceedToCheckOutButtom3L = UtilKit.UIMap("PROCEEDTOCHECKOUT_BUTTOM3");
	By proceedToCheckOutButtom4L = UtilKit.UIMap("PROCEEDTOCHECKOUT_BUTTOM4");
	By termsCheckBoxL = UtilKit.UIMap("TERMS_CHECKBOX");
	By payByWireLinkL = UtilKit.UIMap("PAYBYWIRE_LINK");
	By confirmOrderButtonL = UtilKit.UIMap("CONFIRMORDER_BUTTON");
	By orderCompletionBlockL = UtilKit.UIMap("ORDERCOMPLETION_BLOCK");
	
	public boolean confirmOrderCompletion(){
		
		UtilKit.waitForElement(orderCompletionBlockL, driver, "Exists", 5);
		WebElement completionBlock = driver.findElement(orderCompletionBlockL);

		UtilKit.scrollToElement(completionBlock, driver);

		String completionBlockString = completionBlock.getText();
		
//		System.out.println("\n -- Order completion Block Text: \n" + completionBlockString + "\n --- End fo Block ---\n ");
		
		String strArray[] = completionBlockString.split("order reference");
		UtilKit.logger.info("reference String :" + strArray[1].substring(0, 10));
		
		if(completionBlockString.contains("Your order on My Store is complete."))
			return true;
		return false;


	}
	
	public WebElement confirmOrderButtonL(){
		UtilKit.waitForElement(confirmOrderButtonL, driver, "Displayed", 5);
		UtilKit.scrollToElement(driver.findElement(confirmOrderButtonL), driver);
		UtilKit.suspendAction(5);
		return driver.findElement(confirmOrderButtonL);
	}
	public WebElement payByWireLink(){
		UtilKit.waitForElement(payByWireLinkL, driver, "Displayed", 5);
		return driver.findElement(payByWireLinkL);
		
	}
	public WebElement termsCheckBox(){
		UtilKit.waitForElement(termsCheckBoxL, driver, "Displayed", 2);
		UtilKit.scrollToElement(driver.findElement(termsCheckBoxL), driver);
		return driver.findElement(termsCheckBoxL);
	}

	public WebElement productListGrid(){
		return driver.findElement(productListGridL);
	}
	
	public WebElement proceedToCheckOutButtom(){
		UtilKit.suspendAction(1000); // Since there are Various versions of this button, give it some time for it to show.
		UtilKit.waitForElement(proceedToCheckOutButtomL, driver, "Displayed", 10);
		UtilKit.scrollToElement(driver.findElement(proceedToCheckOutButtomL), driver); // Scroll here so we can see it happening
		UtilKit.suspendAction(1000);

		return driver.findElement(proceedToCheckOutButtomL);
	}
	public WebElement proceedToCheckOutButtom2(){
		UtilKit.suspendAction(1000); // Since there are Various versions of this button, give it some time for it to show.
//		System.out.println("\n\n===== Page Title =========" + driver.getTitle() + "\n");
//		System.out.println("==============\n\n" + driver.getPageSource() + "\n\n============");
		UtilKit.waitForElement(proceedToCheckOutButtom2L, driver, "Displayed", 5);
		UtilKit.scrollToElement(driver.findElement(proceedToCheckOutButtom2L), driver); // Scroll here so we can see it happening
		UtilKit.suspendAction(1000);

		return driver.findElement(proceedToCheckOutButtom2L);
	}
	
	public WebElement proceedToCheckOutButtom3(){
		UtilKit.suspendAction(1000); // Since there are Various versions of this button, give it some time for it to show.
		UtilKit.waitForElement(proceedToCheckOutButtom3L, driver, "Displayed", 5);
		UtilKit.scrollToElement(driver.findElement(proceedToCheckOutButtom3L), driver); // Scroll here so we can see it happening
		UtilKit.suspendAction(1000);

		return driver.findElement(proceedToCheckOutButtom3L);
	}
	
	public WebElement proceedToCheckOutButtom4(){
		UtilKit.suspendAction(1000); // Since there are Various versions of this button, give it some time for it to show.
		UtilKit.waitForElement(proceedToCheckOutButtom4L, driver, "Displayed", 5);
		UtilKit.scrollToElement(driver.findElement(proceedToCheckOutButtom4L), driver); // Scroll here so we can see it happening
		UtilKit.suspendAction(1000);

		return driver.findElement(proceedToCheckOutButtom4L);
	}
	
	public WebElement addToCartByIndex(int index) {

		// Scroll down to the grid so we can see what is happening
		UtilKit.waitForElement(productListGridL, driver, "Exists", 5);
		UtilKit.scrollToElement(driver.findElement(productListGridL), driver);
		UtilKit.suspendAction(2);

		this.getProductList(); // Build the list of product
		
		// Scroll to and Hover over the div[2] area so that the Add to Cart Button becomes Active
		UtilKit.waitForElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString)), "Displayed", 5);
		UtilKit.scrollToElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString)), driver);
		mouseActions.moveToElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString))).build().perform();

		UtilKit.waitForElement(productList.get(index).ATCproductWebElementL, driver, "Displayed", 10);
		UtilKit.logger.info("Item Added to Cart : "  + (String) productList.get(index).productName + " : " + productList.get(index).price + "\n");

		return(driver.findElement(productList.get(index).ATCproductWebElementL));

	}
	
	public WebElement addToCartByPrice(String price) {

		Float myPrice = Float.valueOf(price);
		int index =0;
		
		System.out.println("Selecting Price : " + myPrice);
		// Scroll down to the grid so we can see what is happening
		UtilKit.waitForElement(productListGridL, driver, "Exists", 5);
		UtilKit.scrollToElement(driver.findElement(productListGridL), driver);
		UtilKit.suspendAction(2000);

		this.getProductList();

		for (index = 0; index < productList.size(); index++) {
			if (productList.get(index).price.equals(myPrice)) {
				// Hover over the div[2] area so that the Add to Cart Button
				// becomes Active
				UtilKit.waitForElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString)), "Displayed", 5);
				UtilKit.scrollToElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString)), driver);
				mouseActions.moveToElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString))).build().perform();
				UtilKit.waitForElement(productList.get(index).ATCproductWebElementL, driver, "Displayed", 10);
				UtilKit.logger.info("Item Added to Cart : "  + (String) productList.get(index).productName + " : "
						+ productList.get(index).price + "\n");
				
				break;
			}
		}
		//System.out.println("Index : " + index);
		return (driver.findElement(productList.get(index).ATCproductWebElementL));

	}
	
	public WebElement addToCartByName(String Name) {

		int index =0;
		// Scroll down to the grid so we can see what is happening
		UtilKit.waitForElement(productListGridL, driver, "Exists", 5);
		UtilKit.scrollToElement(driver.findElement(productListGridL), driver);
		UtilKit.suspendAction(2000);

		this.getProductList();
		System.out.println("Product List size : " + productList.size());

		for (index = 0; index < productList.size(); index++) {
			if (productList.get(index).productName.toLowerCase().contains(Name.toLowerCase())) {
				// Hover over the div[2] area so that the Add to Cart Button becomes Active
				UtilKit.waitForElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString)), "Displayed", 2);
				UtilKit.scrollToElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString)), driver);
				mouseActions.moveToElement(driver.findElement(By.xpath(productList.get(index).div2LocatorString))).build().perform();
				UtilKit.suspendAction(1000);
				UtilKit.waitForElement(productList.get(index).ATCproductWebElementL, driver, "Displayed", 10);
				break;
			}
		}

		System.out.println("Index : " + index);
		UtilKit.logger.info("Item Added to Cart : "  + (String) productList.get(index).productName + " : "
				+ productList.get(index).price + "\n");
		return (driver.findElement(productList.get(index).ATCproductWebElementL));

	}
	/*
	 * This method goes into the product grid looking for the key product elements
	 * and build a list of product items
	 */
	private void getProductList(){


		ArrayList<WebElement> columnList = (ArrayList<WebElement>) driver.findElements(productColumnL);
		for (int i=0; i < columnList.size(); i++){
			
			WebElement myColumnElement = columnList.get(i);
			ProductItem myItem = new ProductItem();

			// Get the price Elements There are 2 of them but one of then is not active
			ArrayList<WebElement> priceList = (ArrayList<WebElement>) myColumnElement.findElements(productPriceSpanL);
			for (WebElement priceElement : priceList) {
				String priceText = priceElement.getText();
				if (!priceText.isEmpty()) {
					System.out.println("Item: " + i + " PRICE ELEMENT TEXT : " + priceText);
					myItem.price = Float.parseFloat(priceText.substring(1));
					System.out.println("Item: " + i + " Price : " + myItem.price);
				}
			}
			
			//Get the product name for the current column
			WebElement productNameLink  = myColumnElement.findElement(productNameLinkL);
			myItem.productName = productNameLink.getText();
			System.out.println("Item: " + i + " Product Name : " + myItem.productName);
			
			// Populate the "Add to Cart" buttom locator for this product Item
			String[] propStrings = UtilKit.parseLocator("ADDTOCART_BUTTOM_TEMPLATE");
			
			// Prepare "Add to Cart" and div2 Locator Strings
			// Replace the place holder "HOLDER" with the column Element index number 
			String[] locatorSplit = propStrings[1].split("HOLDER");
			myItem.ATClocatorString = locatorSplit[0] + String.valueOf(i+1) + locatorSplit[1];
			//System.out.println("Item: " + i + " Locator String : " + myItem.ATClocatorString);
			myItem.div2LocatorString = locatorSplit[0] + String.valueOf(i + 1) + "]/div/div[2]";
			//System.out.println("Item: " + i + " div2 Locator String : " + myItem.div2LocatorString);
			
			// Set the "Add to Cart" By Element locator object
			propStrings[1] = myItem.ATClocatorString;
			myItem.ATCproductWebElementL = UtilKit.returnBy(propStrings);

			// Set the Alternate css type "Add to Cart" By Element locator object
			myItem.ATCproductWebElementCssL = UtilKit.UIMap("ADDTOCART_BUTTOM");
			
			// Add this product item to the productList. 
			productList.add(myItem);
			
		}
	}
	
	public WebElement womenLink(){
		// Wait for the corresponding Element to be displayed
		UtilKit.waitForElement(womenLinkL, driver, "Displayed", 3);

		// Capture the Element and then hover over it
		return(driver.findElement(womenLinkL));
		
		
	}
	public WebElement dressesImage(){
		UtilKit.waitForElement(dressesImageL, driver, "Displayed", 5);
		
		// Capture the Element and hover over it
		UtilKit.scrollToElement(driver.findElement(dressesImageL), driver);
		WebElement myElement = driver.findElement(dressesImageL);
		mouseActions.moveToElement(myElement).build().perform();
		
		UtilKit.suspendAction(3000); // Wait so that we can see what's happening in the browser
		return (myElement);
		
	}
	public WebElement summerDressesImage(){
		
		// Wait for the Summer Dress Element to get displayed
		UtilKit.waitForElement(summerDressesImageL, driver, "Displayed", 5);
		
		// Capture the Element and hover over item
		WebElement myElement = driver.findElement(summerDressesImageL);
		UtilKit.scrollToElement(myElement, driver);

		mouseActions.moveToElement(myElement).build().perform();
		
		UtilKit.suspendAction(3000); // Wait so that we can see whats happening in the breowser
		return (myElement);
		
	}
	
	public WebElement summerDressesLink(){
		
		// Wait for the Summer Dress Element to get displayed
		UtilKit.waitForElement(summerDressesLinkL, driver, "Displayed", 5);
		
		// Capture the Element and hover over item
		WebElement myElement = driver.findElement(summerDressesLinkL);
		UtilKit.scrollToElement(myElement, driver);

		mouseActions.moveToElement(myElement).build().perform();
		
		UtilKit.suspendAction(3000); // Wait so that we can see whats happening in the breowser
		return (myElement);
		
	}
	public void mouseHoverOverWomenLink(){
		
		// Wait for the corresponding women Element to be displayed
		UtilKit.waitForElement(womenLinkL, driver, "Displayed", 3);

		// Capture the Element and then hover over it
		WebElement myElement = driver.findElement(womenLinkL);
		mouseActions.moveToElement(myElement).build().perform();
	}
	
	public void mouseHoverOverDressesImage(){
		
		// Wait for the corresponding Element to be displayed
		UtilKit.waitForElement(dressesImageL, driver, "Displayed", 3);

		// Capture the Element and then hover over it
		WebElement myElement = driver.findElement(dressesImageL);
		mouseActions.moveToElement(myElement).build().perform();
	}
	public void mouseHoverOverSummerDressesLink(){
		
		
		// Wait for the Summer Dress Element to get diplayed
		UtilKit.waitForElement(summerDressesLinkL, driver, "Displayed", 3);
		
		// Capture the Element and hover over it
		WebElement myElement = driver.findElement(summerDressesLinkL);
		mouseActions.moveToElement(myElement).build().perform();
		
		UtilKit.suspendAction(20000);
		mouseActions.click(myElement).build().perform();
	}
	
}
