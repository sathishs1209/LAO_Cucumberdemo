package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Addnewcustomers {

	WebDriver driver;

	public Addnewcustomers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//locators

	By lnkcustomer_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]//i");

	By lnkcustomer_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	By btn_addnew = By.xpath("//a[@class='btn btn-primary']");

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");

	By txtFirstname = By.xpath("//input[@id='FirstName']");
	By txtLastname = By.xpath("//input[@id='LastName']");

	By rdGenderMale = By.xpath("//input[@id='Gender_Male']");
	By rdGenderFemale = By.xpath("//input[@id='Gender_Female']");

	By txtDOB = By.xpath("//input[@id='DateOfBirth']");

	By txtCompanyName = By.xpath("//input[@id='Company']");

	By chkTaxExempt = By.xpath("//input[@id='IsTaxExempt']");

	By txtNewsLetter = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']");
	By txtCustomerRoles = By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']");
	By txtCustomerRolesAdmin = By.xpath("//li[@role=\"option\"]//span[contains(text(),'Administrators')]");
	By txtCustomerRolesRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By txtCustomerRolesGuest = By.xpath("//li[contains(text(),'Guests')]");
	By txtCustomerRolesVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	
	By txtCustomerRoleDelete = By.xpath("//li[@role='option']//span[@title='delete']");
	
	By txtManageofVendor = By.xpath("//select[@id='VendorId']");

	By chkActive = By.xpath("//input[@id='Active']");

	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//button[@name='save']");

	//Action Methods
	
	
	public String getpagetitle() {
		return driver.getTitle();
	}

	public void clickonCustomersMenu() {
		driver.findElement(lnkcustomer_menu).click();
	}

	public void clickonCustomerItemMenu() {
		driver.findElement(lnkcustomer_menuitem).click();
	}

	public void clickonAddNew() {
		driver.findElement(btn_addnew).click();
	}

	public void setEmail(String Email) {
		driver.findElement(txtEmail).sendKeys(Email);
	}

	public void setPassword(String Password) {
		driver.findElement(txtPassword).sendKeys(Password);
	}
	
	public void clearRegistered() {
		driver.findElement(txtCustomerRoleDelete).click();
	}

	public void setCustomerRoles(String Role) {
		WebElement ListItem = null;

		if(Role.equals("Administrators")) {
			ListItem = driver.findElement(txtCustomerRolesAdmin);
		}

		else if(Role.equals("Guests")) {
			//driver.findElement(txtCustomerRoles).clear();
			ListItem = driver.findElement(txtCustomerRolesGuest);
		}

		else if(Role.equals("Registered")) {
			ListItem = driver.findElement(txtCustomerRolesRegistered);
		}

		else if(Role.equals("Vendors")) {
			ListItem = driver.findElement(txtCustomerRolesVendors);
		}

		//ListItem.click();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", ListItem);
		
	}

	public void selectManageOfVEndors(String value) {
		Select drp = new Select(driver.findElement(txtManageofVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if(gender.equals("Male")) {
			driver.findElement(rdGenderMale).click();
		}
		else if(gender.equals("Female")) {
			driver.findElement(rdGenderFemale).click();
		}
	}
	
	public void enterEmail(String Email) {
		driver.findElement(txtEmail).sendKeys(Email);
	}
	
	public void enterPassword(String Password) {
		driver.findElement(txtPassword).sendKeys(Password);
	}
	
	public void enterFirstname(String Firstname) {
		driver.findElement(txtFirstname).sendKeys(Firstname);
	}
	
	public void enterlastname(String Lastname) {
		driver.findElement(txtLastname).sendKeys(Lastname);
	}
	
	public void clickSave() {
		driver.findElement(btnSave).click();
	}
	
	public void setDOB(String DOB) {
		driver.findElement(txtDOB).sendKeys(DOB);
	}
}
