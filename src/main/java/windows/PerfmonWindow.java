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

    @FindBy(id="Maximize")
    private WebElement maximizeButton;

    public boolean perfmonIsDisplayed() {
        return closeButton.isDisplayed();
    }

    public void maximizeRestoreToggle() {
        maximizeButton.click();
    }

    public boolean windowIsMaximized() {
        boolean result;
        String maximizeButtonTitleText = maximizeButton.getAttribute("Name");
        if (maximizeButtonTitleText.equals("Restore")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public void close() {
        closeButton.click();
    }
}
