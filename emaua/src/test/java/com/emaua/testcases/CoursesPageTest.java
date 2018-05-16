package com.emaua.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

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
	
	@Test(priority=3) // Verify the Courses Page Heading
	public void verifyAboutUsPageHeaderTest() {
		String coursesPageHeader = coursesPage.verifyCoursesPageHeading();
		Assert.assertEquals(coursesPageHeader, "Courses", "Page Header does not match");
	}
	
	@Test(priority=4)  // Verify the broken links
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		coursesPage.verifyBrokenLinks();
	}
	
	@Test(priority=5)  // Verify the BreadCrumb
	public void verifyBreadCrumb() {
		coursesPage.verifybreadCrumb();
		Assert.assertEquals(coursesPage.verifybreadCrumb(), "Home/About", "BreadCrumb does not match");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
