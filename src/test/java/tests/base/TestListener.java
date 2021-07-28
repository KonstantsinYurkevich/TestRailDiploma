package tests.base;

import adapters.ProjectTestCase;
import lombok.extern.log4j.Log4j2;
import modals.TestCase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import utils.AllureUtils;


@Log4j2
public class TestListener implements ITestListener {
    String statusId;

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

        apiSendTestCaseStatus(result);

    }

    //TODO API REQUEST TO SET STATUS OF TEST CASE
    public void onTestFailure(ITestResult result) {
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        if (driver != null) {
            AllureUtils.takeScreenshot(driver);
        }
        log.info(String.format("Test Failed:%s", result.getName()));

        apiSendTestCaseStatus(result);

    }

    public void onFinish(ITestContext context) {
        log.info("++++++++++++Tests class run complete++++++++++++");
    }

    public void apiSendTestCaseStatus(ITestResult result) {
        boolean testSuccess = result.isSuccess();
        if (testSuccess) {
            statusId = "1";
        } else {
            statusId = "5";
        }
        TestCase testCase = TestCase.builder()
                .statusId(statusId)
                .build();
        int caseId = Integer.parseInt(result.getMethod().getConstructorOrMethod().getMethod().
                getAnnotation(Test.class).testName());
        new ProjectTestCase().testCaseRunStatus(testCase, 200, BaseTest.getRunId(), caseId);
    }
}
