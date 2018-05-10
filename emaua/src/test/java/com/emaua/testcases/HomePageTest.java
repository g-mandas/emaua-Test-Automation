package com.emaua.testcases;

import com.emaua.pages.HomePage;
import com.emaua.pages.InstitutionsPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.pages.LoginPage;
import com.emaua.pages.TeachersPage;
import com.emaua.util.TestUtil;
import com.emaua.base.TestBase;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	InstitutionsPage institutionsPage;
	TeachersPage teachersPage;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		institutionsPage = new InstitutionsPage();
		teachersPage = new TeachersPage();

	//	homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(enabled=false)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Home :: Emaua", "Home page title not match");
	}
	
	@Test(priority=1)
	public void verifyInstitutionsPageLink() {
		institutionsPage = homePage.clickOnInstitutionsPage();
	}
	
	@Test(priority=1)
	public void verifyTeachersPageLink() {
		teachersPage = homePage.clickOnTeachersPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageLink() {
		loginPage = homePage.clickOnLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
