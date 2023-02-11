import Page.*;
import Utils.Constants;
import Utils.DeleteRegisterUsers;
import Utils.DriverForBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TransferLKTest {
    private WebDriver driver = DriverForBrowser.getDriver();;

    //объект класса главной страницы
    HomePage objHomePage = new HomePage(driver);

    //объект класса страницы входа
    LoginPage objLoginPage = new LoginPage(driver);

    //объект класса страницы регистрации
    RegisterPage objRegisterPage = new RegisterPage(driver);

    //объект класса страницы профиля
    ProfilePage objProfilePage = new ProfilePage(driver);

    String name = "Яна";
    String email = "yana@bk.ru";
    String password = "RtYuIo1";

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
    @DisplayName("Переход в личный кабинет")
    public void transferLK(){

        // заполнить поля Email и Пароль для входа
        objLoginPage.fillLoginPage(email, password);

        // клик на кнопку Войти
        objLoginPage.clickInButtonInput();

        //метод ожидания, что страница загрузилась
        objHomePage.waitForLoadHomePageWithAuth();

        // клик на кнопку Личный кабинет
        objHomePage.clickInButtonLK();

        //ожидание, что страница профиля загрузилась
        objProfilePage.waitForLoadRegisterPage();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/account/profile", driver.getCurrentUrl());
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