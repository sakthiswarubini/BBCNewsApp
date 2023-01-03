package stepDefinitions;

import org.testng.Assert;

import com.bbcnews.pageobject.HomePage;
import com.bbcnews.pageobject.IndexPage;
import com.bbcnews.pageobject.PageObjectManager;
import com.bbcnews.pageobject.SearchPage;
import com.bbcnews.pageobject.SignInPage;
import com.bbcnews.pageobject.VideoPage;
import com.bbcnews.testbase.BaseClass;
import com.bbcnews.utility.TestContextSetUp;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigateToHomePage  {

	TestContextSetUp testContextSetUp;
	PageObjectManager pageObjectManager;

	
	  public NavigateToHomePage(TestContextSetUp testContextSetUp)
	  {
	  this.testContextSetUp = testContextSetUp; 
	  }
	 
	
	
	
	
	@Given("The user is on {string} page")
	public void the_user_is_on_page(String nameText) throws InterruptedException {
		IndexPage indexPage = testContextSetUp.pageObjectManager.getIndexPage();
		SignInPage signInPage = indexPage.clickOnSignIn();
		signInPage.signInApp("appiumusertest1@gmail.com", "Qwerty@2022");
		signInPage.notificationSettings();
		HomePage homePage = testContextSetUp.pageObjectManager.gethomePage();
		homePage.clickSearchButton();
		SearchPage searchPage = testContextSetUp.pageObjectManager.getsearchPage();
		searchPage.searchPageText(nameText);
		searchPage.selectTopic();
	}

	@When("the user navigate back to the Home page")
	public void the_user_navigate_back_to_the_home_page() {
		SearchPage searchPage = testContextSetUp.pageObjectManager.getsearchPage();
		searchPage.navigateToHomePage();
	}

	@Then("validate the Home page text {string}")
	public void validate_the_home_page_text(String homePageText) {
		HomePage homePage = testContextSetUp.pageObjectManager.gethomePage();
		String homeText = homePage.verifyHomePageText();
		Assert.assertEquals(homeText, homePageText);
	}

}
