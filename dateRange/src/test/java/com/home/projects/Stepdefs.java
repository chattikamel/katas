package com.home.projects;

import cucumber.api.Format;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Date;

public class Stepdefs {

    private DateRangeCalculator dateUtils = new DateRangeCalculator();

    private  String message;


    @Given("^a date range with start (.+) and end (.+)$")
    public void a_date_range_with_start_and_end(@Format("MMM d yy") Date from, @Format("MMM d yy") Date to) throws Throwable {

        dateUtils.from(from).to(to);
    }

    @Given("^a date range with start (.+) and today is (.+)$")
    public void a_date_range_with_start_and_today_is(@Format("MMM d yy") Date from, @Format("MMM d yy") Date today) throws Throwable {
        dateUtils.from(from).today(today);
    }

    @When("^I display the date range$")
    public void i_display_the_date_range() throws Throwable {
        message = dateUtils.buildMessage();
    }

    @Then("^I should print \"([^\"]*)\"$")
    public void i_should_print(String arg1) throws Throwable {
        Assert.assertEquals(arg1, message);
    }


}
