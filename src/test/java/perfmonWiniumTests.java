import helpers.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import windows.PerfmonWindow;

import java.net.MalformedURLException;

public class perfmonWiniumTests {
    private WebDriver driver;
    private PerfmonWindow pwin;

    @BeforeTest
    public void initWinium() throws MalformedURLException {
        driver = DriverProvider.getDriver("C://windows//system32//perfmon.msc",
                "9999",
                7000);

    }

    @Test(description="Launch the perfmon", priority=1)
    public void openPerfmon() {
        Assert.assertTrue(pwin.perfmonIsDisplayed(),"The window was not displayed.");
    }
    @Test(description="Maximize the window", priority=2)
    public void maximizeWindow() {
        String maximizeTooltipText = "Restore";
        pwin.maximizeRestoreToggle();
        Assert.assertEquals(pwin.windowIsMaximized(),true,"The window was not maximized.");
    }

    @AfterTest
    public void closeWimium() {
        driver.quit();
    }
}

/*import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

/*public class perfmonWiniumTests {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        WiniumDriver driver = null;
        String appPath = "C:/windows/system32/calc.exe";
        DesktopOptions option = new DesktopOptions();
        option.setApplicationPath(appPath);
        option.setDebugConnectToRunningApp(false);
        option.setLaunchDelay(2);
        driver = new WiniumDriver(new URL("http://localhost:9999"),option);
        Thread.sleep(1000);
        WebElement window =  driver.findElementByClassName("CalcFrame");
        WebElement menuItem = window.findElement(By.id("MenuBar")).findElement(By.name("View"));
        menuItem.click();
        driver.findElementByName("Scientific").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("History").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("History").click();

        window.findElement(By.id("MenuBar")).findElement(By.name("View")).click();
        driver.findElementByName("Standard").click();

        driver.findElementByName("4").click();
        driver.findElementByName("Add").click();
        driver.findElementByName("5").click();
        driver.findElementByName("Equals").click();
        driver.close();
    }
}
*/