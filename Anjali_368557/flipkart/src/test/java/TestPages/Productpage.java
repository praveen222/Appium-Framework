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

public class Productpage extends DriverBase {

	// page factory design
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@bounds='[0,336][540,1070]")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement book1984;
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Apple iPhone 11 (White, 128 GB)']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement iphone;
	
	@CacheLookup
	@AndroidFindBy(id = "com.flipkart.android:id/title_action_bar")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement order_summary;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement book_add_to_cart;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SKIP & GO TO CART']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement book_skipandgocart;
	
	@CacheLookup
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement place_order;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@text='CONTINUE']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement place_order_continue;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@text='Cash on Delivery']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement place_order_COD;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.View[@text='Net Banking']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement place_order_netbanking;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Select Bank']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement select_bank;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Payments']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement payments;
	
	


}
