package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority = 10)

    public void setLocaleToES() {

        navPage.getLanguageButton()
                .click();

        navPage.getESLanguageButton()
                .click();

        Assert.assertTrue(navPage.headerText().getText()
                .contains("Página de aterrizaje"));
    }

    @Test(priority = 20)

    public void setLocaleToEN() {

        navPage.getLanguageButton()
                .click();

        navPage.getENLanguageButton()
                .click();

        Assert.assertTrue(navPage.headerText().getText()
                .contains("Landing"));
    }

    @Test(priority = 30)

    public void setLocaleToCN() {

        navPage.getLanguageButton()
                .click();

        navPage.getCNLanguageButton()
                .click();

        Assert.assertTrue(navPage.headerText().getText()
                .contains("首页"));
    }

    @Test(priority = 40)

    public void setLocaleToFR() {

        navPage.getLanguageButton()
                .click();

        navPage.getFRLanguageButton()
                .click();

        Assert.assertTrue(navPage.headerText().getText()
                .contains("Page d'atterrissage"));
    }
}
