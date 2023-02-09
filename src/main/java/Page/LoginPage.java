package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private By fieldEmail = By.xpath(".//input[@type='text']");        // поле Email

    private By fieldPassword = By.xpath(".//input[@type='password']");  // поле Пароль

    private By buttonInput = By.xpath(".//button[text()='Войти']");          // б.кнопка Войти

    private By buttonLog = By.xpath(".//a[text()='Зарегистрироваться']");  // м.кнопка Зарегистрироваться

    private By buttonRecoverPassword = By.xpath(".//a[text()='Восстановить пароль']");  // м.кнопка Восстановить пароль

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания, что страница загрузилась
    public void waitForLoadLoginPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonInput));
    }

    // заполнить поля Email и Пароль для входа
    public void fillLoginPage(String email, String password) {
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldPassword).sendKeys(password);
    }

    // клик на кнопку Войти
    public void clickInButtonInput() {
        driver.findElement(buttonInput).click();
    }

    // клик на кнопку Зарегистрироваться
    public void clickInButtonLog() {
        driver.findElement(buttonLog).click();
    }

    // клик на кнопку Восстановить пароль
    public void clickInButtonRecoverPassword() {
        driver.findElement(buttonRecoverPassword).click();
    }
}
