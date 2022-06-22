package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getEmailInput() {
        return driver
                .findElement(By.id("email"));

    }

    public WebElement getPasswordInput() {
        return driver
                .findElement(By.id("password"));

    }

    public WebElement getLoginButton() {
        return driver
                .findElement(By.xpath("//button[@type='submit']"));

    }

    public void waitForHomePageToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/home"));
    }
}
