import Page.*;
import Utils.Constants;
import Utils.DeleteRegisterUsers;
import Utils.DriverForBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class RegisterTest {
    WebDriver driver = DriverForBrowser.getDriver();;
    private final String name;
    private final String email;
    private final String password;

    public RegisterTest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1} {2}")
    public static Object[][] getData() {
        //тестовые данные
        return new Object[][] {
                {"Яна", "yana@bk.ru", "RtYuIo1"},
                {"Иван", "ivan@bk.ru", "DfGhJk"},
                {"Ольга", "olga@bk.ru", "ErTyU"},
        };
    }

    //объект класса главной страницы
    HomePage objHomePage = new HomePage(driver);

    //объект класса страницы входа
    LoginPage objLoginPage = new LoginPage(driver);

    //объект класса страницы регистрации
    RegisterPage objRegisterPage = new RegisterPage(driver);

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void registerTest(){
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

        if (password.length() >= 6) {
            //метод ожидания, что страница входа загрузилась
            objLoginPage.waitForLoadLoginPage();
            Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
        } else {
            //ошибка некорректного ввода пароля
            objRegisterPage.inputPasswordError();
        }
    }

    @After
    //Удаление созданных пользователей
    public void deleteUsers(){
        if (password.length() >= 6) {
            DeleteRegisterUsers deleteUser = new DeleteRegisterUsers(email, password);
            deleteUser.deleteUser();
        }
    }
    @After
    public void  tearDown() {
        driver.quit();
    }
}
