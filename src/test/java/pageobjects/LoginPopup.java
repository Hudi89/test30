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
public class LoginPopup extends BasePageObject {

    By usernameInputLocator = By.id("logisterEmail");
    By passwordInputLocator = By.id("logisterPassword");

    public LoginPopup(WebDriver driver) {
        super(driver);
    }

    public ExpectedCondition<WebElement> getInitializationCondition() {
        return ExpectedConditions.visibilityOfElementLocated(usernameInputLocator);
    }

    public MainPage login(String username, String password) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocator));
        WebElement passwordInput = driver.findElement(passwordInputLocator);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        usernameInput.submit();

        return (MainPage) new MainPage(driver).init();
    }
}
