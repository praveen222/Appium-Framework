package TestPageScenario;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverBase;
import TestPages.Cartpage;
import TestPages.HomePage;
import TestPages.LoginPage;
import general.allfunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class cartpagescenario extends DriverBase {
	protected Logger log = Logger.getLogger(LoginPage.class.getName());
	protected allfunctions keys = new allfunctions(driver);
	public HomePage hp = new HomePage();
	public Cartpage ct=new Cartpage();
	public LoginPage lp =new LoginPage();
	public Properties obj;
	public FileInputStream objfile;
	WebDriverWait wait;

	public cartpagescenario(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), ct);
		PageFactory.initElements(new AppiumFieldDecorator(driver), hp);
		PageFactory.initElements(new AppiumFieldDecorator(driver), lp);
		log.info(getClass());
		log.info("cart page elements initialized");
	}
	
	public void cartoperation() throws InterruptedException {
		//skiplogin
		Startpage_scenario spa=new Startpage_scenario(driver);
		wait = new WebDriverWait(driver, 20);
		System.out.println("Language select for flipkart");
		spa.selectenglish();
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.close_login)));

		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(hp.cart)));
		System.out.println("clicked on cart");
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(ct.mycart_title)));
	
	
}}
