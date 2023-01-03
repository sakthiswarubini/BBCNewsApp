package stepDefinitions;

import org.testng.Assert;

import com.bbcnews.pageobject.HomePage;
import com.bbcnews.pageobject.IndexPage;
import com.bbcnews.pageobject.PageObjectManager;
import com.bbcnews.pageobject.SearchPage;
import com.bbcnews.pageobject.SignInPage;
import com.bbcnews.utility.TestContextSetUp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchIcon {

	TestContextSetUp testContextSetUp;
	PageObjectManager pageObjectManager;
	

	public SearchIcon(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;

	}

	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() throws InterruptedException {
		IndexPage indexPage = testContextSetUp.pageObjectManager.getIndexPage();
		SignInPage signInPage = indexPage.clickOnSignIn();
		signInPage.signInApp("appiumusertest1@gmail.com", "Qwerty@2022");
		signInPage.notificationSettings();
	}

	@When("the user clicks on search icon")
	public void the_user_clicks_on_search_icon() {
		HomePage homePage = testContextSetUp.pageObjectManager.gethomePage();
		homePage.clickSearchButton();
	}

	@When("search for {string}")
	public void search_for(String nameText) {
		SearchPage searchPage = testContextSetUp.pageObjectManager.getsearchPage();
		searchPage.searchPageText(nameText);
	}

	@When("choose England from topics")
	public void choose_england_from_topics() {
		SearchPage searchPage = testContextSetUp.pageObjectManager.getsearchPage();
		searchPage.selectTopic();
	}

	@Then("verify the navigation bar text as {string}")
	public void verify_the_navigation_bar_text_as(String searchPageText) {
		SearchPage searchPage = testContextSetUp.pageObjectManager.getsearchPage();
		String searchText = searchPage.searchPageValidation();
		Assert.assertEquals(searchText, searchPageText);
	}

}
