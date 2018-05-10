package com.emaua.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;
import com.paulhammant.ngwebdriver.*;

public class InstitutionsPage extends TestBase {
	
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
	
//	@FindBy(xpath="//button[@class='ripple btn-ripple success popup-btn pull-right'][.='Add Institution']")
	@ByAngularButtonText.FindBy(buttonText="Add Institution")
	WebElement addInstitutionButton;
	
//	@ByAngularButtonText.FindBy(buttonText="Delete")
//	WebElement deleteButton;
	
//	@ByAngularButtonText.FindBy(buttonText="Edit")
//	WebElement editButton;
	
	@ByAngularButtonText.FindBy(buttonText="Save")
	WebElement saveButton;
	
	@ByAngularButtonText.FindBy(buttonText="Cancel")
	WebElement cancelButton;
	
	@ByAngularButtonText.FindBy(buttonText="Yes")
	WebElement yesButton;
	
	@ByAngularButtonText.FindBy(buttonText="No")
	WebElement noButton;
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	WebElement loginLink;
	 
	@FindBy(xpath="//a[@class='page-link']") 
	List<WebElement> pagination;
	
//	@ByAngularButtonText.FindBy(buttonText="Upload Image")
//	WebElement uploadImageButton;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="description")
	WebElement description;
	
	@FindBy(xpath="//*[@id='input-file']")
	WebElement uploadImageButton;
	
//	@FindBy(xpath="//a//parent::p[@class='item-caption']//following-sibling::button[text()='Edit']")
//	List<WebElement> institutionNamesOnPage;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]")
	WebElement institutionsName;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p[@class='item-caption']//following-sibling::button[text()='Edit']")
	WebElement editButton;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p[@class='item-caption']//following-sibling::button[text()='Delete']")
	WebElement deleteButton;
	
//	@FindBy(xpath="//p[@class='item-caption']//a")
//	List<WebElement> institutionName;
	
	@FindBy(xpath="//h4[@class='modal-title']")
	WebElement modalTitle;
	
	@FindBy(xpath="//a[text()='Check Courses']")
	WebElement checkCourseButton;
	
	//p[@class='item-caption']//a
	//Initialising the Page Objects
	
	public InstitutionsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateInstitutionsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
	
	public LoginPage clickOnLoginPage() {
		loginLink.click();
		return new LoginPage();
	}
	
	public InstitutionsPage clickAddInstitutionButton() {
		addInstitutionButton.click();
		return new InstitutionsPage();
	}
	
	public String verifyAddInstitutionModalTitle() {
		return modalTitle.getText();
		
	}
	
	
	public InstitutionsPage clickUploadImageButton() {
		uploadImageButton.click();
		return new InstitutionsPage();
	}
	
	public InstitutionsPage addNewInstitution() {
		name.clear();
		name.sendKeys("1Test Institution");
		description.clear();
		description.sendKeys("Details about the Test Institution bla bla bla");
		return new InstitutionsPage();
		
	}
	
	public void clickUploadImage() {
		uploadImageButton.sendKeys("C:\\BusinessCard.GIF");
	}
	
	public InstitutionsPage clickEditButton() {
		editButton.click();
		return new InstitutionsPage();
		
	}
	
	public InstitutionsPage clickDeleteButton() {
		deleteButton.click();
		return new InstitutionsPage();
		
	}
	
	public InstitutionsPage clickSaveButton() {
		saveButton.click();
		return new InstitutionsPage();
		
	}
	
	public InstitutionsPage clickCancelButton() {
		cancelButton.click();
		return new InstitutionsPage();
		
	}
	
	public InstitutionsPage clickYesButton() {
		yesButton.click();
		return new InstitutionsPage();
		
	}
	
	public InstitutionsPage clickNoButton() {
		noButton.click();
		return new InstitutionsPage();
		
	}
	
	public void clickCheckCourseButton() {
		checkCourseButton.click();
		
	}
	
	public InstitutionsPage checkPaginationLink() {
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
		return new InstitutionsPage();
	}

	public InstitutionsPage editInstitution() {
		name.clear();
		name.sendKeys("1Test Institution Updated");
		description.clear();
		description.sendKeys("Details about the Test Institution updated");
		return new InstitutionsPage();
	}
	
	public void moveMouseOverInstitutionTitle() {
		actions.moveToElement(institutionsName).build().perform();
	}
	
	public boolean verifyCheckCoursesButton() {
		return checkCourseButton.isDisplayed();
		
	}

}
