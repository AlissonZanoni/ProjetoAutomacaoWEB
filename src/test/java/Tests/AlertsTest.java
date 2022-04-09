package Tests;
import PageObjects.AlertsPO;
import Settings.DriverSettings;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsTest extends DriverSettings {

    public WebDriver driver;

    @Test
    public void TestandoAlertas() throws Exception{
        System.setProperty(chromedriverkey,chromedriverlocale);
        driver = new ChromeDriver();
        driver.get(pagelink);
        driver.manage().window().maximize();

        AlertsPO alertpo = new AlertsPO(driver);
        alertpo.AutomatizandoAlerts("Hello World");
    }

    @After
    public void CloseDriver(){driver.close();}
}
