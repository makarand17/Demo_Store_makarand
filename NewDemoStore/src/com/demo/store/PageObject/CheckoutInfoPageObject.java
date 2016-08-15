package com.demo.store.PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckoutInfoPageObject {
	WebDriver driver;
	
	public CheckoutInfoPageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void calculateShipping(String countryValue, String state) throws InterruptedException
	{
		Thread.sleep(3000);
		Select country_dropdown1=new Select(driver.findElement(By.name("country")));
		country_dropdown1.selectByValue(countryValue);
		driver.findElement(By.xpath("//*[@id='change_country']/input[2]")).sendKeys(state);
		driver.findElement(By.name("wpsc_submit_zipcode")).click();
	}
	
	public void enterEmail(String emailid)
	{
		driver.findElement(By.id("wpsc_checkout_form_9")).sendKeys(emailid);;
	}
	public void billingDetails(String fName,String lName,String addr,String city,String und_state, String pinCode, String phone) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.id("wpsc_checkout_form_2")).sendKeys(fName);
		driver.findElement(By.id("wpsc_checkout_form_3")).sendKeys(lName);
		driver.findElement(By.id("wpsc_checkout_form_4")).sendKeys(addr);
		driver.findElement(By.id("wpsc_checkout_form_5")).sendKeys(city);
		driver.findElement(By.id("wpsc_checkout_form_6")).sendKeys(und_state);
		Select country_dropdown2=new Select(driver.findElement(By.id("wpsc_checkout_form_7")));
		country_dropdown2.selectByValue("IN");
		driver.findElement(By.id("wpsc_checkout_form_8")).sendKeys(pinCode);
		driver.findElement(By.id("wpsc_checkout_form_18")).sendKeys(phone);
		if(!driver.findElement(By.id("shippingSameBilling")).isSelected())
		driver.findElement(By.id("shippingSameBilling")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='wpsc_shopping_cart_container']/form/div[4]/div/div/span/input")).click();
		
	}

}
