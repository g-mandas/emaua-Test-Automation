package com.emaua.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;

public class TeachersPage extends TestBase{
	
	org.openqa.selenium.interactions.Actions builder;
	
	//Page Factory or Object Repository - OR:
	
	@FindBy(xpath="//img[contains(@alt, 'logo')]")
	WebElement emauaLogo;
	
	@FindBy(xpath="//a[contains(text(),'Institutions')]")
	WebElement institutionsLink;
	
	@FindBy(xpath="//a[contains(text(),'Teachers')]")
	WebElement teachersLink;
	
	@FindBy(xpath="//a[contains(text(),'Courses')]")
	WebElement coursessLink;
	
	@FindBy(xpath="//a[contains(text(),'AboutUs')]")
	WebElement aboutUsLink;
	
	@FindBy(xpath="//a[contains(text(),'Contact')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	WebElement loginLink;
	
	@FindBy(xpath="//button//span[text()='Areas']")
	WebElement areasButton;
	
	@FindBy(xpath="//button[@class='search-button ripple']")
	WebElement searchButton;
	
	@FindBy(xpath="//button[text()='Clear Filters']")
	WebElement clearFiltersButton;
	
	@FindBy(xpath="//p[@class='category-title']")
	WebElement categoryTitle;
	
	@FindBy(xpath="//a[@class='page-link']") 
	List<WebElement> pagination;
	
	@FindBy(tagName="a")
	List<WebElement> linksList;
	
	@FindBy(tagName="img")
	List<WebElement> imgLinksList;
	
	@FindBy(xpath="//ol[@class='breadcrumb']//li")
	List<WebElement> listBreadCrumb;
	
	@FindBy(xpath="//a[contains(text(),'Add Teacher')]")
	WebElement addTeacherButton;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editButton;
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	WebElement deleteButton;
	
	// Elements on the "Add Teacher" and "Edit Teacher" pop-up Pages
	// -------------------------------------------------------
	
	@FindBy(xpath="//button//span[text()='×']")
	WebElement crossButton;
	
	@FindBy(xpath="//h4[contains(@class, 'modal-title')]")
	WebElement modalTitle;
	
	@FindBy(xpath="//input[@id='input-file']")
	WebElement uploadImageButton;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//select[@id='institutionId']")
	WebElement teacherInstitutionId;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	//-----------------------------------------------------------
	// Elements at Delete Confirmation Window
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement yesButton;
	
	@FindBy(xpath="//button[text()='No']")
	WebElement noButton;
	
	
	// Elements on the "Teacher Information" pop-up window 
	//--------------------------------------------------
	
	@FindBy(xpath="//a[contains(text(),'Check Courses')]")
	WebElement checkCourseButton;
	
	@FindBy(xpath="//p[contains(@class, 'category-title')]")
	WebElement teachersPageHeading;
	
	@FindBy(xpath="//a[contains(text(),'Anders Hejlsberg')]")
	WebElement teacherName;

	
	//Initialising the Page Objects
	
	public TeachersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
	
	public LoginPage clickOnLoginPage() {
		loginLink.click();
		return new LoginPage();
	}
	
	public TeachersPage clickAddTeacherButton() {
		addTeacherButton.click();
		return new TeachersPage();
	}
	
	public String verifyAddTeacherModalTitle() {
		return modalTitle.getText();	
	}
	
	public TeachersPage clickUploadImageButton() {
		uploadImageButton.click();
		return new TeachersPage();
	}
	
	public TeachersPage addNewInstitution() {
		name.clear();
		name.sendKeys("1Test Institution");
		description.clear();
		description.sendKeys("Details about the Test Institution bla bla bla");
		return new TeachersPage();
		
	}
	
	public void clickUploadImage() {
		uploadImageButton.sendKeys("C:\\BusinessCard.GIF");
	}
	
	public TeachersPage addNewTeacher(String tName, String tTitle, String tInstitution, String tDescription, String tImage, String tWarning) {
		name.clear();
		name.sendKeys(tName);
		title.clear();
		title.sendKeys(tTitle);
		teacherInstitutionId.clear();
		teacherInstitutionId.sendKeys(tInstitution);
		description.clear();
		description.sendKeys(tDescription);
	//	if(!instImage.equals("null")) {
			uploadImageButton.sendKeys(tImage);	
//		}
	//	else {
	//		uploadImageButton.sendKeys(Keys.TAB);
	//	}
		
		return new TeachersPage();
		
	}
	
	public TeachersPage clickEditButton() {
		editButton.click();
		return new TeachersPage();
		
	}
	
	public TeachersPage clickDeleteButton() {
		deleteButton.click();
		return new TeachersPage();
		
	}
	
	public TeachersPage clickSaveButton() {
		saveButton.click();
		return new TeachersPage();
		
	}
	
	public boolean verifySaveButtonDisabled() {
		return saveButton.isDisplayed();
		
	}
	
	public TeachersPage clickCancelButton() {
		cancelButton.click();
		return new TeachersPage();
		
	}
	
	public TeachersPage clickYesButton() {
		yesButton.click();
		return new TeachersPage();
		
	}
	
	public TeachersPage clickNoButton() {
		noButton.click();
		return new TeachersPage();
		
	}
	
	public void clickCheckCourseButton() {
		checkCourseButton.click();
		
	}
	
	public TeachersPage checkPaginationLink() {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0,800)");
		int numberOfPages = pagination.size();
		System.out.println(numberOfPages);
	//	System.out.println((WebElement) pagination);
		if(numberOfPages>0) {
			//actions.moveToElement((WebElement) pagination);
			
			System.out.println("Pagination Exists");
			for(int i=0;i<numberOfPages;i++) {
			//	System.out.println("number of inst on this page " +institutionNamesOnPage.size());
			//		for (int j=0; j<institutionNamesOnPage.size();j++) {
			//			//System.out.println(institutionNamesOnPage.get(j));
			//			if 
			//		}
				pagination.get(i).click();
				
			}
		} else {
			System.out.println("Pagination not exists");
		}
		return new TeachersPage();
	}

	public TeachersPage editInstitution() {
		name.clear();
		name.sendKeys("1Test Institution Updated");
		description.clear();
		description.sendKeys("Details about the Test Institution updated");
		return new TeachersPage();
	}
	
	public void moveMouseOverInstitutionTitle() {
		actions.moveToElement(teacherName).build().perform();
	}
	
	public boolean verifyCheckCoursesButton() {
		return checkCourseButton.isDisplayed();
		
	}

	
	public CoursesPage clickOnCheckCoursesButton() {
		org.openqa.selenium.interactions.Actions builder;
		builder = new org.openqa.selenium.interactions.Actions(driver);
    //	JavascriptExecutor js = ((JavascriptExecutor)driver);
    //	js.executeScript("arguments[0].scrollIntoView(true);", teacherName);	
		builder.moveToElement(teacherName).build().perform();
		checkCourseButton.click();
		return new CoursesPage();
				
	}
	
	public void addTeacher(String name2, String title2) {
		name.sendKeys(name2);
		title.sendKeys(title2);
		
	}


	public String verifyTeachersPageHeading() {
			return categoryTitle.getText();
	}

	public TeachersPage verifyMandatoryNameField() {
		name.clear();
		name.sendKeys(Keys.TAB);
		title.clear();
		title.sendKeys(Keys.TAB);
		teacherInstitutionId.clear();
		teacherInstitutionId.sendKeys(Keys.TAB);
		description.clear();
		description.sendKeys(Keys.TAB);
		return new TeachersPage();
	
	}
	
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		linksList.addAll(imgLinksList);
		System.out.println("size of full links and images --->"+linksList.size());
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for(int i=0; i<linksList.size(); i++) {
			System.out.println(linksList.get(i).getAttribute("href"));
			if(linksList.get(i).getAttribute("href") !=null && (! linksList.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(linksList.get(i));
				
			}
		}
		for(int j=0; j<activeLinks.size(); j++) {
			
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();  //ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") +"--->"+response);
			
		}
	}
	
	public String verifybreadCrumb() {
		System.out.println(listBreadCrumb.size());
		String breadCrumb ="";
		for(int i=0; i<listBreadCrumb.size(); i++) {
			if(i==0) {
				breadCrumb = listBreadCrumb.get(i).getText();
			} else {
			System.out.println(listBreadCrumb.get(i).getText());
			breadCrumb = breadCrumb+"/"+listBreadCrumb.get(i).getText();	
			}		
		}
		return breadCrumb;
	}
	
}
