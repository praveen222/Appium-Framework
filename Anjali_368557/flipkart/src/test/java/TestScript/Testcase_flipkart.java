package TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import general.allfunctions;
import TestBase.DriverBase;
import TestPages.HomePage;
import TestPages.LoginPage;
import TestPages.Cartpage;
import TestPageScenario.Homepagescenario;
import TestPageScenario.Loginpage_scenario;
import TestPageScenario.ProductPage_scenario;
import TestPageScenario.Startpage_scenario;
import TestPageScenario.cartpagescenario;
import general.allfunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Testcase_flipkart extends DriverBase{

	
	@Test(enabled=true)
	public void login_Negative_TC() throws InterruptedException, IOException {
		Loginpage_scenario ls=new Loginpage_scenario(driver);
		// to test negative login test cases
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Login negative test started");
		ls.login_negativeTC();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	
	@Test(enabled=true)
	public void login_skip_Tc() throws InterruptedException, IOException {
		Loginpage_scenario ls=new Loginpage_scenario(driver);
		// to test skip login test cases
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Login skip test started");
		ls.skip_login();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(enabled=true)
	public void login_success_Tc() throws InterruptedException, IOException {
		Loginpage_scenario ls=new Loginpage_scenario(driver);
		// to test positive login test cases
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Login test started");
		ls.login_successTc();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(enabled=true)
	public void Homepage_cartnavigate_TC() throws InterruptedException {
		//to test navigation of cart page from home page
		Homepagescenario hs =new Homepagescenario(driver);
		System.out.println("checking cart page navigation from home page");
		hs.clickcart();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(enabled=true)
	public void Product_search_TC() throws InterruptedException, IOException {
		
		
		//Test to search for any product from home page and validate whether the searched content exist in source
		Homepagescenario hs =new Homepagescenario(driver);
		System.out.println("Product search started");
		hs.productsearch();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	

	@Test(enabled=true)
	public void order_product() throws InterruptedException, IOException {
		
		
		//Test to search for any product from home page and validate whether the searched content exist in source
		ProductPage_scenario ord =new ProductPage_scenario(driver);
		System.out.println("Product order TC started");
		ord.order_product();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	


}
