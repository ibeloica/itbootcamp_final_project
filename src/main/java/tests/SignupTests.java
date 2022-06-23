package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority = 10)

    public void visitsTheSignupPage() {

        navPage.getSignupButton()
                .click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));

    }

    @Test(priority = 20)

    public void checksInputTypes() {

        navPage.getSignupButton()
                .click();

        Assert.assertEquals(driver
                        .findElement(By.id("email")).getAttribute(
                                "type"),
                "email",
                "[ERROR]: Email field input type is not email");

        Assert.assertEquals(driver
                        .findElement(By.id("password")).getAttribute(
                                "type"),
                "password",
                "[ERROR]: Password field input type is not password");

        Assert.assertEquals(driver
                        .findElement(By.id("confirmPassword")).getAttribute(
                                "type"),
                "password",
                "[ERROR]: Password field input type is not password");

    }

    @Test(priority = 30)

    public void displaysErrorsWhenUserAlreadyExists() {

        navPage.getSignupButton()
                .click();

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));

        signupPage.getNameInput().sendKeys(
                "Another User");

        signupPage.getEmailInput().sendKeys(
                "admin@admin.com");

        signupPage.getPasswordInput().sendKeys(
                "12345");

        signupPage.getConfirmPasswordInput().sendKeys(
                "12345");

        signupPage.getSignMeUpButton()
                .click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getPopUpMessageText().getText(),
                "E-mail already exists",
                "[ERROR]: Message popup text is not 'E-mail already exists'");

        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));

    }

    @Test(priority = 40)

    public void signup() {

        navPage.getSignupButton()
                .click();

        signupPage.getNameInput()
                .sendKeys("Ivan Beloica");

        signupPage.getEmailInput()
                .sendKeys("ivan.beloica@itbootcamp.rs");

        signupPage.getPasswordInput()
                .sendKeys("12345");

        signupPage.getConfirmPasswordInput()
                .sendKeys("12345");

        signupPage.getSignMeUpButton()
                .click();

        navPage.getHomeLink()
                .click();

        messagePopUpPage.waitForVerifyYourAccountDialogToBeVisible();

        Assert.assertEquals(messagePopUpPage.getVerifyAccountPopUpMessageHeader().getText(),
                "IMPORTANT: Verify your account",
                "[ERROR]: Message popup text is not 'IMPORTANT: Verify your account'");

        messagePopUpPage.getVerifyAccountPopUpMessageCloseButton()
                .click();


        navPage.getLogoutButton()
                .click();


    }
}
