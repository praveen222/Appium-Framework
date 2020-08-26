package TestPageScenario;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.DriverBase;
import TestPages.HomePage;
import TestPages.Startpage;
import general.allfunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Startpage_scenario extends DriverBase {
	protected Logger log = Logger.getLogger(HomePage.class.getName());// + ":" + nameofCurrMethod);
	public Startpage sp = new Startpage();
	protected allfunctions keys = new allfunctions(driver);

	public Properties obj;
	public FileInputStream objfile;
	public String search_content, product_name;
	WebDriverWait wait;

	public  Startpage_scenario(AppiumDriver driver) {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(new AppiumFieldDecorator(driver), sp);
		log.info(getClass());
		log.info("Start page elements initialized");
	}
	public void selectenglish() {
		wait = new WebDriverWait(driver, 10);
		//select english and continue
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(sp.lan_english)));
		keys.clickelement(sp.lan_continue);
		log.info("startpage:English selected");
	}

	public void selectTelgu() {
		wait = new WebDriverWait(driver, 10);
		//select Telgu and continue
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(sp.lan_telgu)));
		keys.clickelement(sp.lan_continue);
		log.info("startpage:Telgu selected");
	}
	public void selectTamil() {
		wait = new WebDriverWait(driver, 10);
		//select Tamil and continue
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(sp.lan_tamil)));
		keys.clickelement(sp.lan_continue);
		log.info("startpage:Tamil selected");
	}
	public void selectHindi() {
		wait = new WebDriverWait(driver, 10);
		//select Hindi and continue
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(sp.lan_hindi)));
		keys.clickelement(sp.lan_continue);
		log.info("startpage:Hindi selected");
	}
	public void selectKannada() {
		wait = new WebDriverWait(driver, 10);
		//select Kannada and continue
		keys.clickelement(wait.until(ExpectedConditions.visibilityOf(sp.lan_kannada)));
		keys.clickelement(sp.lan_continue);
		log.info("startpage:Kannada selected");
	}
}
