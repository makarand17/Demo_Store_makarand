package com.demo.store.PageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DemoStoreHomePageObject {

	private WebDriver driver;
	private Actions ac;

//-----------Constructor------------------------------------------
	public DemoStoreHomePageObject(WebDriver driver) 
	{
		this.driver = driver;
	}
//------------------------------------------------------------------
	
	public ProductCategoryPageObject productCategory() throws InterruptedException
	{	
		clcikOnCategory("Accessories");
		return (new ProductCategoryPageObject(driver));
	}
//--------------------------------------------------------------
	public void clcikOnCategory(String categoryName) throws InterruptedException
	{
		ac = new Actions(driver);
		WebElement prodCat = driver.findElement(By.xpath("//*[@id='menu-item-33']/a"));
		ac.moveToElement(prodCat).perform();
		
		switch (categoryName) {
		case "Accessories":
			Thread.sleep(3000);
			ac.moveToElement(prodCat).perform();
			driver.findElement(By.id("menu-item-34")).click();
			break;
		case "iMacs":
			Thread.sleep(3000);
			ac.moveToElement(prodCat).perform();
			driver.findElement(By.id("menu-item-35")).click();
			break;
		case "iPads":
			Thread.sleep(3000);
			ac.moveToElement(prodCat).perform();
			driver.findElement(By.id("menu-item-36")).click();
			break;
		case "iPhones":
			Thread.sleep(4000);
			ac.moveToElement(prodCat).perform();
			driver.findElement(By.id("menu-item-37")).click();
			break;
		case "iPods":
			Thread.sleep(3000);
			ac.moveToElement(prodCat).perform();
			driver.findElement(By.id("menu-item-38")).click();
			break;
		case "MacBooks":
			Thread.sleep(3000);
			ac.moveToElement(prodCat).perform();
			driver.findElement(By.id("menu-item-39")).click();
			break;
		}
		
	}

}


//sd
//	List<WebElement> categories = driver.findElements(By.className("sub-menu"));

// for(WebElement category:categories)
// {
//
// ac.moveToElement(prodCat).perform();
// System.out.println("These are values"+category.getText());
// }


