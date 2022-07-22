package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.exec.OS;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener{
	ExtentReports extent;
	ExtentHtmlReporter reporter;
	public ExtentTest test;
	WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="\\target"+"Test-Report-"+timestamp+".html";
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\target"+repName);
		System.out.println(System.getProperty("user.dir")+"\\target"+"\\target");
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Shravan");
		reporter.config().setDocumentTitle("Banking Project");
		reporter.config().setReportName("Functional Report");
		reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		reporter.config().setTheme(Theme.DARK);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest((result.getName()));
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test=extent.createTest((result.getName()));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		String screenshotpath=System.getProperty(("user.dir")+"\\Screenshots\\"+result.getName()+".png");
		//String screenshotpath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		File f=new File(screenshotpath);
		if(f.exists())
		{
			try
			{
				test.fail("Screenshot is below : "+ test.addScreenCaptureFromPath(screenshotpath));
				
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
		test=extent.createTest((result.getName()));
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

}
