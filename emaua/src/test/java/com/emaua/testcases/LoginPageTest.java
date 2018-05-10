package com.emaua.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emaua.base.TestBase;
import com.emaua.pages.HomePage;
import com.emaua.pages.LoginPage;
import com.emaua.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		loginPage = homePage.clickOnLoginPage();
	}
	
	@Test(enabled=false)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "User Authorization :: Emaua");
	}
	
	@Test(enabled=false)
	public void emauaLogoTest() {
		boolean flag = loginPage.validateEmauaLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(enabled=false)
	public void validateInvalidLinks() {

		try {
			int invalidLinksCount = 0;
			List<WebElement> anchorTagsList = driver.findElements(By
					.tagName("img"));
			System.out.println("Total no. of links are "
					+  anchorTagsList.size());
			for (WebElement anchorTagElement : anchorTagsList) {
				if (anchorTagElement != null) {
					String url = anchorTagElement.getAttribute("href");
					if (url != null && !url.contains("javascript")) {
						loginPage.verifyURLStatus(url);
					} else {
						invalidLinksCount++;
					}
				}
			}

			System.out.println("Total no. of invalid links are "
					+ invalidLinksCount);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	

}
