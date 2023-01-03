package stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;

import com.bbcnews.utility.TestContextSetUp;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	TestContextSetUp testContextSetUp;
	
	public Hooks(TestContextSetUp testContextSetUp)
	{
		this.testContextSetUp = testContextSetUp;
	}
	
	/*
	 * @Before public void beforeScenario() throws MalformedURLException,
	 * IOException { testContextSetUp.baseClass.ConfigureAppium(); }
	 */
	
	
	@After
	public void afterScenario()
	{
		testContextSetUp.baseClass.tearDown();
	}

}
