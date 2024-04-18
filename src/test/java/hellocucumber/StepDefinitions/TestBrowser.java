package hellocucumber.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBrowser {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open a web page
        driver.get("https://hrg.train.paytronix.com/en-us/guest/");

        Thread.sleep(6000);

        // Close the browser
        driver.quit();
    }
}
