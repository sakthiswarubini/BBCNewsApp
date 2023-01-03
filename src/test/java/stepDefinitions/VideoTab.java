package stepDefinitions;

import org.testng.Assert;

import com.bbcnews.pageobject.HomePage;
import com.bbcnews.pageobject.IndexPage;
import com.bbcnews.pageobject.PageObjectManager;
import com.bbcnews.pageobject.SignInPage;
import com.bbcnews.pageobject.VideoPage;
import com.bbcnews.utility.TestContextSetUp;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VideoTab {

	TestContextSetUp testContextSetUp;
	PageObjectManager pageObjectManager;

	public VideoTab(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;

	}

	@Given("the BBC News App is launched and at the homepage")
	public void the_bbc_news_app_is_launched_and_at_the_homepage() throws InterruptedException {
		IndexPage indexPage = testContextSetUp.pageObjectManager.getIndexPage();
		SignInPage signInPage = indexPage.clickOnSignIn();
		signInPage.signInApp("appiumusertest1@gmail.com", "Qwerty@2022");
		signInPage.notificationSettings();
	}

	@When("the user clicks on video tab")
	public void the_user_clicks_on_video_tab() {
		HomePage homePage = testContextSetUp.pageObjectManager.gethomePage();
		homePage.clickVideoTab();
	}

	@Then("the video page text should be {string}")
	public void the_video_page_text_should_be(String videoText) {
		VideoPage videoPage = testContextSetUp.pageObjectManager.getvideoPage();
		String actualString = videoPage.videoPageText();
		System.out.println(actualString);
		Assert.assertEquals(actualString, videoText);
	}

	@And("scroll down to verify the text {string}")
	public void scroll_down_to_the_bottom_of_the_page(String copyText) {
		VideoPage videoPage = testContextSetUp.pageObjectManager.getvideoPage();
		String actString = videoPage.bottomPageText();
		System.out.println(actString);
		Assert.assertEquals(actString, copyText);
	}

}
