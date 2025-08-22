package page.com;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

	private Locator userNamelocator;
	private Locator userPasswordlocator;
	private Locator userLoginlocator;

	public LoginPage(Page page) {

		userNamelocator = page.getByPlaceholder("Enter Email");
		userPasswordlocator = page.getByPlaceholder("Enter Password");

		userLoginlocator = page.locator(".submit-btn");
		
		
		
	}
   //1.create login method and pass parameters
  //2.create login method of each actions and pass parameters

	public void logInToApplication(String user, String pass) {
		userNamelocator.fill("user");
		userPasswordlocator.fill("pass");
		userLoginlocator.click();
	}
	
	


}
