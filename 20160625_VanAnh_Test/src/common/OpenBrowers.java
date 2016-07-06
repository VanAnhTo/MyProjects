package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class OpenBrowers {
	public static void multi_browser(String browser) throws Exception{
		//Firefox
		if (browser.equalsIgnoreCase("firefox")) {
			Util.driver = new FirefoxDriver();
			Util.driver.manage().window().maximize();
		//Chrome	
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Util.CHROME_DRIVER);
			Util.driver = new ChromeDriver();	
			Util.driver.manage().window().maximize();
		//CocCoc	
		} else if (browser.equalsIgnoreCase("coccoc")) {
			System.setProperty("webdriver.chrome.driver",
					Util.CHROME_DRIVER);			
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setBinary(Util.COCOC_PATH);
			Util.driver = new ChromeDriver(options);					
		//IE	
		} else if (browser.equalsIgnoreCase("ie")) {
			 System.setProperty("webdriver.ie.driver", Util.IE_DRIVER);			  
			  
			  DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			  caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			  caps.setCapability("nativeEvents",false);
			  Util.driver = new InternetExplorerDriver(caps);			  			  
			  Util.driver.manage().window().maximize();
		//Other	
		} else {
			throw new IllegalArgumentException("The Browser Type is undefined");
		}		
		Util.driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);				
	}	
}
