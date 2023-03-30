package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TourListSection extends BasePage {

    private WebDriver driver;
    public TourListSection(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    private String tourListItem = "//ul/li[contains(@class, 'tour-viewed')][1]";
    private String tourListItemName = tourListItem + "/div[@class = 'bm active']/a/h4[contains(@class, 'tour__name')]";
    private String tourListItemMapBtn = tourListItem + "/div[@class = 'bl']/div[contains(@class ,'bl__map-button')]";
    private String closeMapBtn = " //div[contains(@class, 'content-close')]";
    private String tourTitleMapView = "//a[contains(@class, 'common-map-popup__content-info-details-tour-link')]";

    public String getTourTitle() {
        WebElement el = driver.findElement(By.xpath(tourListItemName));
        waitForElementToBeVisible(el, 10000);
        return el.getText();
    }

    public String getTourTitleMapView() {
        WebElement el = driver.findElement(By.xpath(tourTitleMapView));
        waitForElementToBeVisible(el, 10000);
        return el.getText();
    }

    public void openTourMap() {
        WebElement el = driver.findElement(By.xpath(tourListItemMapBtn));
        waitForElementToBeVisible(el, 10000);
        el.click();
    }

    public void closeTourMap() {
        WebElement el = driver.findElement(By.xpath(closeMapBtn));
        waitForElementToBeVisible(el, 10000);
        el.click();
    }


}
