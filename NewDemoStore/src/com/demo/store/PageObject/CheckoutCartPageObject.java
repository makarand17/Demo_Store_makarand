package com.demo.store.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutCartPageObject {
	WebDriver driver;
	static int quantity;
	static String productName;
	static WebElement eachRow;
	static List<WebElement> all_Columns;
	public CheckoutCartPageObject(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
	}
	 

	//To update quantity of the product 
/*	
	public void updateOrder(int tr, int quantity)
	{
		CheckoutCartPageObject.quantity=quantity;
		CheckoutCartPageObject.tr=tr;
		String st=driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[2]")).getText(); 
		System.out.println("The table data is "+st);		
		//update quantity
		driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[3]/form/input[1]")).clear();
		driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[3]/form/input[1]")).sendKeys(Integer.toString(quantity));
		//click on update button
		driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[3]/form/input[4]")).click();
	}
	*/
	
	
	
//	-------------------------------------------------------------------------
	
	public void updateOrder(String productName, int quantity)
	{
		CheckoutCartPageObject.quantity=quantity;
		CheckoutCartPageObject.productName=productName;
		WebElement table=driver.findElement(By.className("checkout_cart"));
		
		List <WebElement> allRows=table.findElements(By.tagName("tr"));  //all rows
		for(WebElement eachRow:allRows)
		{
			List<WebElement> all_Columns=eachRow.findElements(By.tagName("td"));
			if(all_Columns.size()>0)
			{
				  
			  	WebElement ProductName=all_Columns.get(1);
			  
				String pName=ProductName.findElement(By.tagName("a")).getText();
				System.out.println("title of product---->"+pName);
				if(productName.contains(pName))
				{									
					WebElement updateTextBox=all_Columns.get(2).findElement(By.name("quantity"));
					updateTextBox.clear();
					updateTextBox.sendKeys(Integer.toString(quantity));  		
					WebElement updateButton=all_Columns.get(2).findElement(By.name("submit"));
					updateButton.click();
					break;
				}
			}
			
		}
	}
	
	//To verify the updated quantity and total
	public void verifyUpdate(int tr) throws NumberFormatException
	{
		System.out.println("quantity in verify function is: "+quantity);
	//	String price=driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[4]/span")).getText();
	//	String total=driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[5]/span/span")).getText();

		WebElement table=driver.findElement(By.className("checkout_cart"));
		List <WebElement> allRows=table.findElements(By.tagName("tr"));  //all rows
		for(WebElement eachRow:allRows)
		{
			List<WebElement> all_Columns=eachRow.findElements(By.tagName("td"));
			if(all_Columns.size()>0)
			{
			  for(WebElement eachCol:all_Columns)
			    {
				  
				  	WebElement col_price=all_Columns.get(3);
				  	String price=col_price.getText();
				  	WebElement col_total=all_Columns.get(4);
				  	String total=col_total.getText();
					total=total.substring(1);
					price=price.substring(1);
					
					System.out.println("Value of Total in string is :---->"+total);
					 try{
					  float total_int=Float.parseFloat(total);
					  float price_int=Float.parseFloat(price);
					  System.out.println("Value of Total in float is :==>"+total_int);
					  Assert.assertEquals(total_int, (price_int*quantity));
					  }catch(NumberFormatException e1)
					   {
				 		  System.out.println("This is num format exception: "+e1);
			 		   }
			    }
			}
		}
		
		
		

	 }
	
//To remove product from cart	
	public void removeProduct(int tr, String productName)
	{
		//driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[6]/form/input[4]")).click();
		
		WebElement table=driver.findElement(By.className("checkout_cart"));
		List <WebElement> allRows=table.findElements(By.tagName("tr"));  //all rows
		for(WebElement eachRow:allRows)
		{
			List<WebElement> all_Columns=eachRow.findElements(By.tagName("td"));
			if(all_Columns.size()>0)
			{
				
				WebElement ProductName=all_Columns.get(1);
				String pName=ProductName.findElement(By.tagName("a")).getText();
				System.out.println("title of product---->"+pName);
				if(productName.contains(pName))
				{									
				  	WebElement removeButton=all_Columns.get(5);
				  	removeButton.click();
					break;
				}

			}
		}
	}
	
	public CheckoutInfoPageObject goToCheckout()
	{
		driver.findElement(By.className("step2")).click();
		return (new CheckoutInfoPageObject(driver));
	}
	
	public void removeItemFromCart(String itemName){
		
	}

}
