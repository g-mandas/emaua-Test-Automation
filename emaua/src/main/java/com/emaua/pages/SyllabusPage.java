package com.emaua.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;

public class SyllabusPage extends TestBase{
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
	
	@FindBy(xpath="//a[contains(text(),'Add Syllabus')]")
	WebElement addSyllabusButton;
	
	@FindBy(xpath="//a[contains(text(),'Share')]")
	WebElement shareButton;
	
	@FindBy(xpath="//a[contains(text(),'Options')]")
	WebElement optionsButton;
	
	// Elements on the "Add Syllabus" and "Edit Syllabus" Page
	// -------------------------------------------------------
	
	@FindBy(xpath="//input[contains(@id,'syllabus-title-')]")
	WebElement addSyllabusTextBox;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//a[text()='Save']")
	WebElement saveButton;
	
	//--------------------------------------------------------
	// Elements at Share Window
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@id='shareUrl']")
	WebElement shareUrl;

	
	//Initialising the Page Objects
	
	public SyllabusPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String validateSyllabusPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
}
