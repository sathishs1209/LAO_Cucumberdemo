package com.lao.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.lao.constants.Constants;
import com.lao.pageobjects.DirectoryPage;
import com.lao.pageobjects.HomePage;
import com.lao.pageobjects.LoginPage;
import com.lao.pageobjects.TimePage;

public class CommonUtils {
		
	private static CommonUtils CommonUtilsInstance = null;
	
	private CommonUtils() {};
	
	public static CommonUtils getInstance() {
		if(CommonUtilsInstance == null) {
			CommonUtilsInstance =  new CommonUtils();
		}
		return CommonUtilsInstance;
	}
	
	
	
	public void loadProperties() {
//		FileReader reader = null;
//		try {
//			reader = new FileReader("config.properties");
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Properties properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Constants.APP_URL=properties.getProperty("APP_URL");
		Constants.Browser=properties.getProperty("Browser");
		Constants.UserName=properties.getProperty("UserName");
		Constants.PassWord=properties.getProperty("PassWord");
		Constants.ChromeDriverLocation=properties.getProperty("ChromeDriverLocation");
		Constants.FireFoxDriverLocation=properties.getProperty("FireFoxDriverLocation");
		Constants.EdgeDriverLocation=properties.getProperty("EdgeDriverLocation");
		
	}

	public void initElements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
		PageFactory.initElements(DriverManager.getDriver(), TimePage.getInstance());
	}
	
	
	public void TakeScreenshot() {
		File Screenshot = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

			try {
				FileUtils.copyFile(Screenshot, new File("screenshot.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
}

