import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by hudi on 2017.04.26..
 */
public class CreationFinishedPage {
    WebDriver driver;
    Wait<WebDriver> wait;
    private By participationLinkLocator = By.id("participationLink");

    public CreationFinishedPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public ExpectedCondition<List<WebElement>> getInitializationCondition(){
        return ExpectedConditions.visibilityOfAllElementsLocatedBy(participationLinkLocator);
    }
}
