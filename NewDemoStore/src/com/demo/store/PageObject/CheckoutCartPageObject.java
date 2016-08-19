package com.demo.store.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckoutCartPageObject {
	WebDriver driver;
	static int quantity, tr;
	public CheckoutCartPageObject(WebDriver driver)
	{
		//super(driver);
		this.driver=driver;
	}
	 
	public CheckoutInfoPageObject goToCheckout()
	{
		driver.findElement(By.className("step2")).click();
		return (new CheckoutInfoPageObject(driver));
	}
	//To update quantity of the product 
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
	//To verify the updated quantity and total
	public void verifyUpdate() throws NumberFormatException
	{
		System.out.println("quantity in verify function is: "+quantity);
		String price=driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[4]/span")).getText();
		String total=driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[5]/span/span")).getText();
		total=total.substring(1);
		price=price.substring(1);
		 try{
		  float total_int=Float.parseFloat(total);
		  float price_int=Float.parseFloat(price);
		  Assert.assertEquals(total_int, (price_int*quantity));
		  }catch(NumberFormatException e1)
		   {
	 		  System.out.println("This is num format exception: "+e1);
 		   }
	 }
	
//To remove product from cart	
	public void removeProduct(int tr)
	{
		driver.findElement(By.xpath("//*[@id='checkout_page_container']/div[1]/table/tbody/tr["+(tr+1)+"]/td[6]/form/input[4]")).click();
	}
	
	public void removeItemFromCart(String itemName){
		
	}

	
	
	
	
	
/*	-------------------------------------------------------------------------
	public void updateOrder(int tr, int quantity)
	{
		WebElement e1=driver.findElement(By.className("checkout_cart"));
		
		List <WebElement> row_allcontent=e1.findElements(By.tagName("tr"));
		
		for(WebElement eachRow:row_allcontent)
		{
			//System.out.println("*"+eachRow.getText()+"*");
			List<WebElement> col_allcontent=e1.findElements(By.tagName("td"));
			 for(WebElement eachCol:col_allcontent)
			 {
				 System.out.println("*"+eachCol.getText()+"*");
			 }
		}
	}
	
*/
}
