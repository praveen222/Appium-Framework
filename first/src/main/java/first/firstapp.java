package first;

import org.testng.annotations.Test;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import android.widget.LinearLayout;
import android.widget.TextView;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class firstapp {
	
	public WebDriver driver;
    public WebDriverWait wait;
	private boolean flag;
    
    @BeforeMethod
    public void setup () throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("no",true);
        caps.setCapability("deviceName", "Device");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.1.0");
        caps.setCapability("skipUnlock","true");
        caps.setCapability("appPackage", "com.telstra.mobile.android.mytelstra.dev.debug");
        caps.setCapability("appActivity","com.telstra.android.myt.main.MainActivity");

        caps.setCapability("noReset","false");
        caps.setCapability("automationName", "UiAutomator1");
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4725/wd/hub"),caps);
        //driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);

        
    }

	@Test
    public void basicTest2 () throws InterruptedException {
        
        Thread.sleep(10000);
        
		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra:id/next']"
		 * )).click();
		 * 
		 * Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra:id/next']"
		 * )).click(); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//android.widget.Button[@resource-id='com.telstra.mobile.android.mytelstra:id/next']"
		 * )).click();
		 * 
		 * driver.findElement(By.id("com.telstra.mobile.android.mytelstra:id/close")).
		 * click(); Thread.sleep(5000);
		 */
        //TouchAction actions;
        int count=3;
        try {
        	Thread.sleep(5000);
            driver.findElement(By.xpath("//android.widget.TextView[@text='Services']")).click();
            Thread.sleep(5000);
            Reporter.log("Successfully selected Services option");
           }
        catch(Exception e) {
        	Reporter.log("Failed to  select Services option");
           }
        //looping through to scroll down to desired location
        for(int i=0;i<count;i++) {
        	
        	org.openqa.selenium.Dimension size = driver.manage().window().getSize();

        	//x position set to mid-screen horizontally
        	int width = size.width / 2;

        	//Starting y location set to 70% of the height (near bottom)
        	int startPoint = (int) (size.getHeight() * 0.70);

        	//Ending y location set to 20% of the height (near top)
        	int endPoint = (int) (size.getHeight() * 0.20);

        	new TouchAction((PerformsTouchActions) driver).press(PointOption.point(width, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(width, endPoint)).release().perform();
        }

        Thread.sleep(10000);
        
        WebElement result1 = driver.findElement(By.xpath("((//android.widget.LinearLayout[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/cardSectionLayout'])[2]/android.widget.Button/android.widget.TextView)[2]"));
        String mob=result1.getText();
        System.out.println("Mobile Number:"+mob);
        
        WebElement result2 = driver.findElement(By.xpath("((//android.widget.RelativeLayout[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/postpaidDataUsageView'])/android.widget.LinearLayout/android.widget.TextView)[2]"));
        String data=result2.getText();
        System.out.println("Data:"+data);
        
        WebElement result3 = driver.findElement(By.xpath("((//android.widget.RelativeLayout[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/postpaidDaysUsageView'])/android.widget.LinearLayout/android.widget.TextView)[2]"));
        String days=result3.getText();
        System.out.println("Days:"+days);
        
        Thread.sleep(3000);
        flag=false;
        
        try {
        	driver.findElement(By.xpath("((//android.widget.LinearLayout[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/cardSectionLayout'])[2]/android.widget.Button/android.widget.ImageView)[2]")).click();
        	Thread.sleep(10000);
        	System.out.println("Clicking Mobile Summary card for Mobile Number:"+mob );
        	Reporter.log("Successfully clicked Mobile Summary card for Mobile Number:"+mob);
        	flag = true;
        	
        }
        catch(Exception e) {
            
            Reporter.log("Failed to click Mobile Summary for Mobile Number:"+mob);
        }
        
        if (flag == true) {
        	System.out.println("Validating the mobile summary card for mobile number:"+mob);
        	WebElement mob_summary_number = driver.findElement(By.id("subTitleTextView"));
        	String summary_mobile_number=mob_summary_number.getText();
        	System.out.println("Mobile Summary Number:"+summary_mobile_number);
        
        	WebElement mob_summary_data = driver.findElement(By.xpath("((//android.widget.RelativeLayout[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/postpaidDataUsageView'])/android.widget.LinearLayout/android.widget.TextView)[2]"));
        	String summary_data=mob_summary_data.getText();
        	System.out.println("Mobile Summary Data:"+summary_data);
        
        	WebElement mob_summary_days = driver.findElement(By.xpath("((//android.widget.RelativeLayout[@resource-id='com.telstra.mobile.android.mytelstra.dev.debug:id/postpaidDaysUsageView'])/android.widget.LinearLayout/android.widget.TextView)[2]"));
        	String summary_days=mob_summary_days.getText();
        	System.out.println("Mobile Summary Days:"+summary_days);
        
        	Thread.sleep(5000);
        
        	assert mob.equals(summary_mobile_number):"Actual value is : "+mob +" did not match with expected value:"+ summary_mobile_number;
        	assert data.equals(summary_data):"Actual value is : "+data +" did not match with expected value:"+ summary_data;
        	assert days.equals(summary_days):"Actual value is : "+days +" did not match with expected value:"+ summary_days;
        }
        else {
        	System.out.println("Unable to validate the mobile Sumamry services for mobile number:"+mob);
        	Reporter.log("Unable to validate the mobile Sumamry services for mobile number:"+mob);
        }
        
    }


@AfterMethod
    public void teardown(){
        driver.quit();
    }


}
