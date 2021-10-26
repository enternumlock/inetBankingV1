package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import javax.crypto.spec.RC2ParameterSpec;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

//BaseClass contain all the common things. 
//which are repeated or common in every test  
public class BaseClass {

	// 1. create object of ReadConfig class and call required method
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	public static WebDriver driver;

	/*
	 * URL: http://demo.guru99.com/V1/html/Managerhomepage.php User ID: mngr355189
	 * Password: AbEjYga //create local variables public String
	 * baseURL="http://demo.guru99.com/V1/index.php"; public String
	 * username="mngr355189"; public String password="AbEjYga"; public static
	 * WebDriver driver; public static Logger logger;
	 */

	public static Logger logger;

	// this method will run first
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) throws InterruptedException {

		// old hard coded
		// home directory path =
		// C:\\Users\\khali\\EclipseWorkspace2021\\Workspace-1\\inetBankingV1
		// System.getProperty("user.dir") will get home directory
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "\\Drivers\\chromedriver.exe");

		// for log4j object
		logger = Logger.getLogger("inetBankingV1");
		PropertyConfigurator.configure("Log4j.properties");

		// execute Test on desired BROWSER
		// new dynamic code
		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver = new InternetExplorerDriver();
			;
		} else if (br.equals("edge")) {
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		// wait time for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// take it out from TEST Case classes
		driver.get(baseURL);
		// to increase the size of browser screen
		// driver.manage().window().maximize();
	}

	// this method will run in last of the class
	@AfterClass
	public void tearDown() throws InterruptedException {
		driver.quit();
	}

	// Method For SCREEN SHOT
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	// create method that generates random string
	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8); // 8 characters
		return generatedstring;
	}

	// Create method to generate random number
	public static String randomNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4); // 4 characters
		return generatedString2;
	}

}
