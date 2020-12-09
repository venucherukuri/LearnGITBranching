/**
 * 
 */

package com.GITBranching.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.GITBranching.Actions.pageActions;


/**
 * @author Venu_Cherukuri
 *
 */
public class baseClass {

	public static  WebDriver driver;
	public static Properties prop;
	public static FileInputStream file;



	@Parameters({ "url", "browser" })
	public static void initialiseDriver(String url, String browser) throws IOException {

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Initializing the browser from parameters concept");

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
			driver = new ChromeDriver();

			driver.get(url);
		} else {
			System.out.println("intialzing the browser using config.prop");
			prop = new Properties();
			file = new FileInputStream(System.getProperty("user.dir") + "/configuration/Config.properties");
			prop.load(file);

			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/Driver/chromedriver.exe");
				driver = new ChromeDriver();
			}

			driver.get(prop.getProperty("url"));

		}
		pageActions.webElement_windowMaximize(driver);
		pageActions.webElement_ImpicitTimeWait(driver);
		pageActions.webElement_pageTimeOut(driver);

	}

}
