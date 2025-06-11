package com.qa.mystepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

import static org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.milliseconds;

public class LoginStepDefinitions {

    private WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;


    @Before(order = 1)          // runs after DriverFactory.initDriver()
    public void bindDriver() {
        driver = DriverFactory.getDriver();
    }
    // Getter method to return the WebDriver instance
    public WebDriver getDriver() {
        return this.driver;
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        //WebDriver driver = DriverFactory.getDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);


    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password() {
        String useremail = ConfigReader.getProperty("userEmail");
        String userpassword = ConfigReader.getProperty("userPassword");
        loginPage.enterEmail(useremail);
        loginPage.enterPassword(userpassword);
    }

    @Given("I have entered invalid {string} and {string}")
    public void i_have_entered_invalid_and(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
       Assert.assertEquals(loginPage.checkLogoutLink(), true);
    }



    @Then("I should see an error message indicating {string}")
    public void i_should_see_an_error_message_indicating(String errorMessage) {
        // Assert that an error message is displayed on the page matching the expected error message
        Assert.assertEquals( driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
    }

    @When("I click on the \"Forgotten Password\" link")
    public void i_click_on_the_forgotten_password_link() {
        loginPage.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        // Assert that the current URL contains the password reset page route
        Assert.assertTrue(loginPage.getForgotPwdPageUrl().contains("account/forgotten"));
    }

//    @When("I have entered valid product in the search bar")
//    public void i_have_entered_valid_product_in_search_bar() throws InterruptedException {
//        homePage = new HomePage(driver);
//        Thread.sleep(1000);
//        homePage.enterProduct("hp");
//        homePage.click_on_the_search_btn();
//
//    }
//
//    @Then("Product displayed correctly")
//    public void product_should_display_correctly(){
//        Assert.assertEquals(homePage.get_search_text(),"Search - hp");
//
//    }
//
//    @When("I have entered an invalid product in the search bar")
//    public void entered_invalid_product_in_the_search_bar() throws InterruptedException {
//        homePage= new HomePage(driver);
//        Thread.sleep(1000);
//        homePage.enterProduct("tomato");
//        homePage.click_on_the_search_btn();
//    }
//
//    @Then("Correct inavlid validation message should display")
//    public void invalid_product_msg(){
//        Assert.assertEquals(homePage.get_invalid_product_msg(),"There is no product that matches the search criteria.");
//    }
}

