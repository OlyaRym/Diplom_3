import PageObject.HomePageLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
public class SectionConstructorTest {
    private WebDriver driver;
    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void cleanUp(){
        driver.quit();
    }
    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам:«Булки»,google")
    public void goBunSectionGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickSaucesButton();
        homePageLocators.clickBunButton();
        assertEquals(homePageLocators.isBunButtonLoading(), "Булки");
    }
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам:«Булки»,yandex")
    @Test
    public void goBunSectionYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickSaucesButton();
        homePageLocators.clickBunButton();
        assertEquals(homePageLocators.isBunButtonLoading(), "Булки");
    }
    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам:«Соусы»,google")
    public void goSaucesSectionGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickSaucesButton();
        assertEquals(homePageLocators.isSaucesButtonLoading(), "Соусы");

    }
    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам:«Соусы»,yandex")
    public void goSaucesSectionYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickSaucesButton();
        assertEquals(homePageLocators.isSaucesButtonLoading(), "Соусы");

    }
    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам:«Начинки»,google")
    public void goFillingSectionGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickFillingButton();
        assertEquals(homePageLocators.isFillingButtonLoading(), "Начинки");
    }
    @Test
    @DisplayName("Раздел «Конструктор»")
    @Description("Проверь, что работают переходы к разделам:«Начинки»,yandex")
    public void goFillingSectionYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickFillingButton();
        assertEquals(homePageLocators.isFillingButtonLoading(), "Начинки");
    }
}
