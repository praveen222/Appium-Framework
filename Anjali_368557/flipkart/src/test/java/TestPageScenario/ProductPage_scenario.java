package TestPageScenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import TestPages.LoginPage;
import TestPages.Productpage;
import bsh.commands.dir;
import TestBase.DriverBase;
import TestPages.HomePage;
import TestPages.Cartpage;
import general.allfunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
public class ProductPage_scenario extends DriverBase {
	protected Logger log = Logger.getLogger(HomePage.class.getName());// + ":" + nameofCurrMethod);
	public HomePage hp = new HomePage();
	public LoginPage lp=new LoginPage();
	public Cartpage ct=new Cartpage();
	public Productpage pp =new Productpage();
	protected allfunctions keys = new allfunctions(driver);
    public Startpage_scenario st= new Startpage_scenario(driver);
    public Properties obj;
	public FileInputStream objfile;
	public String username, invalid_username, password, invalid_password, search_content,correct_password;
	WebDriverWait wait;
	public ProductPage_scenario(AppiumDriver driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), hp);
		PageFactory.initElements(new AppiumFieldDecorator(driver), ct);
		PageFactory.initElements(new AppiumFieldDecorator(driver), pp);
		PageFactory.initElements(new AppiumFieldDecorator(driver), lp);
		log.info(getClass());
		log.info("Product page elements initialized");
		
	}
	public void order_product() throws InterruptedException, IOException {
		//skiplogin
		
		
		Startpage_scenario spa=new Startpage_scenario(driver);
		wait = new WebDriverWait(driver, 10);
		System.out.println("Language select for flipkart");
		spa.selectenglish();
		if(lp.sign_up_with_noneabove.isDisplayed()) {
			keys.clickelement(lp.sign_up_with_noneabove);
			obj = new Properties();
		}
		else {
			obj = new Properties();
				
		}
		
		log.info(getClass());
		System.out.println(System.getProperty("user.dir"));
		objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
		obj.load(objfile);

		username = obj.getProperty("username");
		correct_password = obj.getProperty("correct_password");
		System.out.println(username);
		System.out.println(correct_password);
		log.info("Retreiving Username and Password from property file");
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.use_email_id)));
		log.info("Use email id for login");
		
		keys.clearandsend(lp.email_input, username);
		log.info("Typed email id successfully");
		keys.clickelement((lp.continue_email));
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.password_input)));
		keys.clearandsend(lp.password_input, correct_password);	
		log.info("Typed password successfully");
		keys.clickelement(lp.continue_login);
		
        keys.clickelement(wait.until(ExpectedConditions.visibilityOf(hp.searchproduct_input)));
        String searchcontent="iphone 11";
		keys.clearandsend(hp.searchproduct_input_auto,searchcontent);
		//driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		WebElement elem;
	    elem=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));
		elem.click();
		//validate content is displayed in page
		String searchd="Apple iPhone 11 (White, 128 GB)";
		keys.scrollToText(searchd);
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(pp.iphone)));
	    keys.clickelement(wait.until(ExpectedConditions.visibilityOf(pp.book_add_to_cart)));
	    keys.clickelement(wait.until(ExpectedConditions.visibilityOf(pp.book_skipandgocart)));
	    keys.clickelement(wait.until(ExpectedConditions.visibilityOf(pp.place_order)));
	  
	    keys.clickelement(wait.until(ExpectedConditions.visibilityOf(pp.place_order_continue)));
	    assertTrue(pp.payments.isDisplayed()) ;
		}
			
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
	
	}


