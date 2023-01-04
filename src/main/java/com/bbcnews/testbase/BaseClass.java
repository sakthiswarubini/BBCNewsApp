/**
 * @Project name : BBCNews Automation
 * @Author : Sakthi
 * @Description : This is the base class which invoke the App in the emulator and 
 * once the process finish it will quite the app and server 
 */

package com.bbcnews.testbase;

import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import com.bbcnews.pageobject.IndexPage;
import com.bbcnews.utility.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseClass extends AppiumUtils {

	public AndroidDriver driver;

	public IndexPage indexPage;

	@BeforeClass
	public AndroidDriver ConfigureAppium() throws MalformedURLException, IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//com//bbcnews//resources//data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		// options.setChromedriverExecutable("C://Sakthi//Appium//Testing//Apps//chromedriver.exe");
		options.setApp(System.getProperty("user.dir") + "//src//test//java//com//bbcnews//resources//bbcnews.apk");
		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.manage().deleteAllCookies();
		indexPage = new IndexPage(driver);
		return driver;

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();

	}
}
