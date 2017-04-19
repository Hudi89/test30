import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by hudi on 2017.04.19..
 */
public class MainPageWithoutLogin {
    WebDriver driver;
    Wait<WebDriver> wait;

    By usernameInputLocator = By.id("logisterEmail");
    By passwordInputLocator = By.id("logisterPassword");


    public MainPageWithoutLogin(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public MainPage login(String username, String password) {
        driver.get("http://doodle.com/");

        driver.findElement(By.xpath("//a[@class='login-menu']")).click();

        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInputLocator));
        WebElement passwordInput = driver.findElement(passwordInputLocator);

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);

        usernameInput.submit();

        return new MainPage(driver);
    }
}
