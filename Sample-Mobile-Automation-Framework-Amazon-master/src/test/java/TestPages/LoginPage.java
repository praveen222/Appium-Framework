package TestPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverBase;
import general.KeywordFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;

public class LoginPage extends DriverBase {

	// page factory design
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.amazon.mShop.android.shopping:id/sign_in_button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement already_cust_sign;

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.amazon.mShop.android.shopping:id/skip_sign_in_button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement skip_signin;





	// page factory implementation
	/*
	 * public LoginPage() { 
	 * PageFactory.initElements(new AppiumFieldDecorator(driver), this); }
	 */

}
