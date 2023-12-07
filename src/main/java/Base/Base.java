package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;


	@SuppressWarnings("deprecation")
	public void invokeBrowser() {
		prop = new Properties();

		try {
			prop.load(new FileInputStream(
					"src/main/java/Config/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		if (prop.getProperty("browserName").matches("chrome")) {
			//WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
		}

	
		if (prop.getProperty("browserName").matches("firefox")) {
			driver = new FirefoxDriver();
		}

	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

	}


	public void openURL() {
		driver.get(prop.getProperty("websiteURLKey"));
	}


	public void reportFail(String report) {
		logger.log(Status.FAIL, report);
	}


	public void reportPass(String report) {
		logger.log(Status.PASS, report);
	}


	public void wait(Duration i, By locator) {
		wait = new WebDriverWait(driver, i);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public void endReport() {
		report.flush();
	}


	public void closeBrowser() throws IOException {
		driver.quit();
	}

}
