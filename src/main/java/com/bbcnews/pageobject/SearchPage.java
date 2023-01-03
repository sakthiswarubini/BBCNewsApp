package com.bbcnews.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bbcnews.actiondriver.Action;
import com.bbcnews.testbase.BaseClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage extends Action {

	 AndroidDriver driver;

	@AndroidFindBy(id = "bbc.mobile.news.uk:id/search")
	private  WebElement searchText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='England']")
	private  WebElement selectOption;

	@AndroidFindBy(id = "bbc.mobile.news.uk:id/activity_news_index_title")
	private  WebElement indexTitle;

	@AndroidFindBy(accessibility = "Navigate up")
	private  WebElement navigatePage;

	@AndroidFindBy(accessibility = "Back")
	private  WebElement backtohomePage;

	public SearchPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public  void searchPageText(String searchValue) {

		searchText.sendKeys(searchValue);
	}

	public  void selectTopic() {
		selectOption.click();
	}

	public  String searchPageValidation() {

		return indexTitle.getText();

	}

	public  HomePage navigateToHomePage() {
		navigatePage.click();
		backtohomePage.click();
		return new HomePage(driver);
	}

}
