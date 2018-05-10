package com.emaua.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.HomePage;
import com.emaua.pages.LoginPage;
import com.emaua.pages.TeachersPage;
import com.emaua.util.TestUtil;

public class TeachersPageTest extends TestBase{

	TestUtil testUtil;
	HomePage homePage;
	TeachersPage teachersPage;
	LoginPage loginPage;


//	org.openqa.selenium.interactions.Actions builder;
	
	public TeachersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = teachersPage.clickOnLoginPage();
		teachersPage = new TeachersPage();

		
	}
	
	@Test(enabled=false)
		public void teachersPageTitleTest() {
			String title = teachersPage.validateLoginPageTitle();
			Assert.assertEquals(title, "Teachers :: Emaua");
		}
	
	@Test(priority=1)
	public void verifyTeachersPageHeading() {
		Assert.assertTrue(teachersPage.verifyTeachersPageHeading(), "page heading is missing on the page");
	}
	
	@Test(enabled=false)
		public void clickOnCheckCoursesButton() {
			teachersPage.clickOnCheckCoursesButton();
	}
	
	//@Test(enabled=false)
	//	public void verifyCategoryTitle() {
	//		String categoryTitle=teachersPage.validateCategoryTitle();
	//		Assert.assertEquals(categoryTitle, "Teachers");
	//	}
	
	@Test()
	public void verifyAddTeacher() {
		loginPage = teachersPage.clickOnLoginPage();
	//	teachersPage = teachersPage.login(prop.getProperty("username"), prop.getProperty("password"));
		teachersPage = homePage.clickOnTeachersPage();
		//NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		//ngWebDriver.waitForAngularRequestsToFinish();
		teachersPage.clickOnAddTeacherButton();
		//ngWebDriver.waitForAngularRequestsToFinish();
		teachersPage.addTeacher("Gokhan", "Mr.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
