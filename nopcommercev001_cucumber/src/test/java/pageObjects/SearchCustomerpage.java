package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilties.WaitHelper;

public class SearchCustomerpage {

	
	WebDriver driver;
	WaitHelper waithelper;
	
	public SearchCustomerpage(WebDriver Driver) {
		this.driver = Driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
	}
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='SearchLastName']")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='SearchCompany']")
	@CacheLookup
	WebElement txtCompany;
	
	@FindBy(xpath = "//input[@id='SearchIpAddress']")
	@CacheLookup
	WebElement txtIPAddress;
	
	@FindBy(xpath = "//select[@id='SearchMonthOfBirth']")
	@CacheLookup
	WebElement dropMonth;
	
	@FindBy(xpath = "//select[@id='SearchDayOfBirth']")
	@CacheLookup
	WebElement dropDay;
	
	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement customerRoles;
	
	@FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']//option[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement lstAdministrators;
	
	@FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']//option[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement lstForumModerators;
	
	@FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']//option[contains(text(),'Guests')]")
	@CacheLookup
	WebElement lstGuests;
	
	@FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']//option[contains(text(),'Registered')]")
	@CacheLookup
	WebElement lstRegistered;
	
	@FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']//option[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement lstVendors;
	
	@FindBy(xpath = "//button[@id='search-customers']")
	@CacheLookup
	WebElement btnSearch;
	
	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement table;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	
	public void setEmail(String Email) {
		waithelper.WaitForElement(txtEmail, Duration.ofSeconds(30));
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}
	
	public void setFirstname(String Firstname) {
		waithelper.WaitForElement(txtFirstName, Duration.ofSeconds(30));
		txtFirstName.clear();
		txtFirstName.sendKeys(Firstname);
	}
	
	public void setLastname(String Lastname) {
		waithelper.WaitForElement(txtLastName, Duration.ofSeconds(30));
		txtLastName.clear();
		txtLastName.sendKeys(Lastname);
	}
	
	public void clickSeatrch() {
		btnSearch.click();
	}
	
	public int gettableRows() {
		return tableRows.size();
	}
	
	public int gettableColumns() {
		return tableColumns.size();
	}
	
	public boolean searchCustomersbyEmail(String Email) {
		boolean flag = false;
		
		for(int i=1; i <=gettableRows(); i++) 
		{
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
			
			System.out.println(emailid);
			
			if(emailid.equals(Email)) {
				flag = true;
			}
		}
		return flag;
	}
	
	
}
