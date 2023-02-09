package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {

    private WebDriver driver;

    private By buttonExit = By.xpath(".//button[text()='Выход']"); // кнопка Выход

    private By buttonConstructor = By.xpath(".//p[text()='Конструктор']"); // кнопка Конструктор

    private By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']"); // логотип Stellar Burgers

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания, что страница загрузилась
    public void waitForLoadRegisterPage() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonExit));
    }

    // клик на кнопку Конструктор
    public void clickInButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    // клик на логотип Stellar Burgers
    public void clickInLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }

    // клик на кнопку Выход
    public void clickInButtonInput() {
        driver.findElement(buttonExit).click();
    }
}
