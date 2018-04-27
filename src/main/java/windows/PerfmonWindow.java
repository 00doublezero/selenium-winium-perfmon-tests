package windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerfmonWindow extends AbstractWindow {
    public PerfmonWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Close")
    private WebElement closeButton;

    public void close() {
        closeButton.click();
    }
}
