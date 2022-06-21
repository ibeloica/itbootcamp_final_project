package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {

    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getNewItemButton() {

    }

    public WebElement getSearchInput() {

    }

    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("NewEditItem")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.xpath("//div[contains(@class,'dlgNewEditItem')]")));

    }
    public void waitForDeleteDialogToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class,'v-card__text ')]")));
//        PROVERI OVO, LOS LOKATOR!
    }
    public WebElement getSaveButtonInEditDialog(){

    }
    public WebElement getDeleteButtonInDeleteDialog(){

    }
    public void waitForNumberOfRowsToBe(int rowNum) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"), rowNum));
    }
    public WebElement getTableCell(int rowIndex, int columnIndex) {
        return driver
                .findElement(By.xpath(
                        "//tbody/tr["+rowIndex +"]/td["+ columnIndex +"]"));
    }
    public WebElement getEditButtonByRowIndex(int index) {
        return driver.findElements(By.className("edit")).get(index);
    }
    public WebElement getDeleteButtonByRowIndex(int index) {
        return driver.findElements(By.className("delete")).get(index);
    }


}
