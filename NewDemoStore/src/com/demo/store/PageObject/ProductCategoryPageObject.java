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
	
	public void addToCart(int index) throws InterruptedException
	{
		List<WebElement> allbuttons=driver.findElements(By.className("wpsc_buy_button"));
		allbuttons.get(index).click();
		Thread.sleep(5000);
		driver.findElement(By.className("continue_shopping")).click();
		
		//driver.findElement(By.className("go_to_checkout")).click();
	}
	

	public CheckoutCartPageObject addToCartWithCheckout(int index) throws InterruptedException
	{
		List<WebElement> allbuttons=driver.findElements(By.className("wpsc_buy_button"));
		allbuttons.get(index).click();
		Thread.sleep(5000);
		driver.findElement(By.className("go_to_checkout")).click();
		return (new CheckoutCartPageObject(driver));
	}
	
}

//sd