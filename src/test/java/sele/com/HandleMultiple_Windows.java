package sele.com;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleMultiple_Windows {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");

		Locator alllinks = page.locator("//div[@class='social']//a");
		for (int i = 0; 1 < alllinks.count(); i++) {
			alllinks.nth(i).click();
		}
		List<Page> allPages = context.pages();

		for (Page p : allPages) {

			String title = p.title();
			if (title.contains("Facebook")) {
				p.bringToFront();

				p.locator("//input[@name='email']").last().fill("");

				break;
			}
		}
		page.bringToFront();
		page.getByPlaceholder("Enter Email").fill("selenium@gmail.com");
		context.close();
		browser.close();

	}

}
