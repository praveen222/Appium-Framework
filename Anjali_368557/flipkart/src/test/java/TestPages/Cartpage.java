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
public class Cartpage extends DriverBase {

	// page factory design
	
	

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.flipkart.android:id/title_action_bar']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement mycart_title;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Place Order']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement place_order;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue Shopping']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement continue_shopping;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Missing Cart items?']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement missing_cart_text;
	
	
}
