package stepDefs.SortAndFilterFunctionality;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import stepDefs.EuropeTours_HeaderNav.LanguageMenu;
import base.Initialization;
import org.junit.Assert;
import org.testng.log4testng.Logger;
import constantVariables.FilterCategories;
import constantVariables.SortingCategories;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortAndFilter extends Initialization {

    public String scenDesc;

    @Before
    public void before(Scenario scenario) {
        this.scenDesc = scenario.getName();
        initialize();
    }

    static Logger log = Logger.getLogger(LanguageMenu.class);

    @Given("User opens Sorting Menu List")
    public void verifySortMenu() {
        sortAndFilterSection.openSortMenu();

    }

    @Then("Default sorting parameters are listed in Sorting Menu")
    public void verifyDefaultSortingListIsDisplayed() {
        sortAndFilterSection.verifySortMenuParameters();
    }

    @When("User selects {string} filter option")
    public void verifySortAndFilterOptionsResult(String filterToApply) {
        sortAndFilterSection.selectFilterOption(FilterCategories.valueOf(filterToApply).categoryName);
        Assert.assertTrue(sortAndFilterSection.verifyClearAllBtnIsDisplayed());
        Assert.assertTrue(sortAndFilterSection.verifyFilterAppliedLabelIsDisplayed());
        Assert.assertTrue(sortAndFilterSection.verifyTourListIsDisplayed());
        log.info("Filter Option is selected");
    }

    @Then("User checks after applied {string} sorting option results are displayed correctly")
    public void verifySortingResults(String option) {
        String sortingOption = SortingCategories.valueOf(option).categoryName;
        List<Integer> pricesBeforeSorting = sortAndFilterSection.getPriceList().stream().map(
                str -> str.replaceAll(",", "")).map(Integer::parseInt).collect(Collectors.toList());
        log.info("Price list before sorting is generated");
        sortAndFilterSection.openSortMenu();
        sortAndFilterSection.selectSortingOption(sortingOption);
        sortAndFilterSection.verifySortingOptionIsSelected(sortingOption);
        Assert.assertTrue(sortAndFilterSection.verifyTourListIsDisplayed());
        log.info("Sorting Option is selected");
        List<Integer> pricesAfterSorting = sortAndFilterSection.getPriceList().stream().map(
                str -> str.replaceAll(",", "")).map(Integer::parseInt).collect(Collectors.toList());
        log.info("Price list after sorting is generated");
        Assert.assertTrue(pricesAfterSorting.containsAll(pricesBeforeSorting));
        Collections.sort(pricesBeforeSorting);
        Assert.assertEquals(pricesAfterSorting, pricesBeforeSorting);
    }
}
