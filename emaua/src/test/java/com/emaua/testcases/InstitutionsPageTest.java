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
	
	String sheetName1 = "InstitutionsWarning";
	String sheetName2 = "Institutions";

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
	
	@DataProvider(name = "getEmauaTestData")
	public Object[][] getEmauaTestData() {
		Object data[][] = TestUtil.getTestData(sheetName1);
		return data;
	}
	
	@DataProvider(name = "getEmauaTestData2")
	public Object[][] getEmauaTestData2() {
		Object data[][] = TestUtil.getTestData(sheetName2);
		return data;
	}
	
	@Test() // Verify the Institutions Page Title
	public void verifyInstitutionsPageTitleTest() {
		String institutionPageTitle = institutionsPage.validateInstitutionsPageTitle();
		Assert.assertEquals(institutionPageTitle, "Institutions :: Emaua", "Home page title does not match");
	}
	
	@Test() // Verify the Institutions Page Header 
	public void verifyInstitutionsPageHeaderTest() {
		String institutionPageHeader = institutionsPage.validateInstitutionsPageHeader();
		Assert.assertEquals(institutionPageHeader, "Institutions", "Page Header does not match");
	}
	
	// Test Cases for Add Institution Functionality
	
	@Test()  //Verify the Header of the Add Institution Pop-up Window -- COMPLETED
	public void verifyAddInstitutionModalTitle() throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		Assert.assertEquals(institutionsPage.verifyAddInstitutionModalTitle(), "Add Institution", "Add Institution Pop-up Window Header does not match");
	}
	
	
	@Test() // Verify that the save button is disabled
	public void verifySaveButtonDisabled() throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		boolean buttonDisabled=!institutionsPage.isSaveButtonEnabled();
		Assert.assertEquals(buttonDisabled, true);
	}
	
	@Test(priority=1, dataProvider="getEmauaTestData")		//Verify the warning messages on form
	public void verifyWarningMessages(String name, String description, String image, String warning) throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		institutionsPage.addNewInstitution(name, description, image, warning);
		Thread.sleep(4000);
		Assert.assertEquals(institutionsPage.getWarningMessage(), warning, "Warning message does not match");
		institutionsPage.clickSaveButton();
	}
	
	
	@Test (priority=1, dataProvider="getEmauaTestData2")	// Verify that SuperAdmin can add a new Institution
	public void verifyAddInstitution(String name, String description, String image, String warning) throws InterruptedException {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		institutionsPage.addNewInstitution(name, description, image, warning);
		Thread.sleep(4000);
		Assert.assertTrue(institutionsPage.isSaveButtonEnabled(), "Not all mandatory fields are completed");
		institutionsPage.clickSaveButton();
		
	}
	
	@Test()	// Verify that SuperAdmin can edit Institution
	public void verifyEditInstitutionTest() throws InterruptedException {
		institutionsPage.clickEditButton();
		driver.switchTo().defaultContent();
		institutionsPage.editInstitution();
		Thread.sleep(4000);
		institutionsPage.clickSaveButton();
				
	}
	
	@Test()	// Verify that SuperAdmin can delete Institution -- COMPLETED
	public void verifyDeleteInstitutionTest() {
		institutionsPage.clickDeleteButton();
		driver.switchTo().defaultContent();
		institutionsPage.clickYesButton();
		
	}
	
	@Test ()	// Verify that SuperAdmin can click "No" on the delete confirmation page -- COMPLETED
	public void verifyCancelDeleteInstitutionTest() {
		institutionsPage.clickDeleteButton();
		driver.switchTo().defaultContent();
		institutionsPage.clickNoButton();
		
	}
	
	@Test()  //Verify that pagination is working if available -- COMPLETED
	public void verifyPagination() {
		institutionsPage.checkPaginationLink();
	}
	
	@Test()  //Verify that Institutions Details pop-up page is displayed  -- COMPLETED
	public void verifyInstitutionDetailsPopUpPageDisplayed() {
		institutionsPage.moveMouseOverInstitutionTitle();
		driver.switchTo().defaultContent();
		Assert.assertEquals(institutionsPage.verifyCheckCoursesButton(), true, "Institution Details Popup page is not displayed.");		
	
	}
	

	@Test()  //Verify that Courses can be viewed by clicking the "Check Courses" button -- COMPLETED
	public void verifyInstitutionDetailsPopUpPageCheckCoursesButton() {
		institutionsPage.moveMouseOverInstitutionTitle();
		driver.switchTo().defaultContent();
		institutionsPage.clickCheckCourseButton();
		
	}
	
	@Test() //verify the mandatory fields
	public void verifyMandatoryNameField() {
		institutionsPage.clickAddInstitutionButton();
		driver.switchTo().defaultContent();
		institutionsPage.verifyMandatoryNameField();
		
	}
	
	@Test()  //Verify the broken links
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		institutionsPage.verifyBrokenLinks();
	}
	
	@Test()  // Verify the BreadCrumb -- COMPLETED
	public void verifyBreadCrumb() {
		institutionsPage.verifybreadCrumb();
		Assert.assertEquals(institutionsPage.verifybreadCrumb(), "Home/Institutions", "BreadCrumb does not match");
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
