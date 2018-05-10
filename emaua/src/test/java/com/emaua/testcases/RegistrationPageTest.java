package com.emaua.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.HomePage;
import com.emaua.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase{
	
	HomePage homePage;
	RegistrationPage registrationPage;
	
	
	public RegistrationPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		registrationPage = new RegistrationPage();
	}
	
	@Test(enabled=false)
	public void loginPageTitleTest() {
		String title = registrationPage.validateRegistrationPageTitle();
		Assert.assertEquals(title, "About :: Emaua");
	}
	
	@Test(enabled=false)
	public void emauaLogoTest() {
		boolean flag = registrationPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
