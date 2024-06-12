package hellocucumber.RunnerFiles;


import hellocucumber.ReportManager;
import hellocucumber.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/hellocucumber"},
        glue = {"hellocucumber/StepDefinitions", "hellocucumber/Hooks"},
        tags = "@Login",
        plugin = {"pretty", "html:target/site/cucumber-pretty.html",
                "junit:target/site/cucumber-pretty.xml",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"})
//                    monochrome = true,
//                    strict = true,
//                    dryRun = false)


public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver before tests start
        WebDriverManager.getDriver();
        ReportManager.startReport();
    }

    @AfterClass
    public void tearDown() {
        // Quit WebDriver after tests finish
        WebDriverManager.quitDriver();
        ReportManager.endReport();
    }



    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();
    }



}
