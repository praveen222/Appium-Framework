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

public class HomePage extends DriverBase {

	// page factory design
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[166,357][339,521]']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement offerzone;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Flipkart home\"]")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement flipkartplus;

	@CacheLookup
	@AndroidFindBy(id = "com.flipkart.android:id/search_widget_textbox")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement searchproduct_input;
	
	@CacheLookup
	@AndroidFindBy(id = "com.flipkart.android:id/search_autoCompleteTextView")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement searchproduct_input_auto;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[0,357][173,521]']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement allcategories;
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[332,357][505,521]']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement Grocery;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[498,357][671,521]']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement mobiles;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[664,357][837,521]']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement Fashion;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@bounds='[830,357][1003,521]']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement Electronics;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.flipkart.android:id/cart_bg_icon']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement cart;
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.flipkart.android:id/in_app_notification_bell']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement bellicon;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Drawer\"]")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement drawer;

	@CacheLookup
	@AndroidFindBy(xpath = "android.widget.TextView[@text='Shop']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement shop;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SuperCoin']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement supercoin;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@bounds='[498,1689][582,1773]']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement exploremore;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement video;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Credit']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement credit;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='in Smart Assistants']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement google_mini_hm;
	@CacheLookup
	@AndroidFindBy(xpath = "android.widget.RelativeLayout[1]")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement relevant_search;

	
	
			
	

	// page factory initialization
	/*
	 * public HomePage() {
	 * PageFactory.initElements(new AppiumFieldDecorator(driver), this); }
	 */
}

