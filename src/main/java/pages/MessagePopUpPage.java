package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {

    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForPopUpToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error")));
    }

    public WebElement getPopUpMessageText() {
        return driver.findElement(By.xpath("//div [contains(@role, 'status')]/ul/li"));
    }


    public WebElement getCloseButton() {
        return driver
                .findElement(By.className("theme--dark"));
    }

//    public void waitForVerifyYourAccountDialogToBeVisible() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated());
//    }
//
//    public WebElement getVerifyYourAccountDialogHeader() {
//
//    }
//
//    public WebElement getVerifyAccountCloseButton() {
//
//    }


}
