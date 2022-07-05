package com.cydeo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"html:target/cucumber-report.html",
        "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/features" ,
        glue = "com/cydeo/step_definitions" ,
        dryRun = false,
        tags ="@vytrack_resfresh_btn and @B26G32-60 and @B26G32-61"
)

public class CukesRunner {
}
