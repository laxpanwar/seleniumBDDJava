package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By searchBar = By.xpath("//input[@placeholder='Search']");
    private By serach_btn = By.xpath("//span[@class='input-group-btn']//button[1]");
    private By serach_result = By.xpath("//div[@id='content']//h1[1]");



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









}
