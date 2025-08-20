package sele.com;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;

public class PlayWright {
	public static void main(String[] args) {
		Playwright pl = Playwright.create();
		BrowserType browse = pl.chromium();
//		BrowserType browse = pl.firefox();
//		BrowserType browse = pl.webkit();

		Browser bro = browse.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));

		Page page = bro.newPage();

		Response res = page.navigate("https://playwright.dev/java/");
		String str = page.title();
		System.out.println("print the tittle:" + str);
		pl.close();
		bro.close();
		page.close();
	}

}
