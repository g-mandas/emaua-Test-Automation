package com.emaua.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.AboutPage;
import com.emaua.pages.HomePage;

public class AboutPageTest extends TestBase{
	
	HomePage homePage;
	AboutPage aboutPage;
	
	
	public AboutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		aboutPage = new AboutPage();
	}
	
	@Test(enabled=false)
	public void loginPageTitleTest() {
		String title = aboutPage.validateAboutPageTitle();
		Assert.assertEquals(title, "About :: Emaua");
	}
	
	@Test(enabled=false)
	public void emauaLogoTest() {
		boolean flag = aboutPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
