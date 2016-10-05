package com.mubeen.screencast;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpSuccessPage {
	
	//Thank you for creating a Screencast.com account!
	private static WebDriver driver;
	
	public SignUpSuccessPage(WebDriver driver){
		this.driver = driver;
	}
	
	public static Boolean isSuccessMsgPresent(){
		String htmlSource = driver.findElement(By.tagName("body")).getText();
		Boolean result = htmlSource.contains("Thank you for creating a Screencast.com account!");
		return result;
	}
	

}
