package com.emaua.testcases;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
	
	String sheetName = "Institutions";

	public InstitutionsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
		Thread.sleep(4000);
		institutionsPage = homePage.clickOnInstitutionsPage();
		Thread.sleep(4000);

	}
	
	@DataProvider
	public Object[][] getEmauaTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(enabled=false) // Verify the Institutions Page Title -- COMPLETED
	public void verifyInstitutionsPageTitleTest() {
		String institutionPageTitle = institutionsPage.validateInstitutionsPageTitle();
		Assert.assertEquals(institutionPageTitle, "Institutions :: Emaua", "Home page title does not match");
	}
	
	@Test(enabled=false) // Verify the Institutions Page Header -- COMPLETED
	public void verifyInstitutionsPageHeaderTest() {
		String institutionPageHeader = institutionsPage.validateInstitutionsPageHeader();
		Assert.assertEquals(institutionPageHeader, "Institutions", "Page Header does not match");
	}
	
	// Test Cases for Add Institution Functionality
	
	@Test(enabled=false)  //Verify the Heading of the Add Institution Pop-up Window -- COMPLETED
	public void verifyAddInstitutionModalTitle() throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		Assert.assertEquals(institutionsPage.verifyAddInstitutionModalTitle(), "Add Institution", "Add Institution Pop-up Window Header does not match");
	}
	
	
	@Test(enabled=false) // Verify that the save button is disabled  -- COMPLETED
	public void verifySaveButtonDisabled() throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		boolean buttonDisabled=institutionsPage.verifySaveButtonDisabled();
		Assert.assertEquals(buttonDisabled, true);
	}
	
	@Test(priority=1, dataProvider="getEmauaTestData")		//Verify that SuperAdmin can add a new Institution  -- COMPLETED
	public void verifyAddInstitutionButtonTest(String name, String description, String image, String warning) throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		institutionsPage.addNewInstitution(name, description, image, warning);
		Thread.sleep(4000);
		institutionsPage.clickSaveButton();
	}
	
	
	@Test (enabled=false)	// Verify that SuperAdmin can edit Institution -- COMPLETED
	public void verifyEditInstitutionTest() throws InterruptedException {
		institutionsPage.clickEditButton();
		driver.switchTo().defaultContent();
		institutionsPage.editInstitution();
		Thread.sleep(4000);
		institutionsPage.clickSaveButton();
				
	}
	
	@Test (enabled=false)	// Verify that SuperAdmin can delete Institution -- COMPLETED
	public void verifyDeleteInstitutionTest() {
		institutionsPage.clickDeleteButton();
		driver.switchTo().defaultContent();
		institutionsPage.clickYesButton();
		
	}
	
	@Test (enabled=false)	// Verify that SuperAdmin can click "No" on the delete confirmation page -- COMPLETED
	public void verifyCancelDeleteInstitutionTest() {
		institutionsPage.clickDeleteButton();
		driver.switchTo().defaultContent();
		institutionsPage.clickNoButton();
		
	}
	
	@Test(enabled=false)  //Verify that pagination is working if available -- COMPLETED
	public void verifyPagination() {
		institutionsPage.checkPaginationLink();
	}
	
	@Test(enabled=false)  //Verify that Institutions Details pop-up page is displayed  -- COMPLETED
	public void verifyInstitutionDetailsPopUpPageDisplayed() {
		institutionsPage.moveMouseOverInstitutionTitle();
		driver.switchTo().defaultContent();
		Assert.assertEquals(institutionsPage.verifyCheckCoursesButton(), true, "Institution Details Popup page is not displayed.");		
	
	}
	

	@Test(enabled=false)  //Verify that Courses can be viewed by clicking the "Check Courses" button -- COMPLETED
	public void verifyInstitutionDetailsPopUpPageCheckCoursesButton() {
		institutionsPage.moveMouseOverInstitutionTitle();
		driver.switchTo().defaultContent();
		institutionsPage.clickCheckCourseButton();
		
	}
	
	@Test(enabled=false) //verify the mandatory fields
	public void verifyMandatoryNameField() {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		institutionsPage.verifyMandatoryNameField();
		
	}
	
	@Test(enabled=false)  //Verify the broken links
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		institutionsPage.verifyBrokenLinks();
	}
	
	@Test(enabled=false)  // Verify the BreadCrumb -- COMPLETED
	public void verifyBreadCrumb() {
		institutionsPage.verifybreadCrumb();
		Assert.assertEquals(institutionsPage.verifybreadCrumb(), "Home/Institutions", "BreadCrumb does not match");
	}
	

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	
}
