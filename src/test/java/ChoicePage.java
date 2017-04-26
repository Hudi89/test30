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

    public ChoicePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }

    public CreationFinishedPage createAnChoice(String title, List<String> choices){
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title")));
        titleInput.sendKeys(title);

        driver.findElement(By.id("next1")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("to0")));

        int counter = 0;
        for(String choice : choices){
            driver.findElement(By.id("to"+counter)).sendKeys(choice);
            counter++;
        }

        driver.findElement(By.id("next2d")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("next3s")));
        driver.findElement(By.id("next3s")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish4a")));
        driver.findElement(By.id("finish4a")).click();
        return new CreationFinishedPage(driver);
    }
}
