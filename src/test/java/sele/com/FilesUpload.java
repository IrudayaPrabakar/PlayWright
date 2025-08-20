package sele.com;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FilesUpload {
	public static void main(String[] args) throws InterruptedException {
		   
		
		Browser browser = Playwright.create().chromium()
				.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
		Page page = browser.newPage();

		page.navigate("https://the-internet.herokuapp.com/upload");
//		page.locator("#file-upload").setInputFiles(Path.of("C:\\Users\\Irudaya_PrabakarA\\Downloads/UK-CV-Format"));
		
//		page.locator("#file-upload").setInputFiles(Path.of(System.getProperty("user.dir")+"/Files/UK-CV-Format.docx"));

//		page.locator(".dz-success-mark dz-clickable").setInputFiles(Path.of(System.getProperty("user.dir")+"/Files/UK-CV-Format.docx"));

		
//		for the multiple Files to upload we have to use Array concept
//		
//		Path [] files= {
//				Path.of(System.getProperty("user.dir")+"/Files/UK-CV-Format.docx"),
//				Path.of(System.getProperty("user.dir")+"/Files/Irudaya_Resume_Formatted.docx"),
////				Path.of(System.getProperty("user.dir")+"/Files/UK-CV-Format2.docx"),
////				Path.of(System.getProperty("user.dir")+"/Files/UK-CV-Format3.docx"),
//		};
//		page.locator(".dz-success-mark dz-clickable").click();
//		page.setInputFiles(null, files);
		
		
//		Path [] files= {
//				Path.of(System.getProperty("user.dir")+"/Files/UK-CV-Format.docx"),
//		};
		page.locator("#file-upload").setInputFiles(new Path[] 
				{
					Path.of(System.getProperty("user.dir")+"/Files/UK-CV-Format.docx")
				});
		
		Thread.sleep(2000);
		
//		to deselect the given file
		page.locator("#file-upload").setInputFiles(new Path[0]); 
		
		page.close();
		browser.close();
		
		
		
		
		
		
		
		
		
	}

}
