package com.emaua.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;

public class SubjectsPage extends TestBase{

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
	
	@FindBy(xpath="//a[contains(text(),'Add Subject')]")
	WebElement addSubjectButton;
	
	@FindBy(xpath="//a[contains(text(),'Share')]")
	WebElement shareButton;
	
	@FindBy(xpath="//a[contains(text(),'Options')]")
	WebElement optionsButton;
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	WebElement deleteButton;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editButton;
	
	@FindBy(xpath="//a[contains(text(),'Pre-Requisites')]")
	WebElement prerequisitesButton;
	
	@FindBy(xpath="//a[contains(text(),'Permissions')]")
	WebElement permissionsButton;
	
	@FindBy(xpath="//a[contains(text(),'Review')]")
	WebElement reviewButton;
	
	@FindBy(xpath="//a[contains(text(),'Watch')]")
	WebElement watchButton;
	
	@FindBy(xpath="//a[@class='page-link']") 
	List<WebElement> pagination;
	
	// Elements on the "Add Subject" and "Edit Subject" pop-up Pages
	// -------------------------------------------------------
	
	@FindBy(xpath="//button//span[text()='×']")
	WebElement crossButton;
	
	@FindBy(xpath="//h4[contains(@class, 'modal-title')]")
	WebElement modalTitle;
	
	@FindBy(xpath="//input[@id='input-file']")
	WebElement uploadImageButton;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//input[@id='subject-tags']")
	WebElement subjectTag;
	
	@FindBy(xpath="//select[@id='periodId']")
	WebElement periodId;
	
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
	
	
	//--------------------------------------------------------
	// Elements at Share Window
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@id='shareUrl']")
	WebElement shareUrl;
	
	//--------------------------------------------------------
	// Elements at Pre-Requisites pop-up window
	
	@FindBy(xpath="//button[@id='add-children']")
	WebElement transferButton;
	
	@FindBy(xpath="//button[text()='Done']")
	WebElement doneButton;
	
	
	//--------------------------------------------------------
	// Elements at Permissions pop-up window

	@FindBy(xpath="//select[@id='role']")
	WebElement role;
	
	
	//Initialising the Page Objects
	
	public SubjectsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String validateSubjectsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
}
