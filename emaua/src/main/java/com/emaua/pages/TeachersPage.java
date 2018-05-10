package com.emaua.pages;

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
	
	@FindBy(xpath="//a[contains(text(),'Anders Hejlsberg')]")
	WebElement teacherName;
	
	@FindBy(xpath="//a[contains(text(),'Check Courses')]")
	WebElement checkCoursesButton;
	
	@FindBy(xpath="//a[contains(text(),'Add Teacher')]")
	WebElement addTeacherButton;
	
	@FindBy(xpath="//a[contains(text(),'Edit')]")
	WebElement editTeacherButton;
	
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	WebElement deleteTeacherButton;
	
	@FindBy(xpath="//p[contains(@class, 'category-title')]")
	WebElement teachersPageHeading;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="title")
	WebElement title;

	
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
	
	public CoursesPage clickOnCheckCoursesButton() {
		org.openqa.selenium.interactions.Actions builder;
		builder = new org.openqa.selenium.interactions.Actions(driver);
    //	JavascriptExecutor js = ((JavascriptExecutor)driver);
    //	js.executeScript("arguments[0].scrollIntoView(true);", teacherName);	
		builder.moveToElement(teacherName).build().perform();
		checkCoursesButton.click();
		return new CoursesPage();
				
	}
	
	public void clickOnAddTeacherButton() {
		addTeacherButton.click();
	}
	
	public void addTeacher(String name2, String title2) {
		name.sendKeys(name2);
		title.sendKeys(title2);
		
	}
	
	public LoginPage clickOnLoginPage() {
		loginLink.click();
		return new LoginPage();
		
	}

	public boolean verifyTeachersPageHeading() {
			return teachersPageHeading.isDisplayed();
	}

	
}
