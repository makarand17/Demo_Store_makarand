package com.demo.store.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		//driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://store.demoqa.com");
		home=new DemoStoreHomePageObject(driver);
	}
	
	@Test
	public void goToCategories() throws InterruptedException, NumberFormatException
	{	
		prodcatobj = home.productCategory("Accessories");
		prodcatobj.addToCart("Apple TV");
		
		home.productCategory("iMacs");
		prodcatobj.addToCart("Magic Mouse");
		

		home.productCategory("iPads");
		prodcatobj.addToCart("Apple iPad 6");
		
		home.productCategory("iPhones");
		prodcatobj.addToCart("Apple iPhone 4S");
		
		checkoutCartObj=prodcatobj.goToCart();
		
		//Pass the index number of the product from cart to remove the product
		checkoutCartObj.removeProduct(2);
		checkoutCartObj.removeItemFromCart("Magic Mouse");
		
		//Pass the index number of the product from cart and quantity to update
		checkoutCartObj.updateOrder(2, 3);
		
		//This verifies the above update and total
		checkoutCartObj.verifyUpdate();
		
		checkoutInfoObj=checkoutCartObj.goToCheckout();
		checkoutInfoObj.calculateShipping("IN", "Maharashtra");
		
		checkoutInfoObj.enterEmail("abc@test.com");
		checkoutInfoObj.billingDetails("ajay", "D", "Juhu", "mumbai", "maharashtra", "410000", "1234567890");
		
		
	}
	
	
}
