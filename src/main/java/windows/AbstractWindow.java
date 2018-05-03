package windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.winium.WiniumDriver;

public abstract class AbstractWindow {
    protected final WebDriverWait wait;
    protected WiniumDriver driver;

    public AbstractWindow(WiniumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 7);
        PageFactory.initElements(driver,this);
    }
}
