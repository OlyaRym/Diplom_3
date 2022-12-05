import PageObject.HomePageLocators;
import PageObject.Login;
import PageObject.PersonalAccountPage;
import PageObject.RegistrationPageLocators;
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
public class LoginTest {
    private WebDriver driver;
    @Before
    public void startUp(){
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void cleanUp(){driver.quit();}
    @Test
    @DisplayName("Вход")
    @Description("вход по кнопке «Войти в аккаунт» на главной google")
    public void loginUsingLoginButtonGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Вход")
    @Description("вход по кнопке «Войти в аккаунт» на главной yandex")
    public void loginUsingLoginButtonYaTest(){
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

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Вход")
    @Description("вход через кнопку «Личный кабинет» google")
    public void loginPAButtonGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickPersonalAccount();
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Вход")
    @Description("вход через кнопку «Личный кабинет» yandex")
    public void loginPAButtonYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickPersonalAccount();
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Вход")
    @Description("вход через кнопку в форме регистрации google")
    public void loginButtonRegistrationFormGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickPersonalAccount(); //кнопка лк клик
        homePageLocators.expectationDownloads();//ожидание загрузки

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.clickRegistrationButton();//клик по кнопке регистрация
        registrationPageLocators.clickLoginRegistration(); //клик по кнопке войти в форме регистрации

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Вход")
    @Description("вход через кнопку в форме регистрации yandex")
    public void loginButtonRegistrationFormYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickPersonalAccount(); //кнопка лк клик
        homePageLocators.expectationDownloads();//ожидание загрузки

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.clickRegistrationButton();//клик по кнопке регистрация
        registrationPageLocators.clickLoginRegistration(); //клик по кнопке войти в форме регистрации

        Login login = new Login(driver);
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Вход")
    @Description("вход через кнопку в форме восстановления пароля google")
    public void loginRecoverPasswordButtonGoogleTest(){
        driver = new ChromeDriver();
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickPersonalAccount();
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.clickRecoverPassword();
        login.clickLoginRecoverPassword();
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
    @Test
    @DisplayName("Вход")
    @Description("вход через кнопку в форме восстановления пароля yandex")
    public void loginRecoverPasswordButtonYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickPersonalAccount();
        homePageLocators.expectationDownloads();

        Login login = new Login(driver);
        login.clickRecoverPassword();
        login.clickLoginRecoverPassword();
        login.loginLogin("Irina@yandex.ru","12345678");
        login.clickLoginButton();

        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.headlineCollectBurger();
        MatcherAssert.assertThat( personalAccountPage.isCheckingLabel(), containsString("Соберите бургер"));
    }
}
