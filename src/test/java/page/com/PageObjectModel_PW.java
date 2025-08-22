package page.com;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PageObjectModel_PW {
	
	@Test
	public void test() {
		
	
	Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	Page page=browser.newPage();
	
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	
	
	page.getByPlaceholder("Enter Email").fill("idayaofjesus2@gmail.com");
	page.getByPlaceholder("Enter Password").fill("Irudaya@143");
	
	page.waitForTimeout(2000);
	page.locator(".submit-btn").click();
	
	
	
	
	
	
	
	page.close();
	browser.close();
	
}
}