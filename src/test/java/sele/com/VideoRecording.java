package sele.com;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {

	public static void main(String[] args) {
		Browser browser=Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context=browser.newContext(new Browser.NewContextOptions().setRecordVideoSize(1000, 800).setRecordVideoDir(Paths.get("Videos/")));
		Page page=context.newPage();
		page.navigate("https://freelance-learn-automation.vercel.app/login");
		
		page.waitForTimeout(3000);
		page.locator("#email1").fill("Jesus@gmail.com");
		page.waitForTimeout(2000);
		String path=page.video().path().toString();
		System.out.println("video recording to be checked at this point"+path);
		page.close();
		context.close();
	}

}
 