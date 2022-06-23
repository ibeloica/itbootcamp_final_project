package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BasicTest {

    @Test(priority = 10)

    public void visitsTheLoginPage() {

        navPage.getLanguageButton()
                .click();

        navPage.getENLanguageButton()
                .click();

        navPage.getLoginButton()
                .click();

        Assert.assertTrue(driver.getCurrentUrl()
                .contains("/login"));
    }

    @Test(priority = 20)

    public void checksInputTypes() {

        navPage.getLoginButton()
                .click();

        Assert.assertEquals(driver
                        .findElement(By.id("email"))
                        .getAttribute(
                                "type"),
                "email",
                "[ERROR]: Email field input type is not email");

        Assert.assertEquals(driver
                        .findElement(By.id("password"))
                        .getAttribute(
                                "type"),
                "password",
                "[ERROR]: Password field input type is not password");
    }

    @Test(priority = 30)

    public void displaysErrorsWhenUserDoesNotExist() {

        navPage.getLoginButton()
                .click();

        loginPage.getEmailInput()
                .sendKeys(
                        "non-existing-user@gmal.com");

        loginPage.getPasswordInput()
                .sendKeys(
                        "password123");

        loginPage.getLoginButton()
                .click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getPopUpMessageText().getText(),
                "User does not exists",
                "[ERROR]: Message popup text is not 'User does not exists'");

        Assert.assertTrue(driver.getCurrentUrl()
                .contains("/login"));
    }

    @Test(priority = 40)

    public void displaysErrorsWhenPasswordIsWrong() {

        navPage.getLoginButton()
                .click();

        loginPage.getEmailInput()
                .sendKeys(
                        "admin@admin.com");

        loginPage.getPasswordInput()
                .sendKeys(
                        "password123");

        loginPage.getLoginButton()
                .click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getPopUpMessageText().getText(),
                "Wrong password",
                "[ERROR]: Message popup text is not 'Wrong password'");

        Assert.assertTrue(driver.getCurrentUrl()
                .contains("/login"));

    }

    @Test(priority = 50)

    public void login() {

        navPage.getLoginButton()
                .click();

        loginPage.getEmailInput()
                .sendKeys("admin@admin.com");

        loginPage.getPasswordInput()
                .sendKeys("12345");

        loginPage.getLoginButton()
                .click();

        loginPage.waitForHomePageToBeVisible();

        Assert.assertTrue(driver.getCurrentUrl()
                .contains("/home"));

    }

    @Test(priority = 60)

    public void logout() {

        Assert.assertTrue(driver
                .findElement(By.className("btnLogout")).isDisplayed());

        navPage.getLogoutButton()
                .click();
    }

}
