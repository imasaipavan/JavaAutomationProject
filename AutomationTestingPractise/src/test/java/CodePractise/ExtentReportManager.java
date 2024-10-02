package CodePractise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Started");
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		spark.config().setDocumentTitle("Testing Document");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Testing Report");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case passed is : "+result.getName());
		System.out.println("Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case passed is : "+result.getName());
		System.out.println("Test Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case passed is : "+result.getName());
		System.out.println("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Finished");
		extent.flush();
	}
	
	

}
