package com.bbcnews.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bbcnews.actiondriver.Action;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VideoPage extends Action {

	 AndroidDriver driver;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='bbc.mobile.news.uk:id/content_card_title']")
	private  WebElement titleText;

	@AndroidFindBy(id = "bbc.mobile.news.uk:id/copyright_item_title")
	private  WebElement copyText;

	@AndroidFindBy(accessibility = "Search")
	private  WebElement searchButton;

	public VideoPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public  String videoPageText() {

		return titleText.getText();

	}

	public  String bottomPageText() {
		scrollToText("Copyright © 2018 BBC");
		return copyText.getText();

	}

	public  String copyRightText(String copyString) {
		return scrollToText("Copyright © 2018 BBC");
	}

	public  SearchPage clickSearchIcon() {
		searchButton.click();
		return new SearchPage(driver);
	}

}
