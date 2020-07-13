package bigtraining.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    Logger logger = Logger.getLogger(TestListener.class);


    public void onTestStart(ITestResult result) {

        logger.info("Test started");

    }

    public void onTestSuccess(ITestResult result) {

        logger.info("Test completed successfully");

    }

    public void onTestFailure(ITestResult result) {

        logger.info("Test failed");

    }

    public void onTestSkipped(ITestResult result) {

        logger.info("Test skipped");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
