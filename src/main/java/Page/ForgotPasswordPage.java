package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

    private WebDriver driver;

    private By buttonRecover = By.xpath(".//button[text()='Восстановить']"); // б.кнопка Восстановить

    private By buttonInput = By.xpath(".//a[text()='Войти']"); // м.кнопка Войти

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания, что страница загрузилась
    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonRecover));
    }

    // клик на кнопку Войти
    public void clickInButtonInput() {
        driver.findElement(buttonInput).click();
    }
}
