package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

/**
 * Created by hudi on 2017.04.19..
 */
public class MainPage extends BasePageObject {
    By toAccountLocator =  By.className("to-account");
    By makeAChoiceLocator = By.xpath("//div[@class='createNewArea makeChoice']//a");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ExpectedCondition<WebElement> getInitializationCondition() {
        return ExpectedConditions.visibilityOfElementLocated(toAccountLocator);
    }

    public String getUsername() {
        WebElement accountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(toAccountLocator));
        return accountButton.getText();
    }


    public ChoicePage clickToMakeAChoiceButton(){
        waitAndGet(makeAChoiceLocator).click();
        return (ChoicePage)new ChoicePage(driver).init();
    }
}
