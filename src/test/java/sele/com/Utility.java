package sele.com;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.microsoft.playwright.Page;

public class Utility {

	public static byte[] getScreenShot(Page page) {
		
		SimpleDateFormat customDate=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		Date date=new Date();
		String newDate=customDate.format(date);
	
	   byte[] screen= page.screenshot(new Page.ScreenshotOptions().setFullPage(true).setPath(Paths.get("StoreScreenShot/"+newDate+".png")));

	   
	   return null;
}
}