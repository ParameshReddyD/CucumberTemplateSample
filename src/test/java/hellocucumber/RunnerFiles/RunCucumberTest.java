//package hellocucumber.RunnerFiles;
//
//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectPackages;
//import org.junit.platform.suite.api.Suite;
//
//import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
//
//@Suite
//@IncludeEngines("cucumber")
//@SelectPackages("hellocucumber")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
//
//public class RunCucumberTest {
//
//
//}
//
//
//
///*
//package com.qualitymatrix.bdd.common.runner_files;
//
//import com.qualitymatrix.bdd.common.hooks.MailListener;
//import com.qualitymatrix.bdd.integrations.NG_listners.SuiteEvent;
//import com.qualitymatrix.bdd.integrations.NG_listners.WebEvent;
//import io.cucumber.testng.*;
//import org.testng.ITestContext;
//import org.testng.annotations.*;
//
//@Listeners({SuiteEvent.class, WebEvent.class, MailListener.class})
//
//@CucumberOptions(features = {"src/test/java/com/qualitymatrix/bdd/web/features"},
//                    glue = {"com/qualitymatrix/bdd/web/step_definitions", "com/qualitymatrix/bdd/common/hooks"},
//                    tags = {"@Login,@Lead,@Contact,@Organization"},
//                    plugin = {"pretty", "html:target/site/cucumber-pretty",
//                            "json:target/cucumber.json",
//                            "rerun:target/rerun.txt"})
////                    monochrome = true,
////                    strict = true,
////                    dryRun = false)
//
////@flipkart , @md , @dd "@login", @attack	@app
//
//public class Web_Runner2 extends AbstractTestNGCucumberTests {
//
//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//
//        return super.scenarios();
//    }
//}
// */