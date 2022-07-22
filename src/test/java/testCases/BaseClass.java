package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import utilities.ReadConfig;


//import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{
	/*--------Hardcoding in Base Class-------
	public String baseURL="https://demo.guru99.com/V4/";
	public String username="mngr164225";
	public String password="jahetAp";  */
	
	//---Reading details from ReadConfig.java class  (config.properties)----
	ReadConfig rc=new ReadConfig();
	public String baseURL=rc.getAppURL();
	public String username=rc.getUserName();
	public String password=rc.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(@Optional("chrome")String brw)
	{
		//WebDriverManager.chromedriver().setup();
		logger=Logger.getLogger(BaseClass.class.getName());
		//logger=Logger.getLogger("Banking_Project");
		//logger=Logger.getLogger("eBanking Project");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(brw.equals("chrome"))
		{
			
		System.setProperty("webdriver.chrome.driver",rc.getChromePath());
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.println(rc.getChromePath());
		
		}
		else if(brw.equals("firefox"))
		{
		System.setProperty("webdriver.gecko.driver",rc.getFirefoxPath());
		driver = new FirefoxDriver();
		}
		else if(brw.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver",rc.getEdgePath());
		driver = new EdgeDriver();
		}				
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
