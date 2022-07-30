package com.lao.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private static LoginPage LoginInstance;
	
	private LoginPage() {}
	
	public static LoginPage getInstance() {
		if(LoginInstance == null) {
			LoginInstance = new LoginPage();
		}	
		return LoginInstance;
		
	}
	
	
	@FindBy(id="txtUsername")
	private WebElement UserName;
	
	@FindBy(id="txtPassword")
	private WebElement PassWord;
	
	@FindBy(id="btnLogin")
	private WebElement btnLogIn;
	
	
//	public WebElement getUserName() {
//		return UserName;
//	}
//	
//	public WebElement getPassWord() {
//		return PassWord;
//	}
//	
//	public WebElement clickLogin() {
//		return btnLogIn;
//	}
//	
	
	public void enteruserName(String username) {
		UserName.sendKeys(username);
	}
	
	public void enterPassword(String Password) {
	PassWord.sendKeys(Password);
}
	public void clickLoginBTN() {
		btnLogIn.click();
	}
	

}
