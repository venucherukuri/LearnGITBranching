package com.LearnGITBranching.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.GITBranching.base.baseClass;

public class Assertions extends baseClass {

	@Parameters({ "url", "browser" })
	@BeforeClass
	public void setup(String url, String browser) throws IOException {
		initialiseDriver(url, browser);
	}

	@Test
	public void assertTrue() {
		String title=driver.getTitle();
		System.out.println("title of the page: "+title);
		try {
		Assert.assertTrue(true);
		System.out.println("Assertion success");
		}
		catch(Throwable e){
			System.out.println("Assertion failed");
		}
	}
	
	@Test
	public void assertTrue1() {
		System.out.println("second assertion");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
