/**
 * @Project name : BBCNews Automation
 * @Author : Sakthi
 * @Description : This Action class file contains th action methods to scroll down and wait for element to appear
 */

package com.bbcnews.actiondriver;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.bbcnews.utility.AppiumUtils;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Action extends AppiumUtils {

	static AndroidDriver driver;

	public Action(AndroidDriver driver) {

		this.driver = driver;
	}

	public static String scrollToText(String text) {
		WebElement ele = driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
		return text;
	}

	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), "text", "Top Stories"));
	}

}
