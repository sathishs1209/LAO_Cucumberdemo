package com.lao.step_definitions;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;

import com.lao.constants.Constants;
import com.lao.pageobjects.HomePage;
import com.lao.pageobjects.LoginPage;
import com.lao.pageobjects.TimePage;
import com.lao.utilities.CommonUtils;
import com.lao.utilities.DriverManager;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.*;

public class VerifyTimesheet_StepDef {
	
	public static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(VerifyTimesheet_StepDef.class);
	
	@Given("the user is on homepage")
	public void the_user_is_on_homepage() {
	DriverManager.getDriver().get(Constants.APP_URL);
	
	LoginPage.getInstance().enteruserName(Constants.UserName);
	LoginPage.getInstance().enterPassword(Constants.PassWord);
	LoginPage.getInstance().clickLoginBTN();	
	}

	@Given("the user clicks on the time option from the menu")
	public void the_user_clicks_on_the_time_option_from_the_menu() {
		HomePage.getInstance().clickTimeOption();
	}

	@Given("user enters the name as {string}")
	public void user_enters_the_name_as(String PersonName) {
		try {
		TimePage.getInstance().enterUserName(PersonName);
	}
		catch (Exception e) {
			CommonUtils.getInstance().TakeScreenshot();
			e.printStackTrace();
		}
	}

	@Given("clicks on search button")
	public void clicks_on_search_button() {
		TimePage.getInstance().clickSearchBtn();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			CommonUtils.getInstance().TakeScreenshot();
			e.printStackTrace();
		}
	}

	@Then("user should se  the message {string}")
	public void user_should_se_the_message(String string) {
		try {
		String message = TimePage.getInstance().Message();
		if(string.equals(message)) {
			LOGGER.info("User should see "+message );
		}
	}
		catch (Exception e) {
			CommonUtils.getInstance().TakeScreenshot();
			e.printStackTrace();
		}
	}

}
