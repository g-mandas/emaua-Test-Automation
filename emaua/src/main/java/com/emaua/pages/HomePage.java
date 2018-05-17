package com.emaua.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory or Object Repository - OR:
	
	@FindBy(xpath="//img[contains(@alt, 'logo')]")
	WebElement emauaLogo;
	
	@FindBy(xpath="//a[contains(text(),'Institutions')]")
	WebElement institutionsLink;
	
	@FindBy(xpath="//a[contains(text(),'Teachers')]")
	WebElement teachersLink;
	
	@FindBy(xpath="//a[contains(text(),'Courses')]")
	WebElement coursessLink;
	
	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement aboutUsLink;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
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
	
	@FindBy(tagName="a")
	List<WebElement> linksList;
	
	@FindBy(tagName="img")
	List<WebElement> imgLinksList;
	
	@FindBy(xpath="//ol[@class='breadcrumb']//li")
	List<WebElement> listBreadCrumb;
	
	
	//Initialising the Page Objects
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
	
	public InstitutionsPage clickOnInstitutionsPage() {
		institutionsLink.click();
		return new InstitutionsPage();
	}

	public TeachersPage clickOnTeachersPage() {
		teachersLink.click();
		return new TeachersPage();
	}

	public LoginPage clickOnLoginPage() {
		loginLink.click();
		return new LoginPage();	
	}
	
	public AboutPage clickOnAboutPage() {
		aboutUsLink.click();
		return new AboutPage();
	}

}
