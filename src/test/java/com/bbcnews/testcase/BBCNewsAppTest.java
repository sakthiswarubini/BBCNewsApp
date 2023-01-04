/**
 * @Project name : BBCNews Automation
 * @Author : Sakthi
 * @Description : This is the TestNG test case file for End to End testing
 */

package com.bbcnews.testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import com.bbcnews.pageobject.HomePage;
import com.bbcnews.pageobject.SearchPage;
import com.bbcnews.pageobject.SignInPage;
import com.bbcnews.pageobject.VideoPage;
import com.bbcnews.testbase.BaseClass;

public class BBCNewsAppTest extends BaseClass {

	@Test(dataProvider = "getData")
	public void e2eTest(HashMap<String, String> input) throws MalformedURLException, InterruptedException {

		SignInPage signInPage = indexPage.clickOnSignIn();
		signInPage.signInApp(input.get("emailId"), input.get("password"));
		HomePage homePage = signInPage.notificationSettings();
		VideoPage videoPage = homePage.clickVideoTab();
		String videoText = videoPage.videoPageText();
		Assert.assertEquals(videoText, "BBC News Channel (UK Only)");
		String copyRightText = videoPage.copyRightText(input.get("scrollDownText"));
		Assert.assertEquals(copyRightText, "Copyright © 2018 BBC");
		SearchPage searchPage = videoPage.clickSearchIcon();
		searchPage.searchPageText(input.get("searchText"));
		searchPage.selectTopic();
		String searchPageString = searchPage.searchPageValidation();
		Assert.assertEquals(searchPageString, "England");
		searchPage.navigateToHomePage();
		String homePageTextString = homePage.verifyHomePageText();
		Assert.assertEquals(homePageTextString, "Top Stories");
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				System.getProperty("user.dir") + "//src//test//java//com//bbcnews//testdata//bbctestdata.json");
		return new Object[][] { { data.get(0) } };
	}

}
