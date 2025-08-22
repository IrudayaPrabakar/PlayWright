package page.com;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestUsingPOM2 {

	@Test
	public void test() {
		
	
	Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
	Page page=browser.newPage();
	
	page.navigate("https://freelance-learn-automation.vercel.app/login");
	
	LoginPage loginPage=new LoginPage(page);
	loginPage.logInToApplication("idayaofjesus2@gmail.com","Irudaya@143");
	
	
	}
	
}
