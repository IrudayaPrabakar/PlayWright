package sele.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CrossBrowsingTest {
	Browser browser;
	Page page;
	Playwright pw;
	
	@Parameters("BrowserName")
	@BeforeMethod
	public void setUp(@Optional("Chrome") String browserName) {
		
		 pw=Playwright.create();
		BrowserType browserType=null;
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			 browserType=pw.chromium();
			
		}
		else if (browserName.equalsIgnoreCase("FireFox")) {
			 browserType=pw.firefox();
		}
		
       else if (browserName.equalsIgnoreCase("Safari")) {
    	    browserType=pw.webkit();
		}
		
		 browser=browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		
		page= browser.newPage();
			
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		Thread.sleep(3000);
		System.out.println(page.title());

	}
	
	@AfterMethod
	public void tearDown() {
		page.close();
		browser.close();
		pw.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
