/**
 * @Project name : BBCNews Automation
 * @Author : Sakthi
 * @Description : This file contains elements and methods for Index page
 */

package com.bbcnews.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bbcnews.actiondriver.Action;
import com.bbcnews.testbase.BaseClass;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class IndexPage extends Action {

	AndroidDriver driver;

	@AndroidFindBy(accessibility = "Sign in to a BBC Account")
	private WebElement signIn;

	@AndroidFindBy(xpath = "//android.widget.Button[@text = 'Allow']")
	private WebElement notification;

	@AndroidFindBy(accessibility = "Use a different BBC account")
	private WebElement newAccount;

	public IndexPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public SignInPage clickOnSignIn() throws InterruptedException {
		signIn.click();
		notification.click();
		newAccount.click();
		Thread.sleep(1000);
		return new SignInPage(driver);
	}

	/*
	 * public void setActivity() { Activity activity = new
	 * Activity("bbc.mobile.news.uk","bbc.mobile.news.v3.ui.splash.SplashActivity");
	 * driver.startActivity(activity); }
	 */

}
