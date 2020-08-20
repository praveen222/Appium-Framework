package TestPageScenario;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestBase.DriverBase;
import TestPages.HomePage;
import general.KeywordFunctions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import TestPages.*;

public class HomePage_cartOperation extends DriverBase {
	protected Logger log = Logger.getLogger(HomePage.class.getName());// + ":" + nameofCurrMethod);
	public HomePage homepage = new HomePage();
	protected KeywordFunctions keys = new KeywordFunctions(driver);

	public Properties obj;
	public FileInputStream objfile;
	public String search_content, product_name;
	WebDriverWait wait;

	public HomePage_cartOperation(AppiumDriver driver) {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(new AppiumFieldDecorator(driver), homepage);
	}

	// performing cart operation after login
	public void cartoperation() throws InterruptedException, IOException {
		wait = new WebDriverWait(driver, 10);
		obj = new Properties();
		log.info(getClass());
		System.out.println(System.getProperty("user.dir"));
		objfile = new FileInputStream(System.getProperty("user.dir") + "/util/testdata.properties");
		obj.load(objfile);
		/*
		 * To read data from excel sheet ExcelRead=new
		 * FileInputStream("TestData/testdata.xlsx"); wbk=new XSSFWorkbook(ExcelRead);
		 * String search_item = wbk.getSheetAt(0).getRow(3).getCell(1).toString();
		 */
		log.info("Login successfull");
		keys.landscape();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Landscape rotation successfull");
		keys.portrait();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		log.info("Portrait rotation successfull");

		search_content = obj.getProperty("search_content");
		log.info("Reading search content from external property file");
		System.out.println("search content:" + search_content);
		// Must be commented
		// keys.clickElement(wait.until(ExpectedConditions.visibilityOf(skip_signin)));
		// log.info("Signin skipped");
		
		

	}

}
