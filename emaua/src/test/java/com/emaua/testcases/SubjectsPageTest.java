package com.emaua.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.HomePage;
import com.emaua.pages.SubjectsPage;

public class SubjectsPageTest extends TestBase{
	
	HomePage homePage;
	SubjectsPage subjectsPage;
	
	
	public SubjectsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		subjectsPage = new SubjectsPage();
	}
	
	@Test(enabled=false)
	public void loginPageTitleTest() {
		String title = subjectsPage.validateSubjectsPageTitle();
		Assert.assertEquals(title, "About :: Emaua");
	}
	
	@Test(enabled=false)
	public void emauaLogoTest() {
		boolean flag = subjectsPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
