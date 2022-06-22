package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;


public abstract class BasicTest {

    public WebDriver driver;

    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    protected CitiesPage citiesPage;
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected MessagePopUpPage messagePopUpPage;
    protected SignupPage signupPage;


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
        driver.manage().window().maximize();
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
