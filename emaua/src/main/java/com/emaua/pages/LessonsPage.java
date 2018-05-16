package com.emaua.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;

public class LessonsPage extends TestBase{
	
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
	
	@FindBy(tagName="a")
	List<WebElement> linksList;
	
	@FindBy(tagName="img")
	List<WebElement> imgLinksList;
	
	@FindBy(xpath="//ol[@class='breadcrumb']//li")
	List<WebElement> listBreadCrumb;
	
	@FindBy(xpath="//a[contains(text(),'Add Lesson')]")
	WebElement addLessonButton;
	
	@FindBy(xpath="//a[contains(text(),'Share')]")
	WebElement shareButton;
	
	@FindBy(xpath="//a[contains(text(),'Options')]")
	WebElement optionsButton;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editButton;
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	WebElement deleteButton;

	@FindBy(xpath="//a[contains(text(),'Permissions')]")
	WebElement permissionsButton;
	
	@FindBy(xpath="//a[contains(text(),'Review')]")
	WebElement reviewButton;
	
	@FindBy(xpath="//a[contains(text(),'Watch')]")
	WebElement watchButton;
	
	@FindBy(xpath="//a[@class='page-link']") 
	List<WebElement> pagination;
	
	// Elements on the "Add Lesson" and "Edit Lesson" pop-up Pages
	// -------------------------------------------------------
	
	@FindBy(xpath="//button//span[text()='×']")
	WebElement crossButton;
	
	@FindBy(xpath="//h4[contains(@class, 'modal-title')]")
	WebElement modalTitle;
	
	@FindBy(xpath="//input[@id='videoUrl']")
	WebElement videoUrl;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath="//select[@id='teacherId']")
	WebElement teacherId;
	
	@FindBy(xpath="//select[@id='languageId']")
	WebElement languageId;
	
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

	
	//Initialising the Page Objects
	
	public LessonsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String validateLessonsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}

}
