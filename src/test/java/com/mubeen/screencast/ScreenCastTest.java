package com.mubeen.screencast;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class ScreenCastTest {
	
	private WebDriver driver;
	private ScreenCastLandingPage sclp;
	private SignUpSuccessPage susp;
	
	@Before
	public void testSignup() throws InterruptedException{
		
		String workingDir = System.getProperty("user.dir");
		String chromeDriverLocation = workingDir + "\\chromedriver_w32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverLocation);
		driver = new ChromeDriver();
		int timeOut = 3;
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS); //have to wait regarless of condition
		System.out.println("Setting implicit timeout to = " + timeOut);
		driver.manage().window().maximize();
	}
	@Test
	public void testMethods(){	
		sclp = new ScreenCastLandingPage(driver);
		susp = new SignUpSuccessPage(driver);
		sclp.go();
		
		int rn = 1000 + (int)(Math.random() * 9999); 
		sclp.email("abc"+ rn+ "@gmail.com");
		sclp.password("Secret1234");

		sclp.verifypassword("Secret1234");
		sclp.displayname("abc"+ rn);
		sclp.selectDropDownCountry("ALB");
		sclp.signup();
		
		try { 
			driver.wait(5000);
		}catch (Exception e){
			//do nothing
		}
		
		//Check if signup success page is visible
		Assert.assertTrue(susp.isSuccessMsgPresent());
	}
	@After
	public void testquitemethod(){
		driver.quit();
	}

}
