package windows;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.winium.WiniumDriver;

public abstract class AbstractWindow {
    protected final WebDriverWait wait;
    protected WiniumDriver driver;
    protected Actions action;

    public AbstractWindow(WiniumDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver,this);
    }
}
