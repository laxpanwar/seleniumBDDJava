package com.qa.mystepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

public class PlaceOrderStepDefinitions {
    //private final WebDriver driver = DriverFactory.getDriver();
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;
    private CartPage cartPage;

    @Before(order = 1)          // runs after DriverFactory.initDriver()
    public void bindDriver() {
        driver = DriverFactory.getDriver();
    }

    @Given("I am already in the search page")
    public void i_am_on_the_search_page() {
        //WebDriver driver = DriverFactory.getDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        loginPage = new LoginPage(driver);
        String useremail = ConfigReader.getProperty("userEmail");
        String userpassword = ConfigReader.getProperty("userPassword");
        loginPage.enterEmail(useremail);
        loginPage.enterPassword(userpassword);
        loginPage.clickLoginButton();
        WebDriver driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.enterProduct("hp");
        homePage.click_on_the_search_btn();
    }

    @When("I click on the add to cart button")
    public void i_click_on_the_add_to_cart_button() {
        WebDriver driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.click_add_to_cart_btn();
    }

    @Then("The product should get added to cart successfully")
    public void the_product_should_get_added_to_cart_successfully() {
        //Assert.assertEquals(homePage.success_msg(),"Success: You have added HP LP3065 to your shopping cart!");
        Assert.assertTrue(homePage.success_msg().contains("Success: You have added"));
    }

    @And("I have clicked on the checkout button")
    public void click_on_the_checkout_btn(){
        homePage.click_on_the_checkout_btn();
        WebDriver driver = DriverFactory.getDriver();
        cartPage = new CartPage(driver);
    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And ("I click on the billing details continue button")
    public void click_on_the_billing_details_continue_btn(){
        cartPage.click_on_the_billing_details();
    }

    @When("I enter the billing details")
    public void i_enter_the_billing_details() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I click on the Confirm Order button")
    public void i_click_on_the_confirm_order_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Order confirmation message should be displayed")
    public void order_confirmation_message_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("I click on the delivery details continue button")
    public void click_on_the_delivery_continue_btn(){
        cartPage.click_on_the_delivery_details();
    }

    @And("I click on the delivery methods continue button")
    public void click_on_the_delivery_methods_continue_btn(){
        cartPage.click_on_the_delivery_method();
    }

    @And("I click on terms and condition checkbox")
    public void click_on_the_terms_and_condition_checkbox(){
        cartPage.click_on_the_terms_and_condition_checkbox();
    }

    @And("I click on the payment methods continue button")
    public void click_on_the_payment_methods_continue_btn(){
        cartPage.click_on_the_payment_method();
    }

    @And("I click on the confirm order button")
    public void click_on_the_confirm_order_btn(){
        cartPage.click_on_the_confirm_order();
    }
    @Then("order placed success message should display")
    public void order_placed_success_msg() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.get_order_placed_success_msg_should_display(),"Your order has been placed!");
    }

}
