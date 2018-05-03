package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.winium.WiniumDriver;

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

    /*@FindBy(xpath="//*[@ClassName = 'MMCMainFrame']/*[@ClassName = '#32770']/*[@Name='Counter detail level:']")
    private WebElement countersListUpButton;*/

    //private WebElement countersListUpButton = perfmonMain.findElement(By.xpath("//*[@ClassName = '#32770']/*[@Name='Counter detail level:']/*[@Name='Vertical']"));


    @FindBy(xpath="//*[@ClassName = 'MMCMainFrame']/*[@ClassName = '#32770']/*[@AutomationId='1006']/*[@AutomationId='NonClientVerticalScrollBar']/*[@AutomationId='UpButton']")
    private WebElement countersListUpButton;

/*
    @FindBy(xpath="//*[@ClassName = 'MMCMainFrame']/*[@ClassName = '#32770']//*[@Name='Line up']")
    private WebElement countersListUpButton;
*/
    public void closeMoadl(){
        closeModalButton.click();
    }

    public void scrollToPhysicalDiskCounterItem() throws InterruptedException {
        //try {} catch (e) {}
        /*synchronized (driver){
            driver.wait(2000);
        }*/
        Thread.sleep(5000);
        //WebElement countersListUpButton = perfmonMain.findElement(By.xpath("//*[@ClassName = '#32770']/*[@Name='Counter detail level:']/*[@Name='Vertical']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("UpButton")));
        //driver.
        countersListUpButton.click();
        System.out.println(countersListUpButton.getAttribute("Name"));
    }
    public boolean AddCountersModalIsDisplayed() {
        try { return AddCountersModalWindow.isDisplayed();} catch(NoSuchElementException e) {return false;}
    }
}
