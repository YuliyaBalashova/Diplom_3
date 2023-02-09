import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverForBrowser {

public static WebDriver defineBrowser(String browser){

    WebDriver driver = null;

    if (browser.equals(Constants.CHROME)){
        driver = new ChromeDriver();
    } else if(browser.equals(Constants.YANDEX)){
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\ybala\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);
    }
    return driver;
}
}
