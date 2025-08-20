package sele.com;

import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class RegisterNewUser {
	
	
		Browser browser;
		Page page;
		@Test
		public void Selectplaywright() {
		try {
		 browser= Playwright.create().chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		  page=browser.newPage();
		 
		 page.navigate("https://freelance-learn-automation.vercel.app/login");
		 page.getByText("New user? Signup").click();
		 
//		 page.pause();
		 PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isDisabled();
		 
//		 page.locator("#name").fill("Iru daya");
		 page.locator("#name").fill(new Faker().name().fullName());
		 
		 page.getByPlaceholder("Email").fill(new Faker().name().firstName()+"_"+new Faker().name().lastName()+"@gmail.com");
//		 page.getByPlaceholder("Email").fill("idayaofjesus2@gmail.com");
		 
		 page.pause();
		 page.getByPlaceholder("Password1").fill("Irudaya@1435");
//		 page.getByText("Selenium").click();
//		 PlaywrightAssertions.assertThat(page.locator("xpath=//label[text()='Python']//preceding::input[1]")).isChecked();
		 
		 page.getByText("Python").click();
		 
		 PlaywrightAssertions.assertThat(page.locator("xpath=//label[text()='Python']//preceding::input[1]")).isChecked();
		 
		 page.locator("xpath=//input[@value='Male']").click();
		 PlaywrightAssertions.assertThat(page.locator("xpath=//input[@value='Male']")).isChecked();
		 
		 page.locator("#state").selectOption("Tamil Nadu");
		 
		 String hobbies[]= {"Reading","Singing"};
		 
		 page.locator("#hobbies").selectOption(hobbies);
		 PlaywrightAssertions.assertThat(page.locator(".submit-btn")).isEnabled();

		 page.locator(".submit-btn").click();
		 
		 page.waitForTimeout(3000);
	}
		finally {
			page.close();
			browser.close();
		}
}}