package TestPages;

import java.time.temporal.ChronoUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;

import TestBase.DriverBase;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;

public class LoginPage extends DriverBase{

	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gms:id/credentials_hint_picker_title']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement sign_up_with;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.gms:id/cancel']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement sign_up_with_noneabove;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.EditText[@accessibility id='Phone Number']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement phnumber_input;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Use Email-ID']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement use_email_id;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.flipkart.android:id/phone_input']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement email_input;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.flipkart.android:id/button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement continue_email;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.flipkart.android:id/phone_input']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement password_input;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.flipkart.android:id/button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement continue_login;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.flipkart.android:id/tv_error_message']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement invalid_login;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.gms:id/credential_save_reject']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement save_password_reject;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.flipkart.android:id/title_action_bar']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement myAccount_title;
	
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@text='Back Button']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement Myaccount_back_home;
	
	@CacheLookup
	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.flipkart.android:id/custom_back_icon']")
	@WithTimeout(time = 25, chronoUnit = ChronoUnit.SECONDS)
	public WebElement close_login;
	
	
	
}
