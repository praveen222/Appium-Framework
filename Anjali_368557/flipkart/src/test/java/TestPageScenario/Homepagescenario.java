package TestPageScenario;

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
import TestBase.DriverBase;
import TestPages.HomePage;
import TestPages.Cartpage;
import general.allfunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Homepagescenario extends DriverBase {
	
	protected Logger log = Logger.getLogger(HomePage.class.getName());// + ":" + nameofCurrMethod);
	public HomePage hp = new HomePage();
	public Cartpage ct=new Cartpage();
	public LoginPage lp =new LoginPage();
	protected allfunctions keys = new allfunctions(driver);
    public Startpage_scenario st= new Startpage_scenario(driver);
	public Properties obj;
	public FileInputStream objfile;
	public String searchcontent, productname;
	WebDriverWait wait;
	
	public Homepagescenario(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), hp);
		PageFactory.initElements(new AppiumFieldDecorator(driver), ct);
		PageFactory.initElements(new AppiumFieldDecorator(driver), lp);
		log.info(getClass());
		log.info("Homepage elements initialized");
	}
	
	public void clickcart() throws InterruptedException {
		//skiplogin
		Startpage_scenario spa=new Startpage_scenario(driver);
		wait = new WebDriverWait(driver, 10);
		System.out.println("Language select for flipkart");
		spa.selectenglish();
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.close_login)));

		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(hp.cart)));
		System.out.println("clicked on cart");
		if(wait.until(ExpectedConditions.visibilityOf(ct.mycart_title)).isDisplayed()) {
			log.info("navigated to cart page from home");
			System.out.println("navigated to cart page from home");
		}
	}
	public void productsearch() throws InterruptedException, IOException {
		//skiplogin
		Startpage_scenario spa=new Startpage_scenario(driver);
		wait = new WebDriverWait(driver, 10);
		System.out.println("Language select for flipkart");
		spa.selectenglish();
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.close_login)));
		
		obj = new Properties();
		log.info(getClass());
		System.out.println(System.getProperty("user.dir"));
		objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
		obj.load(objfile);
		
		productname=obj.getProperty("product_name");
		System.out.println(productname);
		searchcontent=obj.getProperty("search_content");
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(hp.searchproduct_input)));
        
		keys.clearandsend(hp.searchproduct_input_auto,searchcontent);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		WebElement elem;
	    elem=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]"));
		elem.click();
		//validate content is displayed in page
		keys.scrollToText(searchcontent);
		if(driver.getPageSource().contains("Net Banking")) {
			log.info("found Product");
		}
		
	
	}
	
	

}
