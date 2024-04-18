package hellocucumber.pages;

import hellocucumber.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = WebDriverManager.getDriver();
    }

    // Other common methods for page objects
}
