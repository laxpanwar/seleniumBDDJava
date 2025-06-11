package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By checkoutBtn = By.xpath("//a[@title='Checkout']");
    private By billingDetailsContinueBtn= By.xpath("//input[@id='button-payment-address']");
    private By diliveryContinueBtn= By.xpath("//input[@id='button-shipping-address']");
    private By deliveryMethodContinueBtn= By.xpath("//input[@id='button-shipping-method']");
    private By paymentMethodContinueBtn= By.xpath("//input[@id='button-payment-method']");
    private By TermAndConditionCheckbox= By.xpath(" //input[@type='checkbox']");
    private By ConfirmOrderBtn= By.xpath("//input[@id='button-confirm']");
    private By orderPlacedSuccessMsg= By.xpath("//div//h1");



    //methods

    public void click_on_the_billing_details(){
        WebElement billing_details_continue_btn = driver.findElement(billingDetailsContinueBtn);
        billing_details_continue_btn.click();
    }

    public void click_on_the_delivery_details(){
        WebElement delivery_details_continue_btn = driver.findElement(diliveryContinueBtn);
        delivery_details_continue_btn.click();
    }

    public void click_on_the_delivery_method(){
        WebElement delivery_method_continue_btn = driver.findElement(deliveryMethodContinueBtn);
        delivery_method_continue_btn.click();
    }

    public void click_on_the_terms_and_condition_checkbox(){
        WebElement termsandcondition_checkbox = driver.findElement(TermAndConditionCheckbox);
        termsandcondition_checkbox.click();
    }
    public void click_on_the_payment_method(){
        WebElement payment_method_continue_btn = driver.findElement(paymentMethodContinueBtn);
        payment_method_continue_btn.click();
    }
    public void click_on_the_confirm_order(){
        WebElement confirm_order_btn = driver.findElement(ConfirmOrderBtn);
        confirm_order_btn.click();
    }

    public String get_order_placed_success_msg_should_display(){
        WebElement order_placed_success_msg = driver.findElement(orderPlacedSuccessMsg);
        return order_placed_success_msg.getText();
    }

}

