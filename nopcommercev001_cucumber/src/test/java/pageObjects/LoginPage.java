package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
		

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='Email']")
	@CacheLookup
	private WebElement txt_email;
	
	@FindBy(id = "Password")
	@CacheLookup
	private WebElement txt_password;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btn_login;
	
	@FindBy(xpath = "//a[text()='Logout']")
	@CacheLookup
	private WebElement btn_logout;
	
	public void  setUserName(String username) {
		txt_email.clear();
		txt_email.sendKeys(username);
	}
	
	public void setPassword(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public void clickLogout() {
		btn_logout.click();
	}
	
	
}
