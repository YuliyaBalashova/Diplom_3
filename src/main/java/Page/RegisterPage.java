package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
    private WebDriver driver;

    private By fieldName = By.xpath(".//form/fieldset[1]/div/div/input");  // поле Имя

    private By fieldEmail = By.xpath(".//form/fieldset[2]/div/div/input");  // поле Email

    private By fieldPassword = By.xpath(".//input[@type='password']");  // поле Пароль

    private By textPasswordError = By.xpath(".//p[text()='Некорректный пароль']");  // Некорректный пароль

    private By buttonLog = By.xpath(".//button[text()='Зарегистрироваться']");  // б.кнопка Зарегистрироваться

    private By buttonInput = By.xpath(".//a[text()='Войти']");   // м.кнопка Войти

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания, что страница загрузилась
    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonLog));
    }

    // заполнить поля Name, Email и Пароль для регистрации
    public void fillLoginPage(String name, String email, String password) {
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);
    }

    //проверка некорректного ввода пароля
    public void inputPasswordError() {
        driver.findElement(textPasswordError).isEnabled();
    }

    // клик на кнопку Зарегистрироваться
    public void clickInButtonLog() {
        driver.findElement(buttonLog).click();
    }

    // клик на кнопку Войти
    public void clickInButtonInput() {
        driver.findElement(buttonInput).click();
    }
}
