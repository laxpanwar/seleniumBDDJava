package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;

// AppHooks.java   (package must be in your glue path)
public class AppHooks {


    @Before(order = 0)                // runs first
    public void launchBrowser() {
        DriverFactory.initDriver();   // guarantees live driver
    }

    @After(order = 0)
    public void quitBrowser() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) driver.quit();
    }
}

