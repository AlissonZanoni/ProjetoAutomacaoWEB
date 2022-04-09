package PageObjects;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPO {

    WebDriver driver;
    int timeimplicitwait = 30;
    int timeexplicitwait = 20;

    //Elementos para cadastro
    By linkedtextAlerts = By.id("alerttest");
    By btnShowAlertBox = By.id("alertexamples");
    By btnShowConfirmBox = By.id("confirmexample");
    By confirmarretorno = By.id("confirmreturn");
    By btnPrompt = By.id("promptexample");
    By promptreturn = By.id("promptreturn");

    public AlertsPO(WebDriver driver ){this.driver = driver;}

    public void AutomatizandoAlerts(String textopromptalerta) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeexplicitwait));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeimplicitwait));

        driver.findElement(linkedtextAlerts).click();

        //Accept Alert
        wait.until(ExpectedConditions.elementToBeClickable(btnShowAlertBox)).click();
        Thread.sleep(3000);
        String textalert1 = driver.switchTo().alert().getText();
        Assert.assertEquals("I am an alert box!",textalert1);
        driver.switchTo().alert().accept();

        //Confirm Alert
        driver.findElement(btnShowConfirmBox).click();
        Thread.sleep(3000);
        String textalert2 = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a confirm alert",textalert2);
        driver.switchTo().alert().dismiss();
        String valueconfirmarretorno = driver.findElement(confirmarretorno).getText();
        Assert.assertEquals(valueconfirmarretorno,"false");

        //Prompt Alert
        driver.findElement(btnPrompt).click();
        Thread.sleep(3000);
        String textalert3 = driver.switchTo().alert().getText();
        Assert.assertEquals("I prompt you",textalert3);
        driver.switchTo().alert().sendKeys(textopromptalerta);
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        String valorprompt = driver.findElement(promptreturn).getText();
        Assert.assertEquals(valorprompt,textopromptalerta);
    }

}
