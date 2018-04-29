package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverProvider {

	private static WebDriver driver;

    private DriverProvider () { }

    public static WebDriver getDriver(String appPath, String port, int implWait) throws MalformedURLException {
    	if (driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("app",appPath);
            cap.setCapability("launchDelay",5000);
            //cap.setCapability("args":"");
            driver = new RemoteWebDriver(new URL("http://localhost:" + port), cap);
            return driver;
    	}
    	return driver;
    }
}
