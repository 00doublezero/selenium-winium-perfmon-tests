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
    
    @FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']//*[@Name = 'Performance']//*[@Name='Performance Monitor']")
    private WebElement perfmonTreeItem;

    @FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']//*[@ClassName = 'Hatchwin']/*[@ClassName = 'SysmonCtrl']/*[@ClassName = 'ToolbarWindow32']")
    private WebElement perfmonSysWindow;

    public void sysmonTreeItemClick() {
        perfmonTreeItem.click();
    }

    public boolean perfmonIsDisplayed() {
        return closeButton.isDisplayed();
    }

    public void maximizeRestoreToggle() {
        maximizeButton.click();
    }

    public boolean windowIsMaximized() {
        try { return restoreButton.isDisplayed();} catch(NoSuchElementException e) {return false;}
    }

    public boolean perfmonWinIsDisplayed() {
        try { return perfmonSysWindow.isDisplayed();} catch(NoSuchElementException e) {return false;}   
    }

    public void close() {
        closeButton.click();
    }
}
