package windows;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class AbstractPerfmonWindow extends AbstractWindow {
    public AbstractPerfmonWindow(WiniumDriver driver) {
        super(driver);
    }

    protected WebElement perfmonMain = driver.findElementByClassName("MMCMainFrame");
    //protected WebElement perfmonMain = driver.

    //protected WebElemet asdad = driver.
}
