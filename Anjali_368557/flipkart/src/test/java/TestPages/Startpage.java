package TestPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverBase;
import general.allfunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import org.testng.Assert;

public class Startpage extends DriverBase {

	// page factory design
	

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement lan_english;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Kannada']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement lan_kannada;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Telugu']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement lan_telgu;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tamil']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement lan_tamil;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Hindi']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement lan_hindi;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.flipkart.android:id/select_btn']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement lan_continue;
	


	

	// page factory initialization
	/*
	 * public HomePage() {
	 * PageFactory.initElements(new AppiumFieldDecorator(driver), this); }
	 */
}

