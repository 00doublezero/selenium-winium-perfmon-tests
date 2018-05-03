import helpers.DriverProvider;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import windows.AddCountersWindow;
import windows.PerfmonWindow;
import windows.PerformanceMonitor;

import java.net.MalformedURLException;

public class perfmonWiniumTests {
    private WiniumDriver driver;
    private PerfmonWindow pwin;
    private PerformanceMonitor pmon;
    private AddCountersWindow addCountWin;
    @BeforeTest
    public void initWinium() throws MalformedURLException {
        driver = DriverProvider.getDriver("C://windows//system32//perfmon.msc",
                "9999",
                7);

    }
    @Test(description="Launch the perfmon", priority=1)
    public void openPerfmon() {
        pwin = new PerfmonWindow(driver);
        Assert.assertTrue(pwin.perfmonIsDisplayed(),"The window was not displayed.");
    }

    @Test(description="Maximize the window", priority=2)
    public void maximizeWindow() {
        //String maximizeTooltipText = "Restore";
        pwin.maximizeRestoreToggle();
        //Thread.sleep(2000);
        Assert.assertEquals(pwin.windowIsMaximized(),true,"The window was not maximized.");
    }

    @Test(description = "Open system monitor page", priority=3)
    public void openSysMon() throws InterruptedException {
        pwin.sysmonTreeItemClick();
        //Thread.sleep(2000);
        Assert.assertTrue(pwin.perfmonWinIsDisplayed(),"The performance monitor was not displayed.");
    }

    @Test(description = "Delete processor time counter", priority=4)
    public void processorTimeDelete() throws InterruptedException {
        pmon = new PerformanceMonitor(driver);
        pmon.deleteCounters("% Processor Time");
        Assert.assertTrue(pmon.counterCounters("% Processor Time") == 0,"Counter \"% Processor Time\" was not delete from counter Legend.");
    }

    @Test(description = "Add disk counter to legend",priority = 5)
    public void addDiskCounter() throws InterruptedException {
        pmon.openCountersWindow();
        addCountWin = new AddCountersWindow(driver);
        Assert.assertTrue(addCountWin.AddCountersModalIsDisplayed(),"Modal is not displayed");
        //addCountWin.closeMoadl();
        Thread.sleep(5000);
        while(true) {
            addCountWin.scrollToPhysicalDiskCounterItem();
        }
    }

    @Test(priority=6)
    public void closeWindow() {
        pwin.close();
    }

    @AfterTest
    public void closeWimium() {
        try {
            driver.quit();
        } catch (WebDriverException e) {
        }
    }
}