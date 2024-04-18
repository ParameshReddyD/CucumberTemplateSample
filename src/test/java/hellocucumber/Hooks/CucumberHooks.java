package hellocucumber.Hooks;

import hellocucumber.ReportManager;
import hellocucumber.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class CucumberHooks {


    @Before
    public void BeforeScenario(Scenario scenario){
        ReportManager.startTest(scenario.getName(), "SMOKE");
    }

    @After
    public void AfterScenario(Scenario scenario){
        if(scenario.isFailed()){
            ReportManager.logPass(scenario.getName() + "is passed");
            ReportManager.endCurrentTest();
        }
        else {
            ReportManager.logFail(scenario.getName() + "is Failed");
            ReportManager.endCurrentTest();
        }

    }
}
