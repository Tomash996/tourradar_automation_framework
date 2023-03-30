package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import constantVariables.LanguageList;

import java.util.ArrayList;
import java.util.List;

public class HeaderNav extends BasePage {
    private WebDriver driver;

    public HeaderNav(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private String languageBtn = "//ul[@class='ao-header-navigation']//li[contains(@class, 'language')]";
    private String languageBtnLabel = languageBtn + "/span";
    private String languageOptionsList = "//nav[contains(@class, 'language')]//li/a";
    private String selectedLanguageDd = languageOptionsList + "[contains(@class, " +
            "'ao-header-navigation__dropdown-link--language-active')]";


    public boolean verifyLanguageBtnDisplayed() {
        WebElement webElement = driver.findElement(By.xpath(languageBtn));
        waitForElementToBeVisible(webElement, 10);
        return webElement.isDisplayed();
    }

    public void clickLanguageBtn() {
        driver.findElement(By.xpath(languageBtn)).click();
    }

    public void verifyLanguageMenuList() {
        List<String> actualLanguageList = new ArrayList<>();
        for (WebElement option : driver.findElements(By.xpath(languageOptionsList))) {
            actualLanguageList.add(option.getAttribute("text"));
        }
        List<String> expectedLanguageList = new ArrayList<>();
        for (LanguageList language : LanguageList.values()) {
            expectedLanguageList.add(language.languageName);
        }
        Assert.assertEquals("Language menu list contains not corresponding values",
                expectedLanguageList, actualLanguageList);
    }

    public void verifySelectedLanguageLabel(String languageLabel) {
        String expectedLabel = LanguageList.valueOf(languageLabel).label;
        String actualLabel = driver.findElement(By.xpath(languageBtnLabel)).getText();
        Assert.assertEquals("Selected language label is displayed incorrectly",
                expectedLabel, actualLabel);
    }

    public void verifySelectedLanguageDd(String languageLabel) {
        String actualLanguage = driver.findElement(By.xpath(selectedLanguageDd)).getAttribute("text");
        String expectedLanguage = LanguageList.valueOf(languageLabel).languageName;
        Assert.assertEquals("Selected language is displayed incorrectly",
                actualLanguage, expectedLanguage);
    }

}
