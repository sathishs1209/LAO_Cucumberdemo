package com.lao.step_definitions;


import org.apache.logging.log4j.LogManager;

import org.openqa.selenium.support.ui.Select;

import com.lao.constants.Constants;
import com.lao.pageobjects.DirectoryPage;
import com.lao.pageobjects.HomePage;
import com.lao.pageobjects.LoginPage;
import com.lao.utilities.CommonUtils;
import com.lao.utilities.DriverManager;


import io.cucumber.java.en.*;

public class VerifyCEOName_StepDef {
	
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(VerifyCEOName_StepDef.class);
	

	@Given("The user is logged in successfully and is on HomePage")
	public void the_user_is_logged_in_successfully_and_is_on_home_page() {
	try {	
		DriverManager.getDriver().navigate().to(Constants.APP_URL);
		
		LoginPage.getInstance().enteruserName(Constants.UserName);
		LoginPage.getInstance().enterPassword(Constants.PassWord);
		LoginPage.getInstance().clickLoginBTN();	
	}
	catch (Exception e) {
		LOGGER.error(e);
		CommonUtils.getInstance().TakeScreenshot();
		
	}
	}

	@When("User clicks on the directory option from the menu bar")
	public void user_clicks_on_the_directory_option_from_the_menu_bar() {
		try {
		HomePage.getInstance().ClickDirectory();
	}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}
	
	@And("user clicks the job titles as {string} from the dropdown")
	public void user_clicks_the_job_titles_as_from_the_dropdown(String jobtitle) {
		try {
		DirectoryPage.getInstance().selectDropDown(jobtitle);
	}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}

	@And("Clicks on search button")
	public void clicks_on_search_button() {
		try {
		DirectoryPage.getInstance().clickSearchBtn();
		LOGGER.info("search button is clicked");
	}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}

	@Then("User should see the CEO name {string}")
	public void user_should_see_the_ceo_name(String expectedresult) {
		try {
		String Actualresult = DirectoryPage.getInstance().getPersonName();
		if(Actualresult.equals(expectedresult)) {
			LOGGER.info("the user should see the CEO name as John Smith");
		}
	}
		catch (Exception e) {
			LOGGER.error(e);
			CommonUtils.getInstance().TakeScreenshot();
		}
	}
	
	
	
}
