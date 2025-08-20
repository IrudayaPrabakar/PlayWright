package sele.com;

import java.util.regex.Pattern;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VerifyText_PlayWrignt {
 public static void main(String[] args) {
	
Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	 Page page=browser.newPage();
	 
	 page.navigate("https://freelance-learn-automation.vercel.app/login");
	 page.locator(".submit-btn").click();
	 
	 PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email and Password is required");
//	 PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText("Email is required");

//	 To verify the negative scenario
//	 PlaywrightAssertions.assertThat(page.locator(".errorMessage")).containsText(Pattern.compile("Email"));

//		System.out.println("error message" + actual);
		


	page.waitForTimeout(2000);
	browser.close();
	page.close();
	
}
}
