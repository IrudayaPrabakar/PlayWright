package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Sliders {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/slider/");

		FrameLocator frameLocator = page.frameLocator(".demo-frame");
		Locator slider = frameLocator
				.locator("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]");
		slider.focus();

		for (int i = 0; i < 10; i++) {
			page.keyboard().press("ArrowRight");
			
			page.close();
			browser.close();

		}

	}

}
