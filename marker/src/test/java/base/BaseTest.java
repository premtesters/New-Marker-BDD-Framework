package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class BaseTest  {

	public static WebDriver driver;
	
	//Setup method
	
	public static String path= System.getProperty("user.dir")+"\\src\\main\\resources\\propertyFile\\config.properties";
	public static Properties prop = new Properties();
	
	public static void intialization() throws IOException {
		
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		String chromeDriverPath =System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\Chrome Driver\\chromedriver.exe";
		String edgeDriverPath= System.getProperty("user.die")+"\\src\\test\\resources\\driver\\Edge Driver\\msedgedriver.exe";
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("force-device-scale-factor=1.0");
			
			// Disable Chrome's password manager and credentials service
	        options.addArguments("--disable-save-password-bubble");
	        options.addArguments("--disable-notifications");

	        // Also disable Safe Browsing password leak warning
	        options.addArguments("--disable-features=PasswordCheck");
			driver = new ChromeDriver(options);
			break;
			
		case "edge":
		    System.setProperty("webdriver.edge.driver", edgeDriverPath);
		    driver = new EdgeDriver();
		    break;
		    
		default:
		     System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			 ChromeOptions options1 = new ChromeOptions();
			 options1.addArguments("force-device-scale-factor=0.60");
			 driver = new ChromeDriver(options1);
			 break;
		    	
		
		}
	}
	
	public String getUrl() {
		
		String urls = prop.getProperty("url");
		return urls;
	}
	
	// Tears down method
	public static void quitDriver() {
		if(driver !=null) {
			driver.quit();
			driver=null;
		}
	}
	
	// use it for to avoid null driver 
	public static WebDriver getDriver() {
		
		return driver;
	}
	
	@After(order = 1)
	public void takeScraenshotOnFailure(Scenario scenario) {

	if (scenario.isFailed()) {

	TakesScreenshot ts = (TakesScreenshot) driver;

	byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	scenario.attach(src, "image/png", "screenshot");
	}

	}
	
}