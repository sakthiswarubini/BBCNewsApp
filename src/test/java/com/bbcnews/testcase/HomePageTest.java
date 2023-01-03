package com.bbcnews.testcase;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bbcnews.pageobject.HomePage;
import com.bbcnews.pageobject.SearchPage;
import com.bbcnews.pageobject.SignInPage;
import com.bbcnews.testbase.BaseClass;

public class HomePageTest extends BaseClass {
	

	@Test(dataProvider= "getData")
	public void homeTest(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

		SignInPage signInPage = indexPage.clickOnSignIn();
		signInPage.signInApp(input.get("emailId"), input.get("password"));
		HomePage homePage = signInPage.notificationSettings();
		SearchPage searchPage = homePage.clickSearchButton();
		searchPage.searchPageText(input.get("searchText"));
		searchPage.selectTopic();
		String searchPageText = searchPage.searchPageValidation();
		Assert.assertEquals(searchPageText, "England");
		searchPage.navigateToHomePage();
		String homePageTextString = homePage.verifyHomePageText();
		Assert.assertEquals(homePageTextString, "Top Stories");
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data =  getJsonData(System.getProperty("user.dir")+"//src//test//java//com//bbcnews//testdata//bbctestdata.json");
		return new Object[][] { { data.get(0) } };
	}

}

