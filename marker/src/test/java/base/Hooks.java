package base;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.*;





public class Hooks extends BaseTest{

	WebDriver driver;
	 
    
	 //@Before
	public void setUp() throws IOException {
		
		BaseTest.intialization();
	}
	
	//@After
	public void tearDown() {
		
		BaseTest.quitDriver();
	}
	
	
	
	
	
}