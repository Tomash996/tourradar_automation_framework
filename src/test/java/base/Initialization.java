package base;


import org.junit.After;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HeaderNav;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SortAndFilterSection;
import pages.TourListSection;

import java.util.concurrent.TimeUnit;

public class Initialization {
    private WebDriver driver;
    protected HeaderNav headerNav;
    protected SortAndFilterSection sortAndFilterSection;
    protected TourListSection tourListSection;

    @Before
    public void initialize() {
        //Open the browser
        System.setProperty("webdriver.chrome.driver", "./src/test/java/lib/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.get("https://www.tourradar.com/d/europe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        headerNav = new HeaderNav(driver);
        sortAndFilterSection = new SortAndFilterSection(driver);
        tourListSection = new TourListSection(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
