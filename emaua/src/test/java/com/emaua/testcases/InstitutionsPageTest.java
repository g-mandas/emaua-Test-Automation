package com.emaua.testcases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.HomePage;
import com.emaua.pages.InstitutionsPage;
import com.emaua.pages.LoginPage;
import com.emaua.pages.TeachersPage;
import com.emaua.util.TestUtil;

public class InstitutionsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	InstitutionsPage institutionsPage;
	TeachersPage teachersPage;

	public InstitutionsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
		Thread.sleep(4000);
		institutionsPage = homePage.clickOnInstitutionsPage();
		Thread.sleep(4000);

	}
	
	@Test(enabled=false) // Verify the Institutions Page Title -- COMPLETED
	public void verifyInstitutionsPageTitleTest() {
		String institutionPageTitle = institutionsPage.validateInstitutionsPageTitle();
		Assert.assertEquals(institutionPageTitle, "Institutions :: Emaua", "Home page title not match");
	}
	
	@Test(enabled=false)		//Verify that SuperAdmin can add a new Institution  -- COMPLETED
	public void verifyAddInstitutionButtonTest() throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		institutionsPage.addNewInstitution();
		institutionsPage.clickUploadImage();
		Thread.sleep(4000);
		institutionsPage.clickSaveButton();
	}
	
	
	@Test(enabled=false)  //Verify the Heading of the Add Institution Pop-up Window
	public void verifyAddInstitutionModalTitle() throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		Assert.assertEquals(institutionsPage.verifyAddInstitutionModalTitle(), "Add Institution");
	}
	
	
	
	@Test (enabled=false)	// Verify that SuperAdmin can edit Institution -- COMPLETED
	public void verifyEditInstitutionTest() throws InterruptedException {
		institutionsPage.clickEditButton();
		driver.switchTo().defaultContent();
		institutionsPage.editInstitution();
		institutionsPage.clickUploadImage();
		Thread.sleep(4000);
		institutionsPage.clickSaveButton();
				
	}
	
	@Test (enabled=false)	// Verify that SuperAdmin can delete Institution -- COMPLETED
	public void verifyDeleteInstitutionTest() {
		institutionsPage.clickDeleteButton();
		driver.switchTo().defaultContent();
		institutionsPage.clickYesButton();
		
	}
	
	@Test(enabled=false)  //Verify that pagination is working if available -- COMPLETED
	public void verifyPagination() {
		institutionsPage.checkPaginationLink();
	}
	
	@Test(enabled=false)
	public void verifyInstitutionDetailsPopUpPageDisplayed() {
		institutionsPage.moveMouseOverInstitutionTitle();
		driver.switchTo().defaultContent();
		Assert.assertEquals(institutionsPage.verifyCheckCoursesButton(), true, "Institution Details Popup page is not displayed.");		
	
	}
	
	
	@Test()
	public void verifyInstitutionDetailsPopUpPageCheckCoursesButton() {
		institutionsPage.moveMouseOverInstitutionTitle();
		driver.switchTo().defaultContent();
		institutionsPage.clickCheckCourseButton();
		
	}
	
	

	

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
}
