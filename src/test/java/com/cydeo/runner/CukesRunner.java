package com.cydeo.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={"html:target/cucumber-report.html",
                "json:target/cucumber-report.json",
                "rerun:target/rerun.txt",
                "pretty"},
        features = "src/test/resources/features" ,
        glue = "com/cydeo/step_definitions" ,
        dryRun = false,
        tags =" @vehicles_page_store_manager",
        monochrome = true
)

public class CukesRunner {
}
