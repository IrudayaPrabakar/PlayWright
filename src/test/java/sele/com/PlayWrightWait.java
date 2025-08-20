package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class PlayWrightWait {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		Page page = browser.newPage();
//	   default time is 30 seconds
		page.navigate("https://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html",
				new Page.NavigateOptions().setTimeout(6000));
// go for the below timeout without calling the navigateOptions
//	    page.setDefaultNavigationTimeout(3000);

//	    this timeout for the default timeout for all the elements.

		page.setDefaultTimeout(5000);

		page.locator("//button[text()='Click me to start timer']").click();

//		In case, If some elements is required more 
//	    wait than we can use the below wait script.

		page.locator("//p[text()='WebDriver']")
				.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(20000));
		System.out.println("Is this visble?" + page.locator("//p[text()='WebDriver']").isVisible());

//		 this method is not mandatory by default playwright will take the wait
		page.waitForLoadState(LoadState.NETWORKIDLE);
		
		page.close();
		browser.close();

	}

}
