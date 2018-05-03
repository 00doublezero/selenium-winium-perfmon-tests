package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.winium.WiniumDriver;

public class PerfmonWindow extends AbstractPerfmonWindow {
    public PerfmonWindow(WiniumDriver driver) {
        super(driver);
    }

    /*@FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']/*[@LocalizedControlType = 'title bar']/*[@Name = 'Close']")
    private WebElement closeButton;*/
    private WebElement closeButton = perfmonMain.findElement(By.xpath("//*[@LocalizedControlType = 'title bar']/*[@Name = 'Close']"));
    //private WebElement asdas = driver.
    
    /*@FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']/*[@LocalizedControlType = 'title bar']/*[@Name = 'Maximize']")
    private WebElement maximizeButton;*/

    private WebElement maximizeButton = perfmonMain.findElement(By.xpath("//*[@LocalizedControlType = 'title bar']/*[@Name = 'Maximize']"));

    /*@FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']/*[@LocalizedControlType = 'title bar']/*[@Name = 'Restore']")
    private WebElement restoreButton;*/

    private WebElement restoreButton = perfmonMain.findElement(By.xpath("//*[@LocalizedControlType = 'title bar']/*[@Name = 'Restore']"));

    /*@FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']//*[@Name = 'Performance']//*[@Name='Performance Monitor']")
    private WebElement perfmonTreeItem;*/

    private WebElement perfmonTreeItem = perfmonMain.findElement(By.xpath("//*[@Name = 'Performance']//*[@Name='Performance Monitor']"));

    @FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']//*[@ClassName = 'Hatchwin']/*[@ClassName = 'SysmonCtrl']/*[@ClassName = 'ToolbarWindow32']")
    private WebElement perfmonSysWindow;

    //private WebElement perfmonSysWindow = perfmonMain.findElement(By.xpath("//*[@ClassName = 'Hatchwin']/*[@ClassName = 'SysmonCtrl']/*[@ClassName = 'ToolbarWindow32']"));

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
