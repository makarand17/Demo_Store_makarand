package com.demo.store.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demo.store.PageObject.CheckoutCartPageObject;
import com.demo.store.PageObject.CheckoutInfoPageObject;
import com.demo.store.PageObject.DemoStoreHomePageObject;
import com.demo.store.PageObject.ProductCategoryPageObject;

public class TestNGDemoStore {
	
	private WebDriver driver;
	private ProductCategoryPageObject prodcatobj;
	public DemoStoreHomePageObject home;
	CheckoutCartPageObject checkoutCartObj;
	CheckoutInfoPageObject checkoutInfoObj;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","F://work//chromedriver//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://store.demoqa.com");
		home=new DemoStoreHomePageObject(driver);
	}
	
	@Test
	public void goToCategories() throws InterruptedException, NumberFormatException
	{	
		prodcatobj = home.productCategory();
		prodcatobj.addToCart(2);
		
		//home.clcikOnCategory("iMacs");
		//prodcatobj.addToCart(0);
		
		//home.clcikOnCategory("iPads");
		//prodcatobj.addToCart(1);
		
		home.clcikOnCategory("iPhones");
		checkoutCartObj=prodcatobj.addToCartWithCheckout(1);
		
		//Pass the index number of the product from cart and quantity to update
		checkoutCartObj.updateOrder(2, 3);
		checkoutCartObj.verifyUpdate(); //This verifies above update and total
		
		checkoutInfoObj=checkoutCartObj.goToCheckout();
		checkoutInfoObj.calculateShipping("IN", "Maharashtra");
		
		checkoutInfoObj.enterEmail("abc@test.com");
		checkoutInfoObj.billingDetails("ajay", "D", "Juhu", "mumbai", "maharashtra", "410000", "1234567890");
		
		
	}
	
	
}
//a