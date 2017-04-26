import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by hudi on 2017.04.26..
 */
public class ChoicePage {
    WebDriver driver;
    Wait<WebDriver> wait;

    By titleInputLocator = By.id("title");
    By nextButton1Locator = By.id("next1");
    private By next2dLocator = By.id("next2d");
    private By next3sLocator = By.id("next3s");;
    private By finish4aLocator= By.id("finish4a");


    public ChoicePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public CreationFinishedPage createAnChoice(String title, List<String> choices){
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(titleInputLocator));
        titleInput.sendKeys(title);

        driver.findElement(nextButton1Locator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to0")));

        int counter = 0;
        for(String choice : choices){
            driver.findElement(By.id("to"+counter)).sendKeys(choice);
            counter++;
        }
        driver.findElement(next2dLocator).click();

        WebElement next3sButton = wait.until(ExpectedConditions.visibilityOfElementLocated(next3sLocator));
        next3sButton.click();

        WebElement finish4AButton = wait.until(ExpectedConditions.visibilityOfElementLocated(finish4aLocator));
        finish4AButton .click();
        return new CreationFinishedPage(driver);
    }
}
