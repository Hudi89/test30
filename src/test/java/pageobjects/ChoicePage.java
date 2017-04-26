package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by hudi on 2017.04.26..
 */
public class ChoicePage extends BasePageObject {
    By titleInputLocator = By.id("title");
    By nextButton1Locator = By.id("next1");
    private By next2dLocator = By.id("next2d");
    private By next3sLocator = By.id("next3s");;
    private By finish4aLocator= By.id("finish4a");


    public ChoicePage(WebDriver driver) {
        super(driver);
    }

    public ExpectedCondition<WebElement> getInitializationCondition() {
        return ExpectedConditions.visibilityOfElementLocated(titleInputLocator);
    }

    public CreationFinishedPage createAChoice(String title, List<String> choices){
        waitAndGet(titleInputLocator).sendKeys(title);

        driver.findElement(nextButton1Locator).click();
        waitAndGet(By.id("to0"));

        int counter = 0;
        for(String choice : choices){
            driver.findElement(By.id("to"+counter)).sendKeys(choice);
            counter++;
        }
        driver.findElement(next2dLocator).click();

        waitAndGet(next3sLocator).click();


        waitAndGet(finish4aLocator).click();
        return (CreationFinishedPage) new CreationFinishedPage(driver).init();
    }
}
