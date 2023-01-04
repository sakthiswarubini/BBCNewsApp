/**
 * @Project name : BBCNews Automation
 * @Author : Sakthi
 * @Description : This file contains elements and methods for Home page
 */

package com.bbcnews.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bbcnews.actiondriver.Action;
import com.bbcnews.testbase.BaseClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends Action {

	AndroidDriver driver;

	@AndroidFindBy(accessibility = "Video")
	private WebElement videoTab;

	@AndroidFindBy(accessibility = "Search")
	private WebElement searchButton;

	@AndroidFindBy(accessibility = "Top Stories")
	private WebElement homePageText;

	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public VideoPage clickVideoTab() {
		videoTab.click();
		return new VideoPage(driver);
	}

	public SearchPage clickSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}

	public String verifyHomePageText() {
		return homePageText.getAttribute("content-desc");

	}

}
