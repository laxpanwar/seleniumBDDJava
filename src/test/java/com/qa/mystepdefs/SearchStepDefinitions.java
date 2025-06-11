package com.qa.mystepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;



public class SearchStepDefinitions {


    //private final WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;

//    @Before
//    public void setup(){
//        WebDriverManager.chromedriver().setup(); // No need for manual exe file!
////        WebDriver driver = new ChromeDriver();
//        driver = new ChromeDriver();
//
//    }
////
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }


@When("I have entered valid product in the search bar")
public void i_have_entered_valid_product_in_search_bar() throws InterruptedException {
    WebDriver driver = DriverFactory.getDriver();
    homePage = new HomePage(driver);
    Thread.sleep(1000);
    homePage.enterProduct("hp");
    homePage.click_on_the_search_btn();

}

    @Then("Product displayed correctly")
    public void product_should_display_correctly(){
        Assert.assertEquals(homePage.get_search_text(),"Search - hp");

    }

    @When("I have entered an invalid product in the search bar")
    public void entered_invalid_product_in_the_search_bar() throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();
        homePage= new HomePage(driver);
//        Thread.sleep(1000);
        homePage.enterProduct("tomato");
        homePage.click_on_the_search_btn();
    }

    @Then("Correct inavlid validation message should display")
    public void invalid_product_msg(){
        Assert.assertEquals(homePage.get_invalid_product_msg(),"There is no product that matches the search criteria.");
    }
}




