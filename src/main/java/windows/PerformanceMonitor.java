package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.winium.WiniumDriver;

import java.util.List;

public class PerformanceMonitor extends AbstractPerfmonWindow  {
    public PerformanceMonitor(WiniumDriver driver) {
        super(driver);
    }

    /*@FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']//*[@ClassName = 'Hatchwin']/*[@ClassName= 'SysmonCtrl']/*[@ClassName = 'PerfLegend']/*[@ClassName='SysListView32']/*[@Name='Show']")
    private List<WebElement> perfCounters;*/

    private List<WebElement> perfCounters = perfmonMain.findElements(By.xpath("//*[@ClassName = 'Hatchwin']/*[@ClassName= 'SysmonCtrl']/*[@ClassName = 'PerfLegend']/*[@ClassName='SysListView32']/*[@Name='Show']"));

    /*@FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']//*[@ClassName = 'Hatchwin']/*[@ClassName= 'SysmonCtrl']/*[@ClassName = 'ToolbarWindow32']/*[5]")
    private WebElement counterDeleteButton;*/

    private WebElement counterDeleteButton = perfmonMain.findElement(By.xpath("//*[@ClassName = 'Hatchwin']/*[@ClassName= 'SysmonCtrl']/*[@ClassName = 'ToolbarWindow32']/*[5]"));

    /*@FindBy(xpath = "//*[@ClassName = 'MMCMainFrame']//*[@ClassName = 'Hatchwin']/*[@ClassName= 'SysmonCtrl']/*[@ClassName = 'ToolbarWindow32']/*[4]")
    private WebElement counterAddButton;*/

    private WebElement counterAddButton = perfmonMain.findElement(By.xpath("//*[@ClassName = 'Hatchwin']/*[@ClassName= 'SysmonCtrl']/*[@ClassName = 'ToolbarWindow32']/*[4]"));

    public void openCountersWindow() {
        counterAddButton.click();
    }

    public void deleteCounters(String counterName) throws InterruptedException {
    	for (WebElement perfCounter: perfCounters) {
    	    //сделать нормальнj
    		perfCounter.findElement(By.xpath("//*[@Name='"+ counterName +"']")).click();
            counterDeleteButton.click();
    	}
    }
    public int counterCounters(String counterName) {
        int i = 0;
        for (WebElement perfCounter: perfCounters) {
            if (perfCounter.findElement(By.xpath("//*[@Name]")).getAttribute("Name").equals(counterName)) {
                i++;
            }
            //perfCounter.findElement(By.xpath("//*[@Name='"+ counterName +"']")).click();
        }
        System.out.println(i);
        return i;
    }
}
