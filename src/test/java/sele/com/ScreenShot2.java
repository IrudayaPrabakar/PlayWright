package sele.com;

import java.nio.file.Paths;
import java.util.Base64;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ScreenShot2 {

	public static void main(String[] args) throws InterruptedException {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
	    Page page=browser.newPage();
	   page.navigate("https://www.naukri.com/naukri360");
	   Thread.sleep(5000);
	
	   page.locator("(//img[@class='banner-img'])[1]").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("ParticularElement1.png")));
	   Utility.getScreenShot(page);
//	   To print or get the screenshot value in string
//	   System.out.println(Base64.getEncoder().encodeToString(screen));
//	   Thread.sleep(3000);
	   page.close();
	   browser.close();

	}

}
