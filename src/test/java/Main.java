import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by hudi on 2017.04.19..
 */
public class Main {
    private static WebDriver driver;
    private static Wait<WebDriver> wait;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,5);
    }

    @After
    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin(){
        MainPageWithoutLogin mainPageWithoutLogin = new MainPageWithoutLogin(driver);
        LoginPopup loginPopup = mainPageWithoutLogin.openLoginPopup();
        MainPage mainPage = loginPopup.login("hudi89@elte.hu","test");
        assertTrue("Bad Username after logged in. ",mainPage.getUsername().equals("Peter"));
    }
}
