import Page.*;
import Utils.Constants;
import Utils.DeleteRegisterUsers;
import Utils.DriverForBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class InputTest {
    private WebDriver driver = DriverForBrowser.getDriver();

    private final String name;
    private final String email;
    private final String password;

    public InputTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        //тестовые данные
        return new Object[][] {
                {"Яна", "yana@bk.ru", "RtYuIo1"},
                {"Иван", "ivan@bk.ru", "DfGhJk"},
        };
    }

    //объект класса главной страницы
    HomePage objHomePage = new HomePage(driver);

    //объект класса страницы входа
    LoginPage objLoginPage = new LoginPage(driver);

    //объект класса страницы регистрации
    RegisterPage objRegisterPage = new RegisterPage(driver);

    //объект класса страницы восстановления пароля
    ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);

    // Регистрация пользователя
    @Before
    public void registerUser(){
        //переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");

        // клик на кнопку Личный кабинет
        objHomePage.clickInButtonLK();

        // клик на кнопку Зарегистрироваться
        objLoginPage.clickInButtonLog();

        // заполнить поля Name, Email и Пароль для регистрации
        objRegisterPage.fillLoginPage(name, email, password);

        // клик на кнопку Зарегистрироваться
        objRegisterPage.clickInButtonLog();

        //метод ожидания, что страница входа загрузилась
        objLoginPage.waitForLoadLoginPage();
    }

    @Test
    @DisplayName("Вход зарегистрированным пользователем по кнопке «Войти в аккаунт» на главной")
    public void inputFirstTest() {
        //переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");

        // клик на кнопку Войти в аккаунт
        objHomePage.clickInButtonInput();

        // заполнить поля Email и Пароль для входа
        objLoginPage.fillLoginPage(email, password);

        // клик на кнопку Войти
        objLoginPage.clickInButtonInput();

        //метод ожидания, что главная страница загрузилась под авторизованным пользователем
        objHomePage.waitForLoadHomePageWithAuth();

        // проверка видимости кнопки Оформить заказ
        Assert.assertTrue(objHomePage.visualButtonPlaceOrder());
    }

    @Test
    @DisplayName("Вход зарегистрированным пользователем через кнопку «Личный кабинет»")
    public void inputTwoTest() {
        //переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");

        // клик на кнопку Личный кабинет
        objHomePage.clickInButtonLK();

        // заполнить поля Email и Пароль для входа
        objLoginPage.fillLoginPage(email, password);

        // клик на кнопку Войти
        objLoginPage.clickInButtonInput();

        //метод ожидания, что главная страница загрузилась под авторизованным пользователем
        objHomePage.waitForLoadHomePageWithAuth();

        // проверка видимости кнопки Оформить заказ
        Assert.assertTrue(objHomePage.visualButtonPlaceOrder());
    }

    @Test
    @DisplayName("Вход зарегистрированным пользователем через кнопку в форме регистрации")
    public void inputThirdTest() {
        //переход на страницу формы регистрации
        driver.get("https://stellarburgers.nomoreparties.site/register");

        // клик на кнопку Войти
        objRegisterPage.clickInButtonInput();

        // заполнить поля Email и Пароль для входа
        objLoginPage.fillLoginPage(email, password);

        // клик на кнопку Войти
        objLoginPage.clickInButtonInput();

        //метод ожидания, что главная страница загрузилась под авторизованным пользователем
        objHomePage.waitForLoadHomePageWithAuth();

        // проверка видимости кнопки Оформить заказ
        Assert.assertTrue(objHomePage.visualButtonPlaceOrder());
    }

    @Test
    @DisplayName("Вход зарегистрированным пользователем через кнопку в форме восстановления пароля")
    public void inputFourTest() {
        //переход на страницу формы восстановления пароля
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        // клик на кнопку Войти
        objForgotPasswordPage.clickInButtonInput();

        // заполнить поля Email и Пароль для входа
        objLoginPage.fillLoginPage(email, password);

        // клик на кнопку Войти
        objLoginPage.clickInButtonInput();

        //метод ожидания, что главная страница загрузилась под авторизованным пользователем
        objHomePage.waitForLoadHomePageWithAuth();

        // проверка видимости кнопки Оформить заказ
        Assert.assertTrue(objHomePage.visualButtonPlaceOrder());
    }

    @After
    //Удаление созданных пользователей
    public void deleteUsers(){
        DeleteRegisterUsers deleteUser = new DeleteRegisterUsers(email, password);
        deleteUser.deleteUser();
    }

    @After
    public void  tearDown() {
        driver.quit();
    }
}