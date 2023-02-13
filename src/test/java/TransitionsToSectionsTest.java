import Page.HomePage;
import Utils.DriverForBrowser;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TransitionsToSectionsTest {
    private WebDriver driver = DriverForBrowser.getDriver();;

    //объект класса главной страницы
    HomePage objHomePage = new HomePage(driver);

    @Test
    @DisplayName("Переходы к разделам конструктора")
    public void transitionToSections() {

        //переход на страницу тестового приложения
        driver.get("https://stellarburgers.nomoreparties.site/");

        // клик на кнопку Начинки
        objHomePage.clickInButtonIngredients();

        // проверка перехода к разделу Начинки
        objHomePage.visualButtonIngredients();

        // клик на кнопку Соусы
        objHomePage.clickInButtonSauces();

        // проверка перехода к разделу Соусы
        objHomePage.visualButtonSauces();

        // клик на кнопку Булки
        objHomePage.clickInButtonBuns();

        // проверка перехода к разделу Булки
        objHomePage.visualButtonBuns();
    }

    @After
    public void  tearDown() {
        driver.quit();
    }
}