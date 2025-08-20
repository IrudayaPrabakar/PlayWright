package sele.com;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VerifyText {
 public static void main(String[] args) {
	
Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	 Page page=browser.newPage();
	 
	 page.navigate("https://freelance-learn-automation.vercel.app/login");
	 page.locator(".submit-btn").click();
	 
		String expected = "Email and Password is required";
		String actual = page.locator(".errorMessage").textContent();
//		System.out.println("error message" + actual);
		
//		TestNg
		Assert.assertEquals(actual, expected);
		Assert.assertTrue(actual.contains("Email is required"));

	/*
	 * String innerMeg= page.locator(".errorMessage").innerText();
	 * System.out.println("error message via inner Meg"+innerMeg);
	 * 
	 * String JSMeg= (String) page.evaluate(
	 * "document.getElementsByClassName('errorMessage')[0].textContent");
	 * System.out.println("error message via Java Script"+JSMeg);
	 */
	browser.close();
	page.close();
	
}
}
