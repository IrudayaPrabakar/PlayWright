package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class WaitForPage {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");

		Page newPage = context.waitForPage(() -> {

			page.locator("//a[contains(@href,'facebook')]").first().click();
		});

		newPage.locator("//input [@name='email']").last().fill("Irudaya@gmail.com");

		page.bringToFront();

		newPage.bringToFront();

		page.bringToFront();
		newPage.bringToFront();
		newPage.close();
		page.close();
		context.close();
		browser.close();

	}

}
