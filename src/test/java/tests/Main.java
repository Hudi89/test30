package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        MainPageWithoutLogin mainPageWithoutLogin = MainPageWithoutLogin.open(driver);
        LoginPopup loginPopup = mainPageWithoutLogin.openLoginPopup();
        MainPage mainPage = loginPopup.login("hudi89@elte.hu","test");
        assertTrue("Bad Username after logged in. ",mainPage.getUsername().equals("Peter"));
    }

    @Test
    public void testCreateChoice(){
        MainPageWithoutLogin mainPageWithoutLogin = MainPageWithoutLogin.open(driver);
        LoginPopup loginPopup = mainPageWithoutLogin.openLoginPopup();
        MainPage mainPage = loginPopup.login("hudi89@elte.hu","test");

        ChoicePage choicePage = mainPage.clickToMakeAChoiceButton();
        CreationFinishedPage finishedPage = choicePage.createAChoice("test",new ArrayList<String>(Arrays.asList("A","B","C")));
        wait.until(finishedPage.getInitializationCondition());
    }
}
