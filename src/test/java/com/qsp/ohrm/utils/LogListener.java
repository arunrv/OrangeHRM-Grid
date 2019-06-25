package com.qsp.ohrm.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class LogListener implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result)
	{
		Log.info("--- Test Execution Started---" + result.getName());
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("--- Test Execution Completed With PAss---" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("--- Test Execution Completed With FAIL---" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("--- Test Execution Completed With SKIP---" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		Log.info("--- Test Execution Completed With Prercentage---" );
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Log.info("--- Test Execution Completed With ---" + context.getHost());
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Log.info("--- Test Execution Finished With ---" + context.getHost());
	}

}
