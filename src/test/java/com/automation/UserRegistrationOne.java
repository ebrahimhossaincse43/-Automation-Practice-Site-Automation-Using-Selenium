package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UserRegistrationOne extends DriverSetup{

	public static String baseURL = "http://automationpractice.com/index.php";
		
	@Test
	public static void registration() throws InterruptedException {
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[contains(@class,'header_user_info')]")).click();
		driver.findElement(By.xpath("//input[contains(@id,'email_create')]")).sendKeys("samplegmail10@gmail.com");
		driver.findElement(By.xpath("//button[contains(@id,'SubmitCreate')]")).click();
		Thread.sleep(5000);
		
		WebElement radio1 = driver.findElement(By.id("id_gender1"));
		radio1.click();	
		
		driver.findElement(By.xpath("//input[contains(@id,'customer_firstname')]")).sendKeys("Oluwarotimi");
		driver.findElement(By.xpath("//input[contains(@id,'customer_lastname')]")).sendKeys("Adesina");
		driver.findElement(By.xpath("//input[contains(@id,'passwd')]")).sendKeys("123456789");
				
		driver.findElement(By.xpath("//label[contains(normalize-space(),'Date of Birth')]")).click();
		
		WebElement days = driver.findElement(By.id("days"));  
		Select selectDay = new Select(days);  
		selectDay.selectByIndex(5);
		Thread.sleep(2000);
		
		WebElement months = driver.findElement(By.id("months"));  
		Select selectMonth = new Select(months);  
		selectMonth.selectByIndex(5);
		Thread.sleep(2000);
		
		WebElement years = driver.findElement(By.id("years"));  
		Select selectYear = new Select(years);  
		selectYear.selectByIndex(5);
		Thread.sleep(2000);
		
		WebElement option1 = driver.findElement(By.id("newsletter"));								
        option1.click();
        
        WebElement option2 = driver.findElement(By.id("optin"));								
        option2.click();
        Thread.sleep(2000);
        
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Oluwarotimi");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Adesina");
		driver.findElement(By.xpath("//input[contains(@name,'company')]")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[contains(@id,'address1')]")).sendKeys("House-35, Road-10");
		driver.findElement(By.xpath("//input[contains(@id,'address2')]")).sendKeys("Dhanmondi");
		driver.findElement(By.xpath("//input[contains(@id,'city')]")).sendKeys("Dhaka");
		
		WebElement states = driver.findElement(By.id("id_state"));  
		Select selectState = new Select(states);  
		selectState.selectByIndex(5);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[contains(@id,'postcode')]")).sendKeys("00001");
		driver.findElement(By.xpath("//textarea[@name='other']")).sendKeys("Additional information");
	
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("01111111");
		driver.findElement(By.xpath("//input[contains(@id,'phone_mobile')]")).sendKeys("01711111111");
		driver.findElement(By.xpath("//input[contains(@id,'alias')]")).sendKeys("Assign an address");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@id,'submitAccount')]")).click();
		
		Thread.sleep(5000);
		
		String actualName = "Nevine Acotanza";
		String username =driver.findElement(By.xpath("//a[contains(@class,'account')]")).getText();
		
		if (username.equalsIgnoreCase(actualName)) {
			System.out.println(username+" Name is Validate");
		}
		
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?mylogout']")).click();
		Thread.sleep(2000);
		
	}
	
}
