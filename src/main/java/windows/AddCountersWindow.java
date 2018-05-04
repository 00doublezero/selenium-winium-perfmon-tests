package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.winium.WiniumDriver;

import java.util.List;

public class AddCountersWindow extends AbstractPerfmonWindow {
    public AddCountersWindow(WiniumDriver driver) {
        super(driver);
    }
    /*@FindBy(xpath="//*[@ClassName = 'MMCMainFrame']/*[@ClassName = '#32770']")
    private WebElement AddCountersModalWindow;*/
    private WebElement AddCountersModalWindow = perfmonMain.findElement(By.xpath("//*[@ClassName = '#32770']"));

    /*@FindBy(xpath="//*[@ClassName = 'MMCMainFrame']/*[@ClassName = '#32770']/*[@LocalizedControlType='title bar']/*[@Name='Close']")
    private WebElement closeModalButton;*/

    private WebElement closeModalButton = perfmonMain.findElement(By.xpath("//*[@ClassName = '#32770']/*[@LocalizedControlType='title bar']/*[@Name='Close']"));

    @FindBy(xpath="//*[@ClassName = '#32770']/*[@AutomationId='1006']/*[@Name='Vertical Scroll Bar']/*[@Name='Back by large amount']")
    private WebElement countersListUpButton;

    @FindBy(xpath="//*[@ClassName = '#32770']/*[@AutomationId='1006']/*[@Name='Vertical Scroll Bar']/*[@Name='Forward by large amount']")
    private WebElement countersListDownButton;

    private WebElement scrollStartingPoint = perfmonMain.findElement(By.xpath("//*[@ClassName = '#32770']/*[@AutomationId='1006']/*[@Name='Processor']"));
    private WebElement scrollEndPoint = perfmonMain.findElement(By.xpath("//*[@ClassName = '#32770']/*[@AutomationId='1006']/*[@Name='PhysicalDisk']"));

    private WebElement addToWatchListButton = AddCountersModalWindow.findElement(By.xpath("//*[@AutomationId = '1014']"));
    private WebElement addCountersModalWindowOkButton = AddCountersModalWindow.findElement(By.xpath("//*[@AutomationId = '1']"));

    public void closeMoadl(){
        closeModalButton.click();
    }

    public boolean scrollToPhysicalDiskCounterItem() {
        boolean endPointVisible = false;
        int i = 0;
        wait.until(ExpectedConditions.visibilityOf(scrollStartingPoint));

        while (i<6) {
            if (scrollEndPoint.isDisplayed()) {
                endPointVisible = true;
                break;
            } else {
                i++;
                countersListUpButton.click();
            }

        }
        return endPointVisible;
    }
    public void physicalDiskClick() {
        action.doubleClick(scrollEndPoint).perform();
        //scrollEndPoint.click();
    }

    public void selectWriteByteSecCounter() {
        WebElement scrollEndPointCounterItem = scrollEndPoint.findElement(By.xpath("//*[@Name ='Disk Write Bytes/sec']"));
        countersListDownButton.click();
        countersListDownButton.click();
        wait.until(ExpectedConditions.visibilityOf(scrollEndPointCounterItem));
        scrollEndPointCounterItem.click();
        addToWatchListButton.click();
        addCountersModalWindowOkButton.click();
    }

    public boolean AddCountersModalIsDisplayed() {
        try { return AddCountersModalWindow.isDisplayed();} catch(NoSuchElementException e) {return false;}
    }
}
