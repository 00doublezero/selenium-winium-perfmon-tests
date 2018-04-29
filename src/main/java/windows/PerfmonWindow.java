package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerfmonWindow extends AbstractWindow {
    public PerfmonWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']/*[@LocalizedControlType = 'title bar']/*[@Name = 'Close']")
    private WebElement closeButton;
    
    @FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']/*[@LocalizedControlType = 'title bar']/*[@Name = 'Maximize']")
    private WebElement maximizeButton;

    @FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']/*[@LocalizedControlType = 'title bar']/*[@Name = 'Restore']")
    private WebElement restoreButton;

    public boolean perfmonIsDisplayed() {
        return closeButton.isDisplayed();
    }

    public void maximizeRestoreToggle() {
        maximizeButton.click();
    }

    public boolean windowIsMaximized() {
        //boolean result;
        //boolean maximizeButtonTitleText =  driver.findElement(By.xpath("//*[@ClassName = 'MMCMainFrame']/*[@LocalizedControlType = 'title bar']/*[@Name = 'Restore']")).isDisplayed();
        try { return restoreButton.isDisplayed();} catch(NoSuchElementException e) {return false;}

        /*if (maximizeButtonTitleText) {
            result = true;
        } else {
            result = false;
        }
        return result;*/
    }

    public void close() {
        closeButton.click();
    }
}
