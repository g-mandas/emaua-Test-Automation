package com.emaua.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;

public class TopicsPage extends TestBase{
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
	
	@FindBy(xpath="//a[contains(text(),'Add Topic')]")
	WebElement addTopicButton;
	
	// Elements on the "Add Topic" and "Edit Topic" pop-up Pages
	// -------------------------------------------------------
	
	@FindBy(xpath="//input[@id='topic-title-1']")
	WebElement topicTitle;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	

	
	//Initialising the Page Objects
	
	public TopicsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateTopicsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
}
