package general;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;

import TestBase.DriverBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
// common functions across test execution
public class allfunctions extends DriverBase {

	public allfunctions(WebDriver driver) {
		// TODO Auto-generated constructor stub
		driver = DriverBase.driver;
	}
	//clicking element
	public void clickelement(WebElement element) {
		element.click();

	}
	//setting value to element
	public void clearandsend(WebElement element, String str) {
		((MobileElement) element).clear();
		((MobileElement) element).setValue(str);
	}
	
	//scrolling to element text
	public void scrollToText(String searchcontent) {

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().textContains(\"" + searchcontent + "\").instance(0))"));

	}
	public void scrollToelem(WebElement elem) {

		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().textContains(\"" + elem.getText() + "\").instance(0))"));

	}
	//getting text property of element
	public  String getElementText(WebElement ele, String param) {
		String eletext = ele.getAttribute(param);

		return eletext;
	}
	
	
	
	
	public void tryVscrolltoElement(String xpath, double startwidthx, double startheighty, double endheighty) {
		TouchAction actions;
		Dimension dimensions = driver.manage().window().getSize();
		System.out.println("s=" + dimensions);
		Double screenWidthStart = dimensions.getWidth() * startwidthx;
		int scrollStartx = screenWidthStart.intValue();
		System.out.println("startx=" + scrollStartx);
		Double screenHeightStart = dimensions.getHeight() * startheighty;
		int scrollStarty = screenHeightStart.intValue();
		System.out.println("starty=" + scrollStarty);
		Double screenHeightEnd = dimensions.getHeight() * endheighty;
		int scrollEndy = screenHeightEnd.intValue();
		System.out.println("endy=" + scrollEndy);
		actions = new TouchAction(driver);
		boolean display;
		By element=By.xpath(xpath);
		display = driver.findElements(element).size()>0;
		do{
		actions.press(PointOption.point(scrollStartx, scrollStarty))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
		.moveTo(PointOption.point(scrollStartx, scrollEndy)).release().perform();
		display = driver.findElements(element).size()>0;
		}while(display == false); 

	}	

	
	
	//perform enter key operation
	public void enter_key() {

		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

	}
	public void home_key() {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.HOME));
	}
	public void back_key() {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
	public void landscape() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
	}
	public void portrait() {
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
	public void sendString(WebElement element, String name) {
		
		element.sendKeys(name);
	}
	
	public void scrollcordinate(int x1,int y1,int x2,int y2) {
		TouchAction action;
		
		action=new TouchAction((PerformsTouchActions) driver);
		action.press(new PointOption().withCoordinates(x1,y1)).moveTo(new PointOption().withCoordinates(x2,y2)).release().perform();
		
	}
	public void elem_search() {
		//String driverCommand="adb -s input keyevent 84";

		//((AndroidDriver) driver).execute(driverCommand);
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.SEARCH));
		

	}
	public  void tapcordinate(int x1,int y1) {
        TouchAction action;
		
		action=new TouchAction((PerformsTouchActions) driver);
		action.tap(new PointOption().withCoordinates(x1, y1)).perform();
		
	}
	
	
}
