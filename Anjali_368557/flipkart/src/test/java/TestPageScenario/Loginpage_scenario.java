package TestPageScenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
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

public class Loginpage_scenario extends DriverBase {
	protected Logger log = Logger.getLogger(LoginPage.class.getName());
	protected allfunctions keys = new allfunctions(driver);
	public HomePage hp=new HomePage();
	public Cartpage ct =new Cartpage();
	public LoginPage lp = new LoginPage();
	public Properties obj;
	public FileInputStream objfile;
	public String username, invalid_username, password, invalid_password, search_content,correct_password;
	WebDriverWait wait;
	public Loginpage_scenario(AppiumDriver driver) {

		PageFactory.initElements(new AppiumFieldDecorator(driver), lp);
		PageFactory.initElements(new AppiumFieldDecorator(driver), hp);
		PageFactory.initElements(new AppiumFieldDecorator(driver), ct);
		log.info(getClass());
		log.info("Loginpage elements initialized");
	}

		//Login success  Test case
				public void login_successTc() throws InterruptedException, IOException {

					Startpage_scenario spa=new Startpage_scenario(driver);
					wait = new WebDriverWait(driver, 10);
					System.out.println("Language select for flipkart");
					spa.selectenglish();

					obj = new Properties();
					log.info(getClass());
					System.out.println(System.getProperty("user.dir"));
					objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
					obj.load(objfile);

					username = obj.getProperty("username");
					correct_password = obj.getProperty("correct_password");
					System.out.println(username);
					System.out.println(correct_password);
					log.info("Retreiving Username and Password from property file");
					if(wait.until(ExpectedConditions.visibilityOf(lp.sign_up_with)).isDisplayed())
					{
						keys.clickelement(lp.sign_up_with_noneabove);
						keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.use_email_id)));
					}
					else
					{
						keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.use_email_id)));
					}
					
					log.info("Use email id for login");
					
					keys.clearandsend(lp.email_input, username);
					log.info("Typed email id successfully");
					keys.clickelement((lp.continue_email));
					keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.password_input)));
					keys.clearandsend(lp.password_input, correct_password);	
					log.info("Typed password successfully");
					keys.clickelement(lp.continue_login);
					
					if(wait.until(ExpectedConditions.visibilityOf(hp.flipkartplus)).isDisplayed())
					{
						System.out.println("Login successful");
						log.info("Login successful");
					}

				}
				//Negative Testcase
				public void login_negativeTC() throws InterruptedException, IOException {

					Startpage_scenario spa=new Startpage_scenario(driver);
					wait = new WebDriverWait(driver, 10);
					System.out.println("Language select for flipkart");
					spa.selectenglish();

					obj = new Properties();
					log.info(getClass());
					System.out.println(System.getProperty("user.dir"));
					objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
					obj.load(objfile);

					username = obj.getProperty("username");
					invalid_password = obj.getProperty("invalid_password");
					System.out.println(username);
					System.out.println(invalid_password);
					log.info("Retreiving Username and Password from property file");
					if(wait.until(ExpectedConditions.visibilityOf(lp.sign_up_with)).isDisplayed())
					{
						keys.clickelement(lp.sign_up_with_noneabove);
						keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.use_email_id)));
					}
					else
					{
						keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.use_email_id)));
					}
					
					log.info("Use email id for login");
					
					keys.clearandsend(lp.email_input, username);
					log.info("Typed email id successfully");
					keys.clickelement(lp.continue_email);
					keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.password_input)));
					keys.clearandsend(lp.password_input, invalid_password);	
					log.info("Typed password successfully");
					keys.clickelement(lp.continue_login);
					
					if(wait.until(ExpectedConditions.visibilityOf(lp.invalid_login)).isDisplayed())
					{
						System.out.println("invalid login");
						log.info("Invalid login credentials provided");
					}

				}
				
				public void skip_login(){
					Startpage_scenario spa=new Startpage_scenario(driver);
					wait = new WebDriverWait(driver, 10);
					System.out.println("Language select for flipkart");
					spa.selectenglish();
					if(wait.until(ExpectedConditions.visibilityOf(lp.sign_up_with)).isDisplayed())
					{
						keys.clickelement(lp.sign_up_with_noneabove);
						keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.close_login)));
					}
					else
					{
						keys.clickelement(wait.until(ExpectedConditions.visibilityOf(lp.close_login)));
					}
					
					if(wait.until(ExpectedConditions.visibilityOf(hp.flipkartplus)).isDisplayed())
					{
						System.out.println("skip login");
						log.info("skipped login");
					}
					
				}
}
