package sele.com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FilesDownload {

	public static void main(String[] args) throws IOException {
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));

		Page page = browser.newPage();
		page.navigate("https://the-internet.herokuapp.com/download");

		Download download=	page.waitForDownload(()->{
			page.locator("//a[text()='damn soin.txt']").click();
			
			
		});
		String downloadPath=System.getProperty("user.dir")+"/Downloadfiles/"+download.suggestedFilename();
		
		download.saveAs(Paths.get(downloadPath));
		
//		Playwright assertion
		if (downloadPath.endsWith(".txt")) {
			System.out.println("Files extension verified");
		}	
		else {
			System.out.println("Files extension verification is failed");
			browser.close();
			return;
		}
		if (Files.size(Path.of(downloadPath)) >0){
			System.out.println("Files size is verified");
		}	
		else {
			System.out.println("Files size is not verified");
			browser.close();
			return;
		}
		String dataFiles=Files.readString(Path.of(downloadPath));
		{
			System.out.println(dataFiles);
			
		
		
//		System.out.println(download.suggestedFilename());
//		System.out.println(download.url());
//		System.out.println(download.path());
		
		page.close();
		browser.close();
}
}}