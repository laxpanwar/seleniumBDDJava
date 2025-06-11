package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By searchBar = By.xpath("//input[@placeholder='Search']");
    private By serach_btn = By.xpath("//span[@class='input-group-btn']//button[1]");
    private By serach_result = By.xpath("//div[@id='content']//h1[1]");
    private By invalidProductMsg = By.xpath("//*[@id=\"content\"]/p[2]");
    private By addToCartButton = By.xpath("(//button[@type='button']//i[@class='fa fa-shopping-cart'])[2]");
    private By succssesMsg= By.xpath("//div[@class='alert alert-success alert-dismissible']");
    private By secondAddToCartBtn = By.xpath("//button[@id='button-cart']");
    private By checkoutBtn = By.xpath("//a[@title='Checkout']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void enterProduct(String product) {
        WebElement searchInput = driver.findElement(searchBar);
        searchInput.sendKeys(product);
    }

    public void click_on_the_search_btn(){
        WebElement searchBtn = driver.findElement(serach_btn);
        searchBtn.click();
    }

    public String get_search_text(){
        WebElement search_text = driver.findElement(serach_result);
        return search_text.getText();
    }

    public String get_invalid_product_msg(){
        WebElement search_text = driver.findElement(invalidProductMsg);
        return search_text.getText();
    }

    public void click_add_to_cart_btn(){
        WebElement add_ToCart_Button = driver.findElement(addToCartButton);
        add_ToCart_Button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            WebElement secondAddToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='button-cart']")));
            secondAddToCartBtn.click();
        } catch (TimeoutException e) {
            System.out.println("Button did not appear within 5 seconds.");
        }

    }

    public String success_msg(){
        WebElement success_msg = driver.findElement(succssesMsg);
        return success_msg.getText();
    }

    public void click_on_the_checkout_btn(){
        WebElement checkout_btn = driver.findElement(checkoutBtn);
        checkout_btn.click();
    }







}
