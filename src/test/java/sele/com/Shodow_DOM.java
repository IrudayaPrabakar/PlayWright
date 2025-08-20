package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Shodow_DOM {

	public static void main(String[] args) {
		
		
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    Page page=browser.newPage();
	   page.navigate("https://selectorshub.com/xpath-practice-page/");
	   
//	   For the Showdow DOM xpath is not allowed, only the css locator
//	  Locator showdowDom= page.locator("div#userName");
//	  showdowDom.locator("#kils").fill("Jesua Mary");
//	  showdowDom.locator("#pizza").fill("Jesua pizza");
	
	  page.locator("#userName #kils").fill("Jesus");
	  page.locator("#userName #pizza").fill("Blessed Vigin Mary");
	  
	}
}
