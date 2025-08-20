package sele.com;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyBoardActions {
	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();

		page.navigate("https://freelance-learn-automation.vercel.app/login");

		 page.locator("css=input[name='email1']").fill("idayaofjesus2@gmail.com");
		 
		 page.keyboard().press("Enter");
		
		 page.keyboard().press("Control+A");
		
		 page.keyboard().press("Control+C");
		
		 page.keyboard().press("Tab");
		 
		 page.keyboard().press("Control+V");
		
	
		browser.close();
		page.close();

	}
}
