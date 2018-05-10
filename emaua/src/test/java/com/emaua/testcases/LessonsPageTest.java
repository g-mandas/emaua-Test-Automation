package com.emaua.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.HomePage;
import com.emaua.pages.LessonsPage;

public class LessonsPageTest extends TestBase{
	
	HomePage homePage;
	LessonsPage lessonsPage;
	
	
	public LessonsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		lessonsPage = new LessonsPage();
	}
	
	@Test(enabled=false)
	public void loginPageTitleTest() {
		String title = lessonsPage.validateLessonsPageTitle();
		Assert.assertEquals(title, "About :: Emaua");
	}
	
	@Test(enabled=false)
	public void emauaLogoTest() {
		boolean flag = lessonsPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
