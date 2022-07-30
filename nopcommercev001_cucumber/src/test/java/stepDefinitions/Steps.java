package stepDefinitions;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Addnewcustomers;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerpage;

public class Steps extends Base {

	@Before
	public void setUp() throws IOException {

		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);

		Logger = Logger.getLogger("nopcommerce");
		PropertyConfigurator.configure("log4j.properties");
		
		String browser = configProp.getProperty("browser");
		if(browser.equals("chrome")) {
			System.setProperty("WebDriver.chrome.driver", configProp.getProperty("chromepath"));
			Logger.info("********** Browser Launched ***************");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			System.setProperty("WebDriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		
		
		
		
	}



	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String URL) throws InterruptedException {
		Logger.info("********** Opening URL ***************");
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(3000);

	}

	@And("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String email, String password) throws InterruptedException {
		Logger.info("********** Providing login details ***************");
		lp.setUserName(email);
		Thread.sleep(3000);
		lp.setPassword(password);
		Thread.sleep(3000);
	} 

	@And("Click on login")
	public void click_on_login() {
		Logger.info("********** Login Process Started ***************");
		lp.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("login was unsuccessful")) {
			driver.close();
			Logger.info("********** Login Passed ***************");
			Assert.assertTrue(false);
		}else {
			Assert.assertEquals(title, driver.getTitle());
			Logger.info("********** Login Process Failed ***************");
		}

	}

	@When("user click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		Logger.info("********** Logging out ***************");
		lp.clickLogout();
		Thread.sleep(3000);

	}

	@And("Close browser")
	public void close_browser() {
		Logger.info("********** Closing Browser ***************");
		driver.close();
		driver.quit();
	}
	//Customer feature step definitions

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCust = new Addnewcustomers(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getpagetitle());
	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickonCustomersMenu();
	}

	@When("Click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickonCustomerItemMenu();
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		addCust.clickonAddNew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getpagetitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		Logger.info("********** Adding new Customer ***************");
		Logger.info("********** Providing customer details ***************");
		String Email = randomString()+"@gmail.com";
		addCust.setEmail(Email);

		String Password = randomString()+"gmail.com";
		addCust.setPassword(Password);


		addCust.clearRegistered();
		Thread.sleep(2000);
		addCust.setCustomerRoles("Guests");
		Thread.sleep(2000);

		addCust.enterFirstname("sathish");
		addCust.enterlastname("12345");
		addCust.selectManageOfVEndors("Vendor 2");
		addCust.setDOB("12-09-1995");

	}

	@When("Click on save button")
	public void click_on_save_button() {
		Logger.info("********** Saving customer data ***************");
		addCust.clickSave();
	}
	@Then("user can view configuration message {string}")
	public void user_can_view_configuration_message(String message) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}

	//Steps for search customer

	@When("Enter customer Email")
	public void enter_customer_email() {
		Logger.info("********** Searching customer by email id ***************");
		searchCust = new SearchCustomerpage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSeatrch();
		Thread.sleep(2000);
	}
	@Then("User should find email in search table")
	public void user_should_find_email_in_search_table() {

		boolean status = searchCust.searchCustomersbyEmail("victoria_victoria@nopCommerce.com");

		Assert.assertEquals(true, status);

	}



}
