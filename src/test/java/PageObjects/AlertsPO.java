package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPO {

    WebDriver driver;
    int timeimplicitwait = 30;
    int timeexplicitwait = 20;

    //Elementos para cadastro
    By linkedtextAlerts = By.id("alerttest");
    By btnShowAlertBox = By.id("alertexamples");

    public AlertsPO(WebDriver driver ){this.driver = driver;}

    public void AutomatizandoAlerts() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeexplicitwait));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeimplicitwait));

        driver.findElement(linkedtextAlerts).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnShowAlertBox)).click();
        Thread.sleep(3000);

        String textalert1 = driver.switchTo().alert().getText();
        Assert.assertEquals("I am an alert box!",textalert1);
        driver.switchTo().alert().accept();



    }

}
