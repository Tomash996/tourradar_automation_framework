package stepDefs.TourListFunctionality;

import base.Initialization;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class MapView extends Initialization {

    public String scenDesc;

    @Before
    public void before(Scenario scenario) {
        this.scenDesc = scenario.getName();
        initialize();
    }

    @Given("User checks that corresponding Tour Title is displayed on the map view")
    public void verifyMapViewTourTitle() {
        String tourTitle = tourListSection.getTourTitle();
        tourListSection.openTourMap();
        String tourTitleMap = tourListSection.getTourTitleMapView();
        tourListSection.closeTourMap();
        Assert.assertEquals("Tour Title is displayed incorrectly", tourTitleMap, tourTitle);
    }
}
