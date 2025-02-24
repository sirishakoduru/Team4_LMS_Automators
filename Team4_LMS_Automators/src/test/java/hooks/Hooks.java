package hooks;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class Hooks {
	
	public static WebDriver driver;
	// DriverFactory df=new DriverFactory();

	@Before
	public void setup() throws Throwable {
		DriverFactory.initializeBrowser(ConfigReader.getProperty("browser"));
//		String browser = ConfigReader.getBrowserType();
		//DriverFactory.initializeBrowser(browser);

		driver = DriverFactory.getDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@After
	public void tearDown(Scenario scenario) throws Throwable {

		String scenarioName = scenario.getName().replaceAll(" ", "_");

		if (scenario.isFailed()) {
			LoggerLoad.error("Scenario is Failed and taking Screenshot");

			byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenShot, "image/png", scenarioName);

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File("target/screenshots/" + scenario.getName() + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Thread.sleep(3000);
		
		DriverFactory.quitDriver();
		//driver.quit();

	}

}
