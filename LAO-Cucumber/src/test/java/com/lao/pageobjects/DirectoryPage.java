package com.lao.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DirectoryPage {

	private static DirectoryPage DirectoryInstance;
	
	private DirectoryPage() {};
	
	public static DirectoryPage getInstance() {
		if(DirectoryInstance==null) {
			DirectoryInstance = new DirectoryPage(); 
		}
		return DirectoryInstance;
	}
	
	@FindBy(id=("searchDirectory_job_title"))
	private static WebElement jobTitle;
	
	@FindBy(id=("searchBtn"))
	private static WebElement searchBtn;
	
	@FindBy(xpath = "//li/b")
	private static WebElement searchResult;
	
	public void selectDropDown(String jobtitle) {
		Select DD = new Select(jobTitle);
		DD.selectByVisibleText(jobtitle);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public String getPersonName() {
		return searchResult.getText();
	}
	}
	

