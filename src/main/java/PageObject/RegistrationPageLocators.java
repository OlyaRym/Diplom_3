package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class RegistrationPageLocators { //страница регистрации
    //драйвей
    private final WebDriver driver;
    //локатор кнопки регистрации
    private By registrationButton = By.className("Auth_link__1fOlj");
    //локатор для имени
    private By firstName = By.xpath(".//input[@name='name']");
    //локатор для email
    private By email = By.xpath("/html/body/div/div/main/div/form/fieldset[2]/div/div/input") ;
    //локатор для пароля
    private By password = By.xpath(".//input[@type='password']");
    //локатор кнопки регистрации после заполненой формы
    private By next = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");
    //локатор ошибки при неверном пароле
    private By messageInvalidPassword = By.xpath("/html/body/div/div/main/div/form/fieldset[3]/div/p");
    //локатор кнопки войти в форме регистрации
    private By loginRegistrationForm = By.xpath("/html/body/div/div/main/div/div/p/a");
    //локатор почты на странице входа для проверки регистрации
    private By mailVerificationField = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div/label");
    //локатор для ожидания загрузки страницы
    private By loginPageLoading = By.xpath("/html/body/div/div/main/div/form/fieldset[1]/div/div");

    // вебдрайвер метод
    public RegistrationPageLocators(WebDriver driver) {
        this.driver = driver;
    }
    //метод клика по кнопке зарегистрироваться
    public void clickRegistrationButton(){driver.findElement(registrationButton).click(); }
    //методы запонлнения формы
    public void setName(String userName){driver.findElement(firstName).sendKeys(userName);}
    public void setEmail(String userEmail){driver.findElement(email).sendKeys(userEmail);}
    public void setPassword(String userPassword){driver.findElement(password).sendKeys(userPassword);}

    public void login(String userName,String userEmail,String userPassword){
        setName(userName);
        setEmail(userEmail);
        setPassword(userPassword);
    }
    //метод клика по кнопе регистрации после заполнения формы
    public void clickRegisterAfterFillingForm() {
        driver.findElement(next).click();
    }
    public String messageInvalid(){return driver.findElement(messageInvalidPassword).getText();}
    //метод клика по кнопке войти в поле для регистрации
    public void clickLoginRegistration(){driver.findElement(loginRegistrationForm).click();}
    //метод проверки загрузки страницы войти после успешной регистрации
    public String isMailFiled(){return driver.findElement(mailVerificationField).getText();}
    //ожидание загрузки
    public void loading(){
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(loginPageLoading));
    }
}
