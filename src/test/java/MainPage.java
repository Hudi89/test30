import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * Created by hudi on 2017.04.19..
 */
public class MainPage {
    WebDriver driver;
    Wait<WebDriver> wait;

    By toAccountLocator =  By.className("to-account");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public String getUsername() {
        WebElement accountButton = wait.until(ExpectedConditions.visibilityOfElementLocated(toAccountLocator));
        return accountButton.getText();
    }
}
