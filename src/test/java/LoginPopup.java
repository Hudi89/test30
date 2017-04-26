import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by hudi on 2017.04.26..
 */
public class LoginPopup {
    WebDriver driver;
    Wait<WebDriver> wait;

    By usernameInputLocator = By.id("logisterEmail");
    By passwordInputLocator = By.id("logisterPassword");

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public MainPage login(String username, String password) {
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocator));
        WebElement passwordInput = driver.findElement(passwordInputLocator);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        usernameInput.submit();

        return new MainPage(driver);
    }
}
