package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleSSLCertificates {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		

		NewContextOptions contextOption = new Browser.NewContextOptions();
		contextOption.setIgnoreHTTPSErrors(true);
		BrowserContext browserContext = browser.newContext(contextOption);

		Page page = browserContext.newPage();
		page.navigate("https://expired.badssl.com/");

		page.close();
		browser.close();
	}

}
