package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Login {  //страница входа
    //драйвей
    private final WebDriver driver;
    // локатор email
    private By emailLogin = By.xpath(".//input[@class='text input__textfield text_type_main-default']");
    //Локатор пароля
    private By passwordLogin = By.xpath(".//input[@type='password']");
    //локатор кнопки вход
    private By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    // локатор кнопки востановить пароль
    private By recoverPassword = By.xpath("/html/body/div/div/main/div/div/p[2]/a");
    //локатор кнопки войти в форме забыли пароль
    private By loginRecoverPassword = By.xpath("/html/body/div/div/main/div/div/p/a ");
    //локатор страницы вход
    private By loginPage = By.xpath("/html/body/div/div/main/div/h2");
    //локатор кнопки
    private By register =By.xpath("/html/body/div/div/main/div/div/p[1]/a");


    // вебдрайвер метод
    public Login(WebDriver driver) {
        this.driver = driver;
    }
    //метод заполнения формы
    public void setEmailLogin(String userEmail) {
        driver.findElement(emailLogin).sendKeys(userEmail);
    }
    public void setPasswordLogin(String userPassword) {
        driver.findElement(passwordLogin).sendKeys(userPassword);
    }
    public void loginLogin(String userEmail, String userPassword) {
        setEmailLogin(userEmail);
        setPasswordLogin(userPassword);
    }
    //метод клика по кнопке войти
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    //метод клика по кнопке востановить пароль
    public void clickRecoverPassword() {
        driver.findElement(recoverPassword).click();
    }
    //метод поиска надписи восстановить пароль
    public String isRecoverPassword(){return driver.findElement(recoverPassword).getText();}
    //метод клика по кнопке войти в форме забыли пароль
    public void clickLoginRecoverPassword() {
        driver.findElement(loginRecoverPassword).click();
    }
    //метод загрузки страницы вход
    public void loginPageLoading() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(loginPage));
    }
    //метод кнопка зарегистрироваться
    public String isRegister(){return driver.findElement(register).getText();}
}
