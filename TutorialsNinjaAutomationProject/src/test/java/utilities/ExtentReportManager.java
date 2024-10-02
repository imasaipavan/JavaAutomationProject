package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;
import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	@Override
	public void onStart(ITestContext context) {
		SimpleDateFormat format = new SimpleDateFormat("HH.mm.dd.MM.yyyy");
		Date date = new Date();
		String currentTime= format.format(date);
		System.out.println("Started");
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/"+currentTime+"Report.html");
		spark.config().setDocumentTitle("TutorialsNinja Automation Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Functional Testing");
		extent = new ExtentReports();
		extent.setSystemInfo("Application", "TutorialsNinja");
		extent.setSystemInfo("Module", "user");
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		String browser=context.getCurrentXmlTest().getParameter("browser");
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("OS", os);
		extent.setSystemInfo("Browser", "browser");
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
		String impath = new BaseClass().captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(impath);
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
