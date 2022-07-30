package com.lao.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	private static HomePage HomeInstance;
	
	private HomePage() {};
	
	public static HomePage getInstance() {
		if(HomeInstance == null) {
			HomeInstance = new HomePage();
		}
		return HomeInstance;
	}
	
	
	@FindBy(id="menu_directory_viewDirectory")
	private static WebElement Directory;
	
	
	@FindBy(id = "menu_time_viewTimeModule")
	WebElement Time;
	
	public void ClickDirectory() {
		Directory.click();
	}
	
	public void clickTimeOption() {
		Time.click();
	}
	
}
