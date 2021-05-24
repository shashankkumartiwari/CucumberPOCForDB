package com.db.StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import com.db.common.BaseUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Hook extends BaseUtil {

	private BaseUtil base;

	public Hook(BaseUtil base) {
		this.base = base;
	}

/*	@Before
	public void InitializeTest() {
		// These drivers are currently running on Selenium 3.14.0
		long threadId = Thread.currentThread().getId();
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
	}*/

	@Before("@Firefox")
	public void SetupFirefox(Scenario scenario) {
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		base.Driver = new FirefoxDriver();
		base.Driver.manage().window().maximize();
		base.executionMode = "Desktop";
	//	base.selectedBrowser = "Firefox";
		str = (List<String>) scenario.getSourceTagNames();
	}

	@Before("@Desktop")
	public void SetupChrome(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		base.Driver = new ChromeDriver(); 
		base.executionMode = "Desktop";
	//	base.selectedBrowser = "Chrome";
		base.Driver.manage().window().maximize();
		str = (List<String>) scenario.getSourceTagNames();
	}

	@Before("@HeadlessChrome")
	public void SetupHeadlessChrome(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1900x1020");
		base.Driver = new ChromeDriver(options);
		base.executionMode = "Desktop";
		//base.selectedBrowser = "Chrome";
		str = (List<String>) scenario.getSourceTagNames();
	}

	@Before("@HeadlessFirefox")
	public void SetupHeadlessFirefox(Scenario scenario) {
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		base.Driver = new FirefoxDriver(firefoxOptions);
		base.executionMode = "Desktop";
		//base.selectedBrowser = "Firefox";
		str = (List<String>) scenario.getSourceTagNames();
	}
	
	@Before("@Edge")
	public void SetupEdge(Scenario scenario) {
		System.setProperty("webdriver.edge.driver", "Drivers\\MicrosoftWebDriver.exe");
		base.Driver = new EdgeDriver();
		base.Driver.manage().window().maximize();
		base.executionMode = "Desktop";
		//base.selectedBrowser = "Edge";
		str = (List<String>) scenario.getSourceTagNames();
	}

	@Before("@IE")
	public void SetupIE(Scenario scenario) {
		System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
		base.Driver = new InternetExplorerDriver();
		base.Driver.manage().window().maximize();
		base.executionMode = "Desktop";
		//base.selectedBrowser = "IE";
		str = (List<String>) scenario.getSourceTagNames();
	}

	@Before("@Safari")
	public void SetupSafari() {
		// This Safari Driver has not been tested, and will look for a local
		// driver source. Remote automation must be enabled.
		base.Driver = new SafariDriver();
		base.Driver.manage().window().maximize();
	//	base.selectedBrowser = "Safari";
	}

	@Before("@Mobile")
	public void SetupAndroidChromeMobile() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Omni Mobile");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		// cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		// disable the keyboard on your android selenium
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		try {
			base.Driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			base.executionMode = "Android Mobile";
		//	base.selectedBrowser = "Chrome";
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}

	}

	@Before("@Tab")
	public void SetupAndroidChromeTab() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		// cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		// disable the keyboard on your android selenium
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		base.Driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		base.executionMode = "AndroidTab_VerticalView";
	//	base.selectedBrowser = "Chrome";
	}

	@After("@Desktop")
	public void TearDownTestforDesktop(Scenario scenario) throws IOException {
		// This takes a screenshot from the driver at save it to the cucumber
				// pretty reports
				try {
					TakesScreenshot ts = (TakesScreenshot) base.Driver;
					File Screenshot = ts.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(Screenshot,
							new File(Screenshot.getAbsolutePath() + "_" + scenario.getName() + scenario.getId() + ".png"));
	                
					byte[] screenshot = Files.readAllBytes(Screenshot.toPath());
					scenario.embed(screenshot, "image/png"); 
				//	base.Driver.quit();
				}catch(Exception e) {
					//base.Driver.quit();
				}
				catch(Error err) {
				//	base.Driver.quit();
				}
				catch(Throwable t) {
				//	base.Driver.quit();
				}
			}
	

	@After("@HeadlessChrome")
	public void TearDownTestforHeadlessChrome(Scenario scenario) throws IOException {
		// This takes a screenshot from the driver at save it to the cucumber
		// pretty reports
		try{TakesScreenshot ts = (TakesScreenshot) base.Driver;
		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot,
				new File(Screenshot.getAbsolutePath() + "_" + scenario.getName() + scenario.getId() + ".png"));

		byte[] screenshot = Files.readAllBytes(Screenshot.toPath());
		scenario.embed(screenshot, "image/png");
		base.Driver.quit();
		}catch(Exception e) {base.Driver.quit();}
		 catch(Error err) {base.Driver.quit();}
		 catch(Throwable t) {base.Driver.quit();}
	}
	
	@After("@HeadlessFirefox")
	public void TearDownTestforHeadlessFirefox(Scenario scenario) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) base.Driver;
		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot,
				new File(Screenshot.getAbsolutePath() + "_" + scenario.getName() + scenario.getId() + ".png"));

		byte[] screenshot = Files.readAllBytes(Screenshot.toPath());
		scenario.embed(screenshot, "image/png");
		base.Driver.quit();
	}

	@After("@Mobile")
	public void TearDownTestforMobile(Scenario scenario) throws IOException {
		 base.Driver.quit();
	}

	@After("@Tab")
	public void TearDownTestforTab(Scenario scenario) throws IOException {
		base.Driver.quit();
	}

	@After("@IE")
	public void TearDownTestforIE(Scenario scenario) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) base.Driver;

		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot,
				new File(Screenshot.getAbsolutePath() + "_" + scenario.getName() + scenario.getId() + ".png"));

		byte[] screenshot = Files.readAllBytes(Screenshot.toPath());
		scenario.embed(screenshot, "image/png");
		base.Driver.quit();
	}

	@After("@Firefox")
	public void TearDownTestforFF(Scenario scenario) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) base.Driver;

		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot,
				new File(Screenshot.getAbsolutePath() + "_" + scenario.getName() + scenario.getId() + ".png"));

		byte[] screenshot = Files.readAllBytes(Screenshot.toPath());
		scenario.embed(screenshot, "image/png");
		base.Driver.quit();
	}

	@Before("@HeadlessFF")
	public void SetupHeadlessFF() {
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		options.addArguments("window-size=1900x1020");
		// Instantiate Web Driver
		base.Driver = new FirefoxDriver(options);
		base.executionMode = "Desktop";
	//	base.selectedBrowser = "Firefox";
	}

	@After("@HeadlessFF")
	public void TearDownTestforHeadFF(Scenario scenario) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) base.Driver;

		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot,
				new File(Screenshot.getAbsolutePath() + "_" + scenario.getName() + scenario.getId() + ".png"));

		byte[] screenshot = Files.readAllBytes(Screenshot.toPath());
		scenario.embed(screenshot, "image/png");
		base.Driver.quit();
	}

	@After("@Edge")
	public void TearDownTestforEdge(Scenario scenario) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) base.Driver;

		File Screenshot = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screenshot,
				new File(Screenshot.getAbsolutePath() + "_" + scenario.getName() + scenario.getId() + ".png"));

		byte[] screenshot = Files.readAllBytes(Screenshot.toPath());
		scenario.embed(screenshot, "image/png");
		base.Driver.quit();
	}
}