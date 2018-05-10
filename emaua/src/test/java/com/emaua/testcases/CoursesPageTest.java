package com.emaua.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.CoursesPage;
import com.emaua.pages.HomePage;

public class CoursesPageTest extends TestBase{
	
	HomePage homePage;
	CoursesPage coursesPage;
	
	
	public CoursesPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		coursesPage = new CoursesPage();
	}
	
	@Test(enabled=false)
	public void loginPageTitleTest() {
		String title = coursesPage.validateCoursesPageTitle();
		Assert.assertEquals(title, "About :: Emaua");
	}
	
	@Test(enabled=false)
	public void emauaLogoTest() {
		boolean flag = coursesPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
