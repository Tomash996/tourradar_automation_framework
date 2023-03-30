package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import constantVariables.SortingCategories;

import java.util.ArrayList;
import java.util.List;

public class SortAndFilterSection extends BasePage {

    private WebDriver driver;

    public SortAndFilterSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private String sortBtn = "//div[contains(@class, 'sort__container')]/select[@name='sort']";
    private String tourList = "//ul/li[@class = 'tour exp  ']";
    private String price = "//dd[contains(@class, 'price-description')]/span[contains(@class, 'price-description-value')]";
    private String clearAllBtn = "//a[contains(@class, 'parameters__clear-all')]";
    private String filterApplied = "//h6[@data-label-one = '{{numberOfFilters}} filter applied']";
    private String filerOption = "//label[contains(@class, 'js-serp-filters-link')]";

    public void openSortMenu() {
        WebElement el = driver.findElement(By.xpath(sortBtn));
        waitForElementToBeVisible(el, 10000);
        el.click();
    }

    public void verifySortMenuParameters() {
        List<WebElement> sortParameters = new Select(driver.findElement(
                By.xpath(sortBtn))).getOptions();
        List<String> actualSortParameters = new ArrayList<>();
        List<String> expectedSortParameters = new ArrayList<>();
        for (WebElement option : sortParameters) {
            actualSortParameters.add(option.getText());
        }
        for (SortingCategories category : SortingCategories.values()) {
            expectedSortParameters.add(category.categoryName);
        }
        Assert.assertEquals("Sort categories list contains not corresponding values",
                expectedSortParameters, actualSortParameters);
    }

    public void selectFilterOption(String filterToApply) {
        List<WebElement> el = driver.findElements(By.xpath(filerOption));
        for (WebElement e : el) {
            if (e.getText().equals(filterToApply)) {
                e.click();
            }
        }
    }

    public void selectSortingOption(String sortingOption) {
        WebElement el = driver.findElement(By.xpath(sortBtn));
        Select select = new Select(el);
        select.selectByVisibleText(sortingOption);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(tourList)));
    }

    public void verifySortingOptionIsSelected(String expectedOption) {
        WebElement el = driver.findElement(By.xpath(sortBtn));
        Select select = new Select(el);
        select.getAllSelectedOptions();
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        for (WebElement option : selectedOptions) {
            Assert.assertEquals(option.getText(), expectedOption);
        }
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(price))));
    }

    public boolean verifyTourListIsDisplayed() {
        WebElement webElement = driver.findElement(By.xpath(tourList));
        waitForElementToBeVisible(webElement, 20000);
        return webElement.isDisplayed();
    }

    public boolean verifyClearAllBtnIsDisplayed() {
        WebElement webElement = driver.findElement(By.xpath(clearAllBtn));
        waitForElementToBeVisible(webElement, 10000);
        return webElement.isDisplayed();
    }

    public boolean verifyFilterAppliedLabelIsDisplayed() {
        WebElement webElement = driver.findElement(By.xpath(filterApplied));
        waitForElementToBeVisible(webElement, 10000);
        return webElement.isDisplayed();
    }

    public List<String> getPriceList() {
        List<String> actualList = new ArrayList<>();
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(price))));
        for (WebElement e : driver.findElements(By.xpath(price))) {
            actualList.add(e.getText());
        }
        return actualList;
    }

}
