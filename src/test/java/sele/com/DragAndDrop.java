package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DragAndDrop {

	public static void main(String[] args) {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		Page page = browser.newPage();
		page.navigate("https://jqueryui.com/droppable/");

		FrameLocator frameLocator = page.frameLocator(".demo-frame");

//		Normal approach
//		frameLocator.locator("#draggable").dragTo(frameLocator.locator("#droppable"));

//	Keyboard manual approach
		frameLocator.locator("#draggable").hover();
		page.mouse().down();
		frameLocator.locator("#droppable").hover();
		page.mouse().up();

		page.close();
		browser.close();

	}

}
