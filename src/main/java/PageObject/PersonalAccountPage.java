package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class PersonalAccountPage {//страница личного кабинета
    //вебдрайвер
    private final WebDriver driver;
    //локатор кнопки конструктор
    private By constructorButton = By.xpath("/html/body/div/div/header/nav/ul/li[1]/a/p");
    // локатор заголовка собери бургер
    private By collectBurger = By.xpath("/html/body/div/div/main/section[1]/h1");
    //локатор логотипа
    private By logo = By.xpath("/html/body/div/div/header/nav/div");
    //локатор для ожидания загрузки страницы
    private By loadingPersonalAccount = By.className("Account_nav__Lgali");
    //локатор кнопки выйти из акаунта
    private By exitButton = By.xpath("/html/body/div/div/main/div/nav/ul/li[3]/button");
    //локатор надписи в этом разделе...для проверки перехода в личный кабинет
    private By inscriptionPersonalAccount = By.xpath("/html/body/div/div/main/div/nav/p");

    // вебдрайвер метод
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    //метод клика по кнопке конструктор
    public void clickConstructorButton(){driver.findElement(constructorButton).click();}
    //метод поиска зоголовка собери бургер
    public void headlineCollectBurger(){
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.elementToBeClickable(collectBurger));
    }
    //метод проверки надписи собери бургер
    public String isCheckingLabel(){
        return driver.findElement(collectBurger).getText();
    }
    public void clickLogo(){driver.findElement(logo).click();}
    //метод кнопки выйти из ЛК
    public void clickExitButton(){
        driver.findElement(exitButton).click();}
    //метод ожидания загрузки страницы лк
    public void loadingPA(){
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.elementToBeClickable(loadingPersonalAccount));
    }
    //метод поиска надписи
    public String isInscriptionPA(){return driver.findElement(inscriptionPersonalAccount).getText();}
}
