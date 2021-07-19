package tests.base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

@Log4j2
public class TestListener implements ITestListener {
    //TODO CREATE TEST RUN USING API(ADD TEST CASES TOO)
    public void onStart(ITestContext context) {
    }

    public void onTestStart(ITestResult result) {
        log.info(String.format("Test started:%s", result.getName()));
    }

    public void onTestSuccess(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            AllureUtils.takeScreenshot(driver);
        }
        log.info(String.format("Test Passed:%s", result.getName()));
    }

    //TODO API REQUEST TO SET STATUS OF TEST CASE
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            AllureUtils.takeScreenshot(driver);
        }
        log.info(String.format("Test Failed:%s", result.getName()));
    }

    public void onFinish(ITestContext context) {
        log.info("++++++++++++Tests class run complete++++++++++++");
    }

}
