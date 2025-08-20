package sele.com;

import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class Login_TestNg {
	
	@Test
	public void LoginTestNG() {
		
		Browser browser = null;
		Page page = null;
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));

			page = browser.newPage();
			page.navigate("https://freelance-learn-automation.vercel.app/login");

//	 To verify the tittle mismatch
//	 PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses idaya");
			
//			PlaywrightAssertions.assertThat(page).hasTitle("Learn Automation Courses");
			Assert.assertTrue(page.title().contains("Learn Automation Courses"));

//	 when you pass the negative loctaor it will wait for the 5s
//	 page.locator("#irudaya").fill("idayaofjesus2@gmail.com");

//	 page.locator("#email1").fill("idayaofjesus2@gmail.com");

//	 page.locator("xpath=//input[@name='email1']").fill("idayaofjesus2@gmail.com");

			// css selector
	 page.locator("css=input[name='email1']").fill("idayaofjesus2@gmail.com");

//			page.getByPlaceholder("Enter Email").fill("idayaofjesus2@gmail.com");
			page.getByPlaceholder("Enter Password").fill("Irudaya@1435");

//			page.locator("xpath=//button[@type='submit']").click();
			

//     page.getByText("Sign in").nth(1).click();	
			page.getByText("Sign in").last().click();
			
			PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");
			
			
			page.locator("css=img[src='/static/media/burger-menu.93a4e66d6d393af53ac4ed46e5193397.svg']").click();
//			page.getByAltText("menu").click();
			page.getByText("Sign out").click();
			
			PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
			
			

			// debug wait but we can't use this in real time
	 page.waitForTimeout(3000);

		}

		finally {

			browser.close();
			page.close();

		}
	}
}