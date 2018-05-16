package com.emaua.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.AboutPage;
import com.emaua.pages.HomePage;
import com.emaua.util.TestUtil;

public class AboutPageTest extends TestBase{
	
	TestUtil testUtil;
	HomePage homePage;
	AboutPage aboutPage;
	
	
	public AboutPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		aboutPage = homePage.clickOnAboutPage();
	}
	
	@Test(priority=1) // Verify the page title
	public void aboutPageTitleTest() {
		String title = aboutPage.validateAboutPageTitle();
		Assert.assertEquals(title, "About :: Emaua", "About page title does not match");
	}
	
	@Test(priority=2)  // Verify that Emaua Logo is visible
	public void emauaLogoTest() {
		boolean flag = aboutPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3) // Verify the About Us Page Heading
	public void verifyAboutUsPageHeaderTest() {
		String aboutUsPageHeader = aboutPage.verifyAboutUsPageHeading();
		Assert.assertEquals(aboutUsPageHeader, "Discover more about us", "Page Header does not match");
	}
	
	@Test(priority=4)  // Verify the broken links
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		aboutPage.verifyBrokenLinks();
	}
	
	@Test(priority=5)  // Verify the BreadCrumb
	public void verifyBreadCrumb() {
		aboutPage.verifybreadCrumb();
		Assert.assertEquals(aboutPage.verifybreadCrumb(), "Home/About", "BreadCrumb does not match");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
