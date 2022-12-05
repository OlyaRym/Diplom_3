package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePageLocators {  //главная страница
    //вебдрайвер
    private final WebDriver driver;
    //открыли сайт
    private static final String PAGE_URL_WEBSITE = "https://stellarburgers.nomoreparties.site";
    //локатор кнопки «Войти в аккаунт»
    private By loginYourAccount = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    //локатор для ожидания
    private By expectation = By.className("App_componentContainer__2JC2W");
    //локатор кнопки ЛК
    private By personalAccount = By.xpath("/html/body/div/div/header/nav/a");
    //локатор кнопки Булки
    private By bunButton = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[1]");
    //локатор кнопки Соус
    private By saucesButton = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[2]");
    //локатор кнопки Начински
    private By fillingButton = By.xpath("/html/body/div/div/main/section[1]/div[1]/div[3]");
    //надпись Булки
    private By bunTitle = By.xpath("/html/body/div/div/main/section[1]/div[2]/h2[1]");
    //надпись Соусы
    private By saucesTitle  = By.xpath("/html/body/div/div/main/section[1]/div[2]/h2[2]");
    //надпись Начинки
    private By fillingTitle  = By.xpath("/html/body/div/div/main/section[1]/div[2]/h2[3]");

    // вебдрайвер метод
    public HomePageLocators(WebDriver driver) {
        this.driver = driver;
    }
    //метод для открытия сайта
    public void open() {
        driver.get(PAGE_URL_WEBSITE);
    }
    //метод клика на кнопку «Войти в аккаунт»
    public void clickLoginYourAccount(){
        driver.findElement(loginYourAccount).click();
    }
    //метод ожидания загрузки страницы
    public void expectationDownloads(){
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.elementToBeClickable(expectation));
    }
    //метод клик на кнопку ЛК
    public void clickPersonalAccount(){driver.findElement(personalAccount).click();}
    //метод клика по булки
    public void clickBunButton(){driver.findElement(bunButton).click();}
    //метод клика по начинки
    public void clickFillingButton (){driver.findElement(fillingButton).click();}
    //мтод лика по соусы
    public void clickSaucesButton (){driver.findElement(saucesButton).click();}
    //метод ожидания надписи булки
    public String isBunButtonLoading(){return driver.findElement(bunTitle).getText();}
    //метод ожидания надписи начинки
    public String isFillingButtonLoading(){return driver.findElement(fillingTitle).getText();}
    //метод ожидания надписи соусы
    public String isSaucesButtonLoading(){return driver.findElement(saucesTitle).getText();}
}
