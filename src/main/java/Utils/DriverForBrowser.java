package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverForBrowser {
    static WebDriver driver;
    public static WebDriver getDriver(){
        return driver = DriverForBrowser.defineBrowser(Constants.YANDEX);
    }
    public static WebDriver defineBrowser(String browser){
    if (browser.equals(Constants.CHROME)){
        driver = new ChromeDriver();
    } else if(browser.equals(Constants.YANDEX)){
        System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\yandexdriver.exe");
        driver = new ChromeDriver();
    }
    return driver;
}
}
