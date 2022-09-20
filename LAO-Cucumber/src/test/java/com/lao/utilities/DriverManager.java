package com.lao.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.lao.constants.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static final Logger LOGGER = LogManager.getLogger(DriverManager.class);
	
	private static WebDriver driver = null;
	
	public static  WebDriver getDriver() {
		return driver;
	}
	
	public static void launchbrowser() {

		try {
			switch (Constants.Browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				LOGGER.info("launching" +Constants.Browser);
				driver = new ChromeDriver();
				break;

			case "fireFox":
				WebDriverManager.firefoxdriver().setup();
				LOGGER.info("launching" +Constants.Browser);
				driver = new FirefoxDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				LOGGER.info("launching" +Constants.Browser);
				driver = new EdgeDriver();
				break;

			default:	
				WebDriverManager.chromedriver().setup();
				LOGGER.info("launching" +Constants.Browser);
				driver = new ChromeDriver();
				break;
			}}
		 catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}