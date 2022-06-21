package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class LoginTests extends BasicTest{

    @Test(priority = 10)

    public WebElement getLanguageDrop(){
        driver.findElement(By.xpath("//button[contains(@class,'btnLocaleActivation')]"));
    }
}
