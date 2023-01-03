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
import com.bbcnews.pageobject.SignInPage;
import com.bbcnews.pageobject.VideoPage;
import com.bbcnews.testbase.BaseClass;

public class VideoPageTest extends BaseClass {
	

	@Test(dataProvider= "getAppData")
	public void videoTest(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
		SignInPage signInPage = indexPage.clickOnSignIn();
		signInPage.signInApp(input.get("emailId"), input.get("password"));
		HomePage homePage = signInPage.notificationSettings();
		VideoPage videoPage = homePage.clickVideoTab();
		String videoText = videoPage.videoPageText();
		Assert.assertEquals(videoText, "BBC News Channel (UK Only)");
		String copyRightText = videoPage.copyRightText(input.get("scrollDownText"));
		Assert.assertEquals(copyRightText, "Copyright © 2018 BBC");

}
	
	@DataProvider
	public Object[][] getAppData() throws IOException {
		List<HashMap<String, String>> data =  getJsonData(System.getProperty("user.dir")+"//src//test//java//com//bbcnews//testdata//bbctestdata.json");
		return new Object[][] { { data.get(0) } };
	}
}
