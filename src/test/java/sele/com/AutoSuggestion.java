package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoSuggestion {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();

		page.navigate("https://www.google.com/");
		page.locator("//textarea[@role='combobox']").fill("Mukesh Otwani ");

		Locator locator = page.locator("//ul[@role='listbox']//li");

		System.out.println(locator.count());
		for (int i = 0; i < locator.count(); i++) {

//			Print the text
//			String text = locator.nth(i).textContent();
			
//			print the inner text
			String text = locator.nth(i).innerText();
//			System.out.println(text);

//			using this if condition to navigate to one of the listed count list
			if(text.contains("github")) {
				locator.nth(i).click();
				break;
			}
		}
		page.close();
		browser.close();
	}

}
