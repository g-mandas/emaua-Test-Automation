package com.emaua.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.base.TestBase;

public class CoursesPage extends TestBase {
	
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
	
	@FindBy(tagName="a")
	List<WebElement> linksList;
	
	@FindBy(tagName="img")
	List<WebElement> imgLinksList;
	
	@FindBy(xpath="//ol[@class='breadcrumb']//li")
	List<WebElement> listBreadCrumb;
	
	@FindBy(xpath="//button[text()='Add course']")
	WebElement addCourseButton;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]")
	WebElement courseName;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p//parent::div//preceding-sibling::div//a[@id='simple-dropdown-course']")
	WebElement gear;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p//parent::div//preceding-sibling::div//a[text()='Share']")
	WebElement gearShare;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p//parent::div//preceding-sibling::div//a[text()='Delete']")
	WebElement gearDelete;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p//parent::div//preceding-sibling::div//a[text()='Edit']")
	WebElement gearEdit;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p//parent::div//preceding-sibling::div//a[text()='Subjects']")
	WebElement gearSubjects;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p//parent::div//preceding-sibling::div//a[text()='Permissions']")
	WebElement gearPermissions;
	
	@FindBy(xpath="//a[contains(text(),'1Test')]//parent::p//parent::div//preceding-sibling::div//a[text()='Add Subject']")
	WebElement gearAddSubject;
	
	// Elements at "Add Course" and "Edit Course" pop-up Pages
	// -------------------------------------------------------
	
	@FindBy(xpath="//button//span[text()='×']")
	WebElement crossButton;
	
	@FindBy(xpath="//h4[contains(@class, 'modal-title')]")
	WebElement modalTitle;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement courseTitle;
	
	@FindBy(xpath="//input[@id='input-file']")
	WebElement uploadImageButton;
	
	@FindBy(xpath="//input[@id='']")
	WebElement courseTag;
	
	@FindBy(xpath="//input[@id='code']")
	WebElement courseCode;
	
	@FindBy(xpath="//select[@id='areaId']")
	WebElement courseAreaId;
	
	@FindBy(xpath="//select[@id='institutionId']")
	WebElement courseInstitutionId;
	
	@FindBy(xpath="//select[@id='languageId']")
	WebElement courseLanguageId;
	
	@FindBy(xpath="//textarea[@id='description']")
	WebElement courseDescription;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	
	//--------------------------------------------------------
	// Elements at Share Window
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeButton;
	
	@FindBy(xpath="//input[@id='shareUrl']")
	WebElement shareUrl;
	
	
	//-----------------------------------------------------------
	// Elements at Delete Confirmation Window
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement yesButton;
	
	@FindBy(xpath="//button[text()='No']")
	WebElement noButton;
	
	
	//-----------------------------------------------------------
	// Elements at Manage Subjects Window
	
	@FindBy(xpath="//button[text()='Done']")
	WebElement doneButton;
	
	@FindBy(xpath="//button[@id='add-children']")
	WebElement addChildrenButton;
	
	//-----------------------------------------------------------
	
	// Elements at Permissions Window
	
	@FindBy(xpath="//button[@id='role']")
	WebElement selectRole;
	
	
	
	//-----------------------------------------------------------
	
	// Elements at Add Subject Window
	
	@FindBy(xpath="//select[@id='periodId']")
	WebElement coursePeriodId;
	
	//-----------------------------------------------------------

	
	//Initialising the Page Objects
	
	public CoursesPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String validateCoursesPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
	
	public String verifyCoursesPageHeading() {
		return categoryTitle.getText();
}
	
	public CoursesPage clickClearFiltersButton() {
		clearFiltersButton.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickAddCourseButton() {
		addCourseButton.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickGear() {
		gear.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickGearShare() {
		gearShare.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickGearDelete() {
		gearDelete.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickGearEdit() {
		gearEdit.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickGearSubjects() {
		gearSubjects.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickGearPermissions() {
		gearPermissions.click();
		return new CoursesPage();
	}
	
	public CoursesPage clickGearAddSubject() {
		gearAddSubject.click();
		return new CoursesPage();
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
