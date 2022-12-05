import PageObject.HomePageLocators;
import PageObject.Login;
import PageObject.PersonalAccountPage;
import PageObject.RegistrationPageLocators;
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
public class LogOutAccountTest {
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void cleanUp(){driver.quit();}
    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете google")
    public void logOutButtonPAGoogleTest(){
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
        personalAccountPage.loadingPA();
        personalAccountPage.clickExitButton();

        login.loginPageLoading();

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        assertEquals( registrationPageLocators.isMailFiled(),"Email");
    }
    @Test
    @DisplayName("Выход из аккаунта")
    @Description("Проверь выход по кнопке «Выйти» в личном кабинете yandex")
    public void logOutButtonPAYaTest(){
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
        personalAccountPage.loadingPA();
        personalAccountPage.clickExitButton();

        login.loginPageLoading();

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        assertEquals( registrationPageLocators.isMailFiled(),"Email");
    }
}
