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

public class ContactUsPage extends TestBase {
	
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
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="message")
	WebElement message;
	
	@FindBy(xpath="//button[text()='Send Message']")
	WebElement sendMessageButton;
	
	
	//Initialising the Page Objects
	
	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String validateContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
	
	public LoginPage clickOnLoginPage() {
		loginLink.click();
		return new LoginPage();
	}
	
	public String verifyContactUsPageHeading() {
		return categoryTitle.getText();
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
