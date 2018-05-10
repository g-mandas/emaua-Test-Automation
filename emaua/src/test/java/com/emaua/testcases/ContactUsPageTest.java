package com.emaua.testcases;

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
	
	@Test(enabled=false)
	public void loginPageTitleTest() {
		String title = contactUsPage.validateContactUsPageTitle();
		Assert.assertEquals(title, "About :: Emaua");
	}
	
	@Test(enabled=false)
	public void emauaLogoTest() {
		boolean flag = contactUsPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
