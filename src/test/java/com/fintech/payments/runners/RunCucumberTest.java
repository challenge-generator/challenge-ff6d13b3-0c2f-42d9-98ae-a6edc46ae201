package com.fintech.payments.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.fintech.payments.stepdefinitions"},
    plugin = {
        "pretty",
        "html:target/cucumber/cucumber-report.html",
        "json:target/cucumber/cucumber.json",
        "junit:target/cucumber/cucumber-junit.xml"
    },
    tags = "@smoke or @regression",
    dryRun = false,
    strict = true
)
public class RunCucumberTest {
}