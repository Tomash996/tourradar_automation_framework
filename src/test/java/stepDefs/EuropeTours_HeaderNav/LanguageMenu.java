package stepDefs.EuropeTours_HeaderNav;

import base.Initialization;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LanguageMenu extends Initialization {

    public String scenDesc;

    @Before
    public void before(Scenario scenario) {
        this.scenDesc = scenario.getName();
        initialize();
    }

    //@Given section

    @Given("User checks that Language Menu btn is displayed")
    public void verifyLanguageBtnIsDisplayed() {
        Assert.assertTrue(headerNav.verifyLanguageBtnDisplayed());
    }

    //@Then section

    @Then("{string} language is displayed as selected in dropdown")
    public void verifyLanguageIsSelected(String languageLabel) {
        headerNav.verifySelectedLanguageDd(languageLabel);
    }

    @Then("User open Language Menu dropdown")
    public void openLanguageMenu() {
        headerNav.clickLanguageBtn();
    }

    //@And section
    @And("Default {string} language label is on the header")
    public void verifyLanguageBtnIsDisplayed(String languageLabel) {
        headerNav.verifySelectedLanguageLabel(languageLabel);
    }

    @And("Default Language options are displayed in dropdown")
    public void verifyDefaultLanguageList() {
        headerNav.verifyLanguageMenuList();
    }
}
