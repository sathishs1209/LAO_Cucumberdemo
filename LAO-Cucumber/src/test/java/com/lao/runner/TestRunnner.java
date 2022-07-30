package com.lao.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(
		features = "classpath:/Feature",
		glue = "com.lao.step_definitions",
		dryRun = false,
		monochrome = true,
		plugin = {"rerun:target/failed_scenarios.txt",
				"json:target/cucumber-reports/reports.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class TestRunnner {

}
