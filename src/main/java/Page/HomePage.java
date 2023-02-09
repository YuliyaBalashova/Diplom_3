package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    private By buttonLK = By.xpath(".//p[text()='Личный Кабинет']");   // кнопка Личный кабинет

    private By buttonInput = By.xpath(".//button[text()='Войти в аккаунт']"); // кнопка Войти

    private By buttonPlaceOrder = By.xpath(".//button[text()='Оформить заказ']"); // кнопка Оформить заказ

    private By buttonBuns = By.xpath(".//span[text()='Булки']"); // кнопка Булки

    private By buttonBunsClick = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']"); // кнопка Булки нажата

    private By textBuns = By.xpath(".//h2[text()='Булки']"); // заголовок раздела Булки

    private By buttonSauces  = By.xpath(".//span[text()='Соусы']"); // кнопка Соусы

    private By buttonSaucesClick  = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']"); // кнопка Соусы нажата

    private By textSauces = By.xpath(".//h2[text()='Соусы']"); // заголовок раздела Соусы

    private By buttonIngredients = By.xpath(".//span[text()='Начинки']"); // кнопка Начинки

    private By buttonIngredientsClick = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']"); // кнопка Начинки нажата

    private By textIngredients = By.xpath(".//h2[text()='Начинки']"); // заголовок раздела Начинки

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидания, что загрузилась страница без авторизованного пользователя
    public void waitForLoadHomePageWithoutAuth() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonInput));
    }

    //метод ожидания, что загрузилась страница под авторизованным пользователем
    public void waitForLoadHomePageWithAuth() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(buttonPlaceOrder));
    }

    // проверка видимости кнопки Оформить заказ
    public void visualButtonPlaceOrder() {
        driver.findElement(buttonPlaceOrder).isEnabled();
    }

    // клик на кнопку Личный кабинет
    public void clickInButtonLK() {
        driver.findElement(buttonLK).click();
    }

    // клик на кнопку Войти в аккаунт
    public void clickInButtonInput() {
        driver.findElement(buttonInput).click();
    }

    // клик на кнопку Булки
    public void clickInButtonBuns() {
        driver.findElement(buttonBuns).click();
    }

    // клик на кнопку Соусы
    public void clickInButtonSauces() {
        driver.findElement(buttonSauces).click();
    }

    // клик на кнопку Начинки
    public void clickInButtonIngredients() {
        driver.findElement(buttonIngredients).click();
    }

    // проверка перехода к разделу Булки
    public void visualButtonBuns() {driver.findElement(buttonBunsClick).isEnabled();}
    public void visualTextBuns() {
        driver.findElement(textBuns).isEnabled();
    }

    // проверка перехода к разделу Соусы
    public void visualButtonSauces() {driver.findElement(buttonSaucesClick).isEnabled();}
    public void visualTextSauces() {
        driver.findElement(textSauces).isEnabled();
    }

    // проверка перехода к разделу Ингредиенты
    public void visualButtonIngredients() {driver.findElement(buttonIngredientsClick).isEnabled();}
    public void visualTextIngredients() {
        driver.findElement(textIngredients).isEnabled();
    }
}
