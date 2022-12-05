import PageObject.HomePageLocators;
import PageObject.Login;
import PageObject.PersonalAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.hamcrest.CoreMatchers.containsString;

public class FromPersonalAccountConstructorTest {
    private WebDriver driver;
    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void cleanUp(){driver.quit();}
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("переход из личного кабинета в конструктор по клику на «Конструктор» google")
    public void constructorButtonGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        homePageLocators.clickPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorButton();
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("переход из личного кабинета в конструктор по клику на «Конструктор» yandex")
    public void constructorButtonYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);

        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        homePageLocators.clickPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorButton();
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("переход из личного кабинета в конструктор по клику на логотип Stellar Burgers google")
    public void logoButtonGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        homePageLocators.clickPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogo();
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("переход из личного кабинета в конструктор по клику на логотип Stellar Burgers yandex")
    public void logoButtonYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);

        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        homePageLocators.clickPersonalAccount();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogo();
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
}
