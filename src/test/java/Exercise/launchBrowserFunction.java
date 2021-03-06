package Exercise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class launchBrowserFunction {
	public String URL;
	private WebDriver driver = null;
	private String rootPath = System.getProperty("user.dir");
	private final String referencesPath = "/src/test/resources/webdriver/";

	public launchBrowserFunction(String u) {
		URL = u;
	}

	public WebDriver launchBrowser(String browserName) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", rootPath + referencesPath + "chromedriver");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", rootPath + referencesPath + "geckodriver");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Sorry, this browser is invalid");
			break;
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}
	public void quitBrowser() {
		driver.quit();
	}

}
