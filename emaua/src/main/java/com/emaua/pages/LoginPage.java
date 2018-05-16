package com.emaua.pages;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.emaua.pages.HomePage;
import com.emaua.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository - OR [Object Repository]:

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
	
	@FindBy(tagName="a")
	List<WebElement> linksList;
	
	@FindBy(tagName="img")
	List<WebElement> imgLinksList;
	
	@FindBy(xpath="//ol[@class='breadcrumb']//li")
	List<WebElement> listBreadCrumb;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='pull-right ripple btn-ripple success default'][.='Log In']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[contains(text(),'Registration')")
	WebElement registrationButton;
	
	@FindBy(xpath="//a[@class='fb soc']")
	WebElement facebookButton;
	
	@FindBy(xpath="//a[@class='g soc']")
	WebElement googleButton;
	
	@FindBy(xpath="//a[@class='tw soc']")
	WebElement twitterButton;
	
	@FindBy(xpath="//a[@class='lin soc']")
	WebElement linkedinButton;
	
	@FindBy(tagName ="img") 
	List<WebElement> links;
	
	@FindBy(xpath="//div[@class='alert alert-info']")
	WebElement authenticationFailed;

	
	//Initialising the Page Objects
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}


	//Actions:
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateEmauaLogo() {
		return emauaLogo.isDisplayed();
	}
	
	public String getinvalidLoginText() {
		return authenticationFailed.getText();
	}
	
	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
    	JavascriptExecutor js = ((JavascriptExecutor)driver);
    	js.executeScript("arguments[0].click();", loginButton);	
    	
    	return new HomePage();  // returns the next landing page object
	}
	
	public void verifyURLStatus(String URL) {

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		try {
			HttpResponse response = client.execute(request);
			// verifying response code and The HttpStatus should be 200 if not,
			// increment invalid link count
			////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
			if (response.getStatusLine().getStatusCode() != 200) {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}