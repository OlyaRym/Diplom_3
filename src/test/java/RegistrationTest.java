import PageObject.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;
public class RegistrationTest {
    private WebDriver driver;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();}
    @After public void cleanUp(){driver.quit();}
    @Test
    @DisplayName("Регистрация")
    @Description("Проверь:Успешную регистрацию google")
    public void successfulRegistrationGoogleTest(){
        driver = new ChromeDriver();

        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads(); //метод ожидания загрузки страницы

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.clickRegistrationButton();  //метод клика по кнопке зарегистрироваться
        registrationPageLocators.login("Анастасия","75145@yandex.ru","12345678");
        registrationPageLocators.clickRegisterAfterFillingForm();  //метод клика по кнопе регистрации после заполнения формы
        registrationPageLocators.loading();

        Login login = new Login(driver);
        login.loginPageLoading();
        assertEquals(login.isRegister(),"Зарегистрироваться");
    }
    @Test
    @DisplayName("Регистрация")
    @Description("Проверь:Успешную регистрацию yandex")
    public void successfulRegistrationYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads(); //метод ожидания загрузки страницы

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.clickRegistrationButton();  //метод клика по кнопке зарегистрироваться
        registrationPageLocators.login("Надежда","54253625@yandex.ru","12345678");
        registrationPageLocators.clickRegisterAfterFillingForm();  //метод клика по кнопе регистрации после заполнения формы
        registrationPageLocators.loading();

        Login login = new Login(driver);
        login.loginPageLoading();
        assertEquals(login.isRegister(),"Зарегистрироваться");
    }
    @Test
    @DisplayName("Регистрация")
    @Description("Проверь:Ошибку для некорректного пароля. Минимальный пароль — шесть символов google")
    public void invalidPasswordRegistrationGoogleTest(){
        driver = new ChromeDriver();

        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads();

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.clickRegistrationButton();
        registrationPageLocators.login("Анна","anna24531@yandex.ru","12");
        registrationPageLocators.clickRegisterAfterFillingForm();
        assertEquals(registrationPageLocators.messageInvalid(),"Некорректный пароль");
    }
    @Test
    @DisplayName("Регистрация")
    @Description("Проверь:Ошибку для некорректного пароля. Минимальный пароль — шесть символов yandex")
    public void invalidPasswordRegistrationYaTest(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","C:\\cygwin64\\home\\USER\\WebDriver\\bin2\\yandexdriver.exe");
        options.setBinary("C:\\Users\\USER\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");

        driver = new ChromeDriver(options);
        HomePageLocators homePageLocators = new HomePageLocators(driver);
        homePageLocators.open(); //открыли сайт
        homePageLocators.clickLoginYourAccount(); //клик по кнопке Войти
        homePageLocators.expectationDownloads();

        RegistrationPageLocators registrationPageLocators = new RegistrationPageLocators(driver);
        registrationPageLocators.clickRegistrationButton();
        registrationPageLocators.login("Ирина","cyhd4@yandex.ru","12");
        registrationPageLocators.clickRegisterAfterFillingForm();
        assertEquals(registrationPageLocators.messageInvalid(),"Некорректный пароль");
    }
}
