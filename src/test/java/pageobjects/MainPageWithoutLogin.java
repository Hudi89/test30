package pageobjects;

import base.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by hudi on 2017.04.19..
 */
public class MainPageWithoutLogin extends BasePageObject {
    private By loginMenuLocator2 = By.xpath("//a[@class='login-menu']");

    public MainPageWithoutLogin(WebDriver driver) {
        super(driver);
    }

    public ExpectedCondition<WebElement> getInitializationCondition() {
        return ExpectedConditions.visibilityOfElementLocated(loginMenuLocator2);
    }

    public static MainPageWithoutLogin open(WebDriver driver){
        driver.get("http://doodle.com/");
        return new MainPageWithoutLogin(driver);
    }

    public LoginPopup openLoginPopup(){
        waitAndGet(loginMenuLocator2).click();
        return (LoginPopup) new LoginPopup(driver).init();
    }
}
