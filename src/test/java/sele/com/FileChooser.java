package sele.com;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileChooser {

	public static void main(String[] args) {
		
		
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();

		page.navigate("https://the-internet.herokuapp.com/upload");
		
	com.microsoft.playwright.FileChooser filechooser=page.waitForFileChooser(()->page.locator("#drag-drop-upload").click());
		
           filechooser.setFiles(Paths.get("C:\\Users\\Irudaya_PrabakarA\\Downloads/qa-quality-assurance-software-tester2  - Template 14"));
	
	
	Path [] fileToUpload= {
			
			Paths.get("C:\\Users\\Irudaya_PrabakarA\\Downloads/qa-quality-assurance-software-tester2  - Template 14"),
			Paths.get("C:\\Users\\Irudaya_PrabakarA\\Downloads/qa-quality-assurance-software-tester2  - Template 14"),
			Paths.get("C:\\Users\\Irudaya_PrabakarA\\Downloads/qa-quality-assurance-software-tester2  - Template 14")
	};
	filechooser.setFiles(fileToUpload);

	page.close();
	browser.close();
	}
}
