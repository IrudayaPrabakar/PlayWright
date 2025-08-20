package sele.com;

import org.apache.tools.ant.filters.LineContains.Contains;
import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Alert_PW {

	public static void main(String[] args) {

		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();

		page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		
		
//		 To accept the Alert
		page.onDialog(Dialog->{
			
		String meg=	Dialog.message();
		System.out.println("Dialog text is"+meg);
		Assert.assertTrue(meg.contains("I am a JS Alert"));
		
        Dialog.accept();
			
	});
		page.locator("//button[normalize-space()='Click for JS Alert']").click();
		
//		To Confirm the Alert
		
		page.onDialog(Dialog->{
			
			String meg=	Dialog.message();
			System.out.println("Dialog text is"+meg);
			Assert.assertTrue(meg.contains("I am a JS Confirm"));
			
	        Dialog.accept();
				
		});
			page.locator("(//button[normalize-space()='Click for JS Confirm'])[1]").click();
			
//			Dismiss the Alert
			page.onDialog(Dialog->{
				
				String meg=	Dialog.message();
				System.out.println("Dialog text is"+meg);
				Assert.assertTrue(meg.contains("I am a JS Confirm"));
				
		        Dialog.dismiss();
					
			});
				page.locator("(//button[normalize-space()='Click for JS Confirm'])[1]").click();
	}

}
