package com.lao.pageobjects;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimePage {

	private static  TimePage TimeInstance;
	
	private TimePage() {};
	
	public static TimePage getInstance() {
		if (TimeInstance == null) {
			TimeInstance = new TimePage();
		}
		return TimeInstance;
	}

	
	@FindBy(xpath="//input[@id='employee']")
	WebElement SearchName;
	
	@FindBy(id="btnView")
	WebElement ViewBtn;
	
	@FindBy(xpath = "//div[@class='message warning']")
	WebElement SearchResult;
	
	public void enterUserName(String PersonName) {
		
		//SearchName.clear();
		SearchName.sendKeys(PersonName);
	}
	
	public void clickSearchBtn() {
		ViewBtn.click();
	}
	
	public String Message() {
		String result = SearchResult.getText();
		return result;
	}
	
	
	
}
