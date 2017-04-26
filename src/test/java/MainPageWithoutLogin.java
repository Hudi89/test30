import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by hudi on 2017.04.19..
 */
public class MainPageWithoutLogin {
    WebDriver driver;
    Wait<WebDriver> wait;



    public MainPageWithoutLogin(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public LoginPopup openLoginPopup(){
        driver.get("http://doodle.com/");
        driver.findElement(By.xpath("//a[@class='login-menu']")).click();

        return new LoginPopup(driver);
    }
}
