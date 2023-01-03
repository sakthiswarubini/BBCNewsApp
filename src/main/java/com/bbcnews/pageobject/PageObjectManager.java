package com.bbcnews.pageobject;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObjectManager {
	

	public AndroidDriver driver;

	public IndexPage indexPage;
	public SignInPage signInPage;
	public HomePage homePage;
	public VideoPage videoPage;
	public SearchPage searchPage;
	
	public PageObjectManager(AndroidDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public IndexPage getIndexPage()
	{
		indexPage = new IndexPage(driver);
		return indexPage;
	}
	
	public SignInPage getsignInPage()
	{
		signInPage = new SignInPage(driver);
		return signInPage;
	} 
	
	public HomePage gethomePage()
	{
		homePage = new HomePage(driver);
		return homePage;
	} 

	public VideoPage getvideoPage()
	{
		videoPage = new VideoPage(driver);
		return videoPage;
	} 
	public SearchPage getsearchPage()
	{
		searchPage = new SearchPage(driver);
		return searchPage;
	} 
}
