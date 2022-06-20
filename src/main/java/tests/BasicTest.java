package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;


public class BasicTest {

    public WebDriver driver;

    private String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    private CitiesPage citiesPage;
    private LoginPage loginPage;
    private NavPage navPage;
    private MessagePopUpPage messagePopUpPage;
    private SignupPage signupPage;


    @BeforeClass
    public void beforeClass() {

        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        citiesPage = new CitiesPage(driver);
        loginPage = new LoginPage(driver);
        navPage = new NavPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
        signupPage = new SignupPage(driver);

    }


    @BeforeMethod

    public void beforeMethod() {
        driver.get(baseUrl);
    }


    @Test

    @AfterMethod
    public void afterMethod() {

    }

    @AfterClass
    public void afterClass() {

//        driver.quit();

    }


}
