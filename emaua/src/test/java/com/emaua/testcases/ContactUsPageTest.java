package com.emaua.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.ContactUsPage;
import com.emaua.pages.HomePage;

public class ContactUsPageTest extends TestBase{
	
	HomePage homePage;
	ContactUsPage contactUsPage;
	
	
	public ContactUsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		contactUsPage = new ContactUsPage();
	}
	
	@Test(priority=1) // Verify the page title
	public void contactUsPageTitleTest() {
		String title = contactUsPage.validateContactUsPageTitle();
		Assert.assertEquals(title, "Contact Us :: Emaua", "Contact Us page title does not match");
	}
	
	@Test(priority=2) // Verify that Emaua Logo is visible
	public void emauaLogoTest() {
		boolean flag = contactUsPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3) // Verify the About Us Page Heading
	public void verifyContactUsPageHeaderTest() {
		String contactUsPageHeader = contactUsPage.verifyContactUsPageHeading();
		Assert.assertEquals(contactUsPageHeader, "Contact us", "Page Header does not match");
	}
	
	@Test(priority=4)  // Verify the broken links
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		contactUsPage.verifyBrokenLinks();
	}
	
	@Test(priority=5)  // Verify the BreadCrumb
	public void verifyBreadCrumb() {
		contactUsPage.verifybreadCrumb();
		Assert.assertEquals(contactUsPage.verifybreadCrumb(), "Home/Contact Us", "BreadCrumb does not match");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
