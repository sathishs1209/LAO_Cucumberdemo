package com.lao.step_definitions;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lao.constants.Constants;
import com.lao.utilities.CommonUtils;
import com.lao.utilities.DriverManager;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.Before;

public class Common_Step_definitons {
	
	
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(Common_Step_definitons.class);	
	

	@Before
	public void beforescenario() {
		LOGGER.info("Execution Started");
		try {
			LOGGER.info("Instantiating Common Utils");
			
			LOGGER.info("Loading the property file");
			CommonUtils.getInstance().loadProperties();
			LOGGER.info("Checking driver is null or not");
			if(DriverManager.getDriver() == null) {
				LOGGER.info("Checking driver is null. Instantiate");
				DriverManager.launchbrowser();
				CommonUtils.getInstance().initElements();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	}
