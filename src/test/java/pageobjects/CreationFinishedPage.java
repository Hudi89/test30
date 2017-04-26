package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by hudi on 2017.04.26..
 */
public class CreationFinishedPage extends BasePageObject {
    private By participationLinkLocator = By.id("participationLink");

    public CreationFinishedPage(WebDriver driver) {
        super(driver);
    }


    public ExpectedCondition<WebElement> getInitializationCondition(){
        return ExpectedConditions.visibilityOfElementLocated(participationLinkLocator);
    }
}
