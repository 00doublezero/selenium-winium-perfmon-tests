package windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractWindow {
    private final WebDriverWait wait;
    protected WebDriver driver;

    public AbstractWindow(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 7);
        PageFactory.initElements(driver,this);
    }
}
