package TestBase;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status; 
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverBase {
	protected Logger log=Logger.getLogger(TestBase.DriverBase.class.getName());
	DesiredCapabilities cap;
	protected static AndroidDriver driver;
	@BeforeMethod
	@Parameters({"deviceName","platformname","platformversion","appackage","appactivity"})
	public void driversetup(String deviceName,String platformname,String platformversion,String appackage, String appactivity) throws MalformedURLException {
		System.out.println("Loading configuration androiddriver and desiredcapabilities!");
		cap=new DesiredCapabilities();
		DOMConfigurator.configure("util/log4j.xml");
		log.info(getClass());
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("platformVersion", platformversion);
		cap.setCapability("platformName", platformname);
		cap.setCapability("appPackage", appackage);
		cap.setCapability("appActivity", appactivity);
		//cap.setCapability("app", application);
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("autoAcceptAlerts", "true");
		cap.setCapability("noReset", "false");
		cap.setCapability("fullReset", "false");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("skipServerInstallation", "true");
		driver= new AndroidDriver<MobileElement>(new URL ("http://localhost:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Androiddriver created successfully");
		log.info(appackage+"Application launched successfully");
		
		
	}
	
	@AfterMethod
	public void resultflow_tesrdown(ITestResult result) {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		System.out.println("Test result is"+result+"\nTest status is"+result.getStatus());
		String testname=result.getName();
		if(!result.isSuccess()) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				
				String screenshotPath = System.getProperty("user.dir") + "/screenshots/FailureScreenshots/" + testname + "_" + formater.format(cal.getTime()) + ".png";
				screenshotPath = screenshotPath. replace("\\", "/");
				System.out.println("Taking screenshot:" + screenshotPath);
				FileUtils.copyFile(scrFile, new File(screenshotPath));

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			log.info(testname+" Testcase is failed");
		} 
		else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println(testname+"Testcase skipped");
			log.info(testname+" Testcase is skipped");
			}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				String screenshotPath = System.getProperty("user.dir") + "/screenshots/SuccessfullScreenshots/" + testname + "_" + formater.format(cal.getTime()) + ".png";
				screenshotPath = screenshotPath. replace("\\", "/");
				System.out.println("Taking screenshot:" + screenshotPath);
				FileUtils.copyFile(scrFile, new File(screenshotPath));
		
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println("Result is :" + result);
			System.out.println("Result status is :" + result.getStatus());
			System.out.println("Test Case PASSED is " + result.getName());
			log.info(testname+" Testcase is passed");
		}
		
	driver.quit();
	log.info("Driver quit successfully");
	}}


