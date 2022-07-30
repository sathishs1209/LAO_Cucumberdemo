package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.Addnewcustomers;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerpage;

public class Base {

	public WebDriver driver;
	public LoginPage lp;
	public Addnewcustomers addCust;
	public SearchCustomerpage searchCust;
	public Logger Logger;
	public Properties configProp;
	
	

	public static String randomString() {
		String generatestring1 = RandomStringUtils.randomAlphabetic(5);
			return(generatestring1);
	}

}


