package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by hudi on 2017.04.26..
 */
public abstract class BasePageObject {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public abstract ExpectedCondition<WebElement> getInitializationCondition();
    public BasePageObject init(){
        wait.until(getInitializationCondition());
        return this;
    }

    public WebElement waitAndGet(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
