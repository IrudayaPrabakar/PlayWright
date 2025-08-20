package sele.com;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class TracingDebug {

	@Test
	public void LoginTestNG() {

		Browser browser = null;
		Page page = null;
		BrowserContext context=null;
		try {
			browser = Playwright.create().chromium()
					.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
			
			 context=browser.newContext();
			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
			
			
			page = context.newPage();
			page.navigate("https://freelance-learn-automation.vercel.app/login");

			Assert.assertTrue(page.title().contains("Learn Automation Courses"));

			// css selector
			page.locator("css=input[name='email1']").fill("idayaofjesus2@gmail.com");

//			page.getByPlaceholder("Enter Email").fill("idayaofjesus2@gmail.com");
			page.getByPlaceholder("Enter Password").fill("Irudaya@1435");

			page.getByText("Sign in").last().click();

			PlaywrightAssertions.assertThat(page.locator(".welcomeMessage")).containsText("Welcome");

			page.locator("css=img[src='/static/media/burger-menu.93a4e66d6d393af53ac4ed46e5193397.svg']").click();
//			Positive scenario
//			page.getByText("Sign out").click();
			
//			Negative scenario
			page.getByText("Signup").click();

			PlaywrightAssertions.assertThat(page).hasURL(Pattern.compile("login"));
			
			context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));

			
		}

		finally {

			context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));

			browser.close();
			page.close();

		}
	}
}