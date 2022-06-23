package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 10)

    public void visitsTheAdminCitiesPageAndListCities() {

        navPage.getLoginButton()
                .click();

        loginPage.getEmailInput()
                .sendKeys("admin@admin.com");

        loginPage.getPasswordInput()
                .sendKeys("12345");

        loginPage.getLoginButton()
                .click();

        navPage.getAdminButton()
                .click();

        navPage.waitForCitiesMenuByAdminToBeVisible();

        navPage.getCitiesByAdminMenuButton()
                .click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("/admin/cities"));

    }

    @Test(priority = 20)

    public void checksInputTypesForCreateEditNewCity() {

        navPage.getAdminButton()
                .click();

        navPage.getCitiesByAdminMenuButton()
                .click();

        citiesPage.getNewItemButton()
                .click();

        citiesPage.waitForCreateEditDialogToBeVisible();

        Assert.assertEquals(
                driver.findElement(By.id("name")).getAttribute(
                        "type"),
                "text",
                "[ERROR]: Name field input type is not text");

    }

    @Test(priority = 30)

    public void createNewCity() {

        navPage.getAdminButton()
                .click();

        navPage.waitForCitiesMenuByAdminToBeVisible();

        navPage.getCitiesByAdminMenuButton()
                .click();

        citiesPage.getNewItemButton()
                .click();

        citiesPage.waitForCreateEditDialogToBeVisible();

        citiesPage.getNewItemNameInput()
                .sendKeys("Ivan Beloica's city");

        citiesPage.getNewItemSaveButton()
                .click();

        messagePopUpPage.waitForConfirmPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getSavedSuccessfullyMessage()
                        .getText()
                        .contains("Saved"),
                "[ERROR]: Message popup text is not 'Saved successfully'");

    }
}
