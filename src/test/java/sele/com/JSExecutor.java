package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class JSExecutor {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
//	   default time is 30 seconds
		page.navigate("https://login.yahoo.com/");
				
		System.out.println(page.locator("#persistent").boundingBox().height);
		
		System.out.println(page.locator("#persistent").boundingBox().width);
		
//		page.evaluate("document.getElementById('persistent').click()");
		
		Locator checkBox=page.locator("#persistent");
		checkBox.evaluate("checkBox => checkBox.click()");
		
		page.close();
		browser.close();

	}

}
