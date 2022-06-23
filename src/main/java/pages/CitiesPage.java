package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {

    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {
        return driver
                .findElement(By.className("btnNewItem"));

    }

    public WebElement getNewItemNameInput() {
        return driver
                .findElement(By.id("name"));
    }

    public WebElement getNewItemSaveButton() {
        return driver
                .findElement(By.className("btnSave"));
    }

    public void waitForSavedSuccessfullyNewItemDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wrapper")));
    }

    public WebElement getSearchInput() {
        return driver
                .findElement(By.id("search"));

    }

    public WebElement getEditItemInput(){
        return driver.findElement(By.id("name"));
    }

    public void waitForCreateEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dlgNewEditItem")));

    }



    public void waitForDeleteDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("exclamation")));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class,'v-card__text ')]")));
//        PROVERI OVO, LOS LOKATOR!
    }

    public WebElement getSaveButtonInEditDialog() {
        return driver
                .findElement(By.className("btnSave"));

    }

    public WebElement getDeleteButtonInDeleteDialog() {
        return driver
                .findElement(By.xpath("//button [contains(@class, 'red')]"));

    }

    public void waitForNumberOfRowsToBe(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum + 1));
    }

    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return driver
                .findElement(By.xpath(
                        "//tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]"));
    }

    public WebElement getEditButtonByRowIndex(int index) {
        return driver.findElements(By.id("edit")).get(index);
    }

    public WebElement getDeleteButtonByRowIndex(int index) {
        return driver.findElements(By.id("delete")).get(index);
    }


}
