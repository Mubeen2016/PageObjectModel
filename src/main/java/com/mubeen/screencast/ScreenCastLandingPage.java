package com.mubeen.screencast;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;



public class ScreenCastLandingPage {
	
	private static WebDriver driver;
	
	public ScreenCastLandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public static void go(){
		driver.get("http://www.screencast.com/");
	}
	//ScreenCastLandingPage.email("abc123@gmail.com")
	public static void email(String email){
		driver.findElement(By.cssSelector("input[name='email'][id='email']")).clear();
	    driver.findElement(By.cssSelector("input[name='email'][id='email']")).sendKeys(email);
	}
	
	public static void password(String pwd){
		driver.findElement(By.cssSelector("input[name='password'][id='password1']")).clear();
		driver.findElement(By.cssSelector("input[name='password'][id='password1']")).sendKeys(pwd);
	}
	
	public static void verifypassword(String vpwd){
		driver.findElement(By.cssSelector("input[type='password'][id='password2']")).clear();
		driver.findElement(By.cssSelector("input[type='password'][id='password2']")).sendKeys(vpwd);
	}
	public static void displayname(String disname){
		driver.findElement(By.cssSelector("input[name='displayName'][id='displayName']")).clear();
		driver.findElement(By.cssSelector("input[name='displayName'][id='displayName']")).sendKeys(disname);
	}

	public  static  void selectDropDownCountry(String CountryValue){
		WebElement mySelectElm = driver.findElement(By.id("countrySelect")); 
		new Select(mySelectElm).selectByValue(CountryValue);
	}
   
   
	public static void signup(){
		driver.findElement(By.cssSelector("input[id='signUpButton']")).click();
	}
//    driver.findElement(By.cssSelector("a[id='signInButton']")).click();
//    

}
