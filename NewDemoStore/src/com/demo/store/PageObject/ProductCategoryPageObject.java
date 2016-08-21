package com.demo.store.PageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductCategoryPageObject extends DemoStoreHomePageObject {
	
	WebDriver driver;
	ProductCategoryPageObject prodcat;
	
	public ProductCategoryPageObject(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	public void addToCart(String partialProductName) throws InterruptedException
	{
		//List<WebElement>productTitles = driver.findElements(By.className("prodtitle"));
		List<WebElement>productColumns=driver.findElements(By.className("productcol"));
		
		for(WebElement productColumn:productColumns)
		{
			//WebElement productColumn=driver.findElement(By.className("productcol"));
			
			//boolean flag= productColumn.findElement(By.partialLinkText(partialProductName)).isDisplayed();
			String ttl=productColumn.findElement(By.className("prodtitle")).getText();
			
			if(ttl.equals(partialProductName))
			{
				Thread.sleep(3000);
				productColumn.findElement(By.className("wpsc_buy_button")).click();
			}
		}
		
		Thread.sleep(4500);
		driver.findElement(By.className("continue_shopping")).click();

//		List<WebElement> allbuttons=driver.findElements(By.className("wpsc_buy_button"));
//		allbuttons.get(index).click();
//		Thread.sleep(5000);
//		driver.findElement(By.className("continue_shopping")).click();
		
	}
	
	public CheckoutCartPageObject goToCart()
	{
		driver.findElement(By.id("header_cart")).click();
		return (new CheckoutCartPageObject(driver));
	}
	
	
/*	
	public CheckoutCartPageObject addToCartWithCheckout(int index) throws InterruptedException
	{
		List<WebElement> allbuttons=driver.findElements(By.className("wpsc_buy_button"));
		allbuttons.get(index).click();
		Thread.sleep(5000);
		driver.findElement(By.className("go_to_checkout")).click();
		return (new CheckoutCartPageObject(driver));
	}
*/	
}

//sd