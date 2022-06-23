package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavPage {

    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink() {
        return driver
                .findElement(By.xpath("btnHome"));
    }

    public WebElement getAboutLink() {
        return driver
                .findElement(By.className("btnAbout"));
    }

    public WebElement getMyProfileLink() {
        return driver
                .findElement(By.className("btnProfile"));
    }

    public WebElement getAdminButton() {
        return driver
                .findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesByAdminMenuButton() {
        return driver
                .findElement(By.className("btnAdminCities"));

    }

    public void waitForCitiesMenuByAdminToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnAdminCities")));
    }

    public WebElement getUsersLinkByAdminMenu() {
        return driver
                .findElement(By.className("btnAdminUsers"));
    }

    public WebElement getSignupButton() {
        return driver
                .findElement(By.xpath("//div[3]/a[4]"));
    }

    public WebElement getLoginButton() {
        return driver
                .findElement(By.xpath("//div[3]/a[3]"));
    }

    public WebElement getLogoutButton() {
        return driver
                .findElement(By.className("btnLogout"));
    }

    public WebElement getLanguageButton() {
        return driver
                .findElement(By.xpath("//button[contains(@class,'btnLocaleActivation')]"));
    }
//    public void waitForLanguageDropToBeVisible() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnEN")));
//    }
//    public void waitForLanguageDropToBeInvisible() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("btnEN")));
//    }

    public WebElement getENLanguageButton() {
        return driver
                .findElement(By.className("btnEN"));

    }

    public WebElement getESLanguageButton() {
        return driver
                .findElement(By.className("btnES"));

    }

    public WebElement getFRLanguageButton() {
        return driver
                .findElement(By.className("btnFR"));

    }

    public WebElement getCNLanguageButton() {
        return driver
                .findElement(By.className("btnCN"));

    }

}
