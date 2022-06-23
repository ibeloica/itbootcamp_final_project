package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 10)

    public void setLocaleToES() {

        navPage.getLanguageButton().click();

        navPage.getESLanguageButton().click();

        Assert.assertTrue(navPage.headerText().getText().contains("Página de aterrizaje"));
    }
}
