package helpers;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverProvider {

	private static WiniumDriver driver;

    private DriverProvider () { }

    public static WiniumDriver getDriver(String appPath, String port, int implWait) throws MalformedURLException {
    	if (driver == null) {
            DesktopOptions op = new DesktopOptions();
            op.setApplicationPath(appPath);
            op.setLaunchDelay(1000);
            driver = new WiniumDriver(new URL("http://localhost:" + port), op);
            return driver;
    	}
    	return driver;
    }
}
