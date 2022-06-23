package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
                driver
                        .getCurrentUrl()
                        .contains("/admin/cities"));

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
                driver
                        .findElement(By.id("name"))
                        .getAttribute(
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

    @Test(priority = 40)

    public void editCity() {

        navPage.getAdminButton()
                .click();

        navPage.waitForCitiesMenuByAdminToBeVisible();

        navPage.getCitiesByAdminMenuButton()
                .click();

        citiesPage.getSearchInput()
                .sendKeys("Ivan Beloica's city");

        citiesPage.waitForNumberOfRowsToBe(1);

        citiesPage.getEditButtonByRowIndex(0)
                .click();

        citiesPage.waitForCreateEditDialogToBeVisible();

        citiesPage.getEditItemInput()
                .sendKeys(Keys.CONTROL, "a");

        citiesPage.getEditItemInput()
                .sendKeys("Ivan Beloica's city Edited");

        citiesPage.getSaveButtonInEditDialog()
                .click();

        messagePopUpPage.waitForConfirmPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getSavedSuccessfullyMessage()
                        .getText()
                        .contains("Saved"),
                "[ERROR]: Message popup text is not 'Saved successfully'");

    }

    @Test(priority = 50)

    public void searchCity() {

        navPage.getAdminButton()
                .click();

        navPage.waitForCitiesMenuByAdminToBeVisible();

        navPage.getCitiesByAdminMenuButton()
                .click();

        citiesPage.getSearchInput()
                .sendKeys("Ivan Beloica's city");

        citiesPage.waitForNumberOfRowsToBe(1);

        Assert.assertTrue(driver.findElement(By.xpath(
                                "//td [contains(@class, 'text-left')]"))
                        .getText()
                        .contains(driver.findElement(By.id("search")).getText()),

                "[ERROR]: Search result does not match search input");

    }

    @Test(priority = 60)

    public void deleteCity() {

        navPage.getAdminButton()
                .click();

        navPage.waitForCitiesMenuByAdminToBeVisible();

        navPage.getCitiesByAdminMenuButton()
                .click();

        citiesPage.getSearchInput()
                .sendKeys("Ivan Beloica's city");

        citiesPage.waitForNumberOfRowsToBe(1);

        Assert.assertTrue(driver.findElement(By.xpath(
                                "//td [contains(@class, 'text-left')]"))
                        .getText()
                        .contains(driver.findElement(By.id("search")).getText()),
                "[ERROR]: Search result does not match search input");

        citiesPage.getDeleteButtonByRowIndex(0)
                .click();

        citiesPage.waitForDeleteDialogToBeVisible();

        citiesPage.getDeleteButtonInDeleteDialog()
                .click();

        messagePopUpPage.waitForConfirmPopUpToBeVisible();

        Assert.assertTrue(messagePopUpPage.getSavedSuccessfullyMessage()
                        .getText()
                        .contains("Deleted successfully"),
                "[ERROR]: Message popup text is not 'Deleted successfully'");
    }
}
