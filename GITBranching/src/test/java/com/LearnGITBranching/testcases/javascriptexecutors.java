package com.LearnGITBranching.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.GITBranching.base.baseClass;

public class javascriptexecutors extends baseClass {
	
	JavascriptExecutor js=null;
	
	@Parameters({ "url", "browser" })
	@BeforeClass
	public void setup(String url, String browser) throws IOException {
		initialiseDriver(url, browser);
	}
	
	@Test
	public void searchUsingJavaScript() {
		js=(JavascriptExecutor)driver;
		WebElement ele=driver.findElement(By.xpath("//input[@title='Search']"));
		String script="document.value='facebook'";
		js.executeScript(script, ele);
		
		ele.sendKeys(Keys.ENTER);
		
		driver.findElement(By.className("yuRUbf")).click();
		String text=driver.findElement(By.className("_8eso")).getText();
		System.out.println("text of facebook: "+text);
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
