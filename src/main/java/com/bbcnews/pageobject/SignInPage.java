/**
 * @Project name : BBCNews Automation
 * @Author : Sakthi
 * @Description : This file contains elements and methods for SignIn page
 */

package com.bbcnews.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bbcnews.actiondriver.Action;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage extends Action {

	AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'user-identifier-input']")
	private WebElement userName;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id = 'password-input']")
	private WebElement passWord;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id = 'submit-button']")
	private WebElement signInButton;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement notificationOption;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='NO, THANKS.']")
	private WebElement settingsOption;

	public SignInPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void signInApp(String uname, String pwd) throws InterruptedException {

		userName.sendKeys(uname);
		passWord.sendKeys(pwd);
		signInButton.click();
		Thread.sleep(1000);

	}

	public HomePage notificationSettings() throws InterruptedException {
		notificationOption.click();
		settingsOption.click();
		Thread.sleep(1000);
		return new HomePage(driver);

	}
}
