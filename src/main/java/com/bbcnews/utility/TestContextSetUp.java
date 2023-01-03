package com.bbcnews.utility;

import java.io.IOException;
import java.net.MalformedURLException;

import com.bbcnews.pageobject.PageObjectManager;
import com.bbcnews.testbase.BaseClass;

import io.appium.java_client.android.AndroidDriver;

public class TestContextSetUp {
	
	public AndroidDriver driver;
	public PageObjectManager pageObjectManager;
	public BaseClass baseClass;
	
	public TestContextSetUp() throws MalformedURLException, IOException {
		baseClass = new BaseClass();
		pageObjectManager = new PageObjectManager(baseClass.ConfigureAppium());
	}

}
