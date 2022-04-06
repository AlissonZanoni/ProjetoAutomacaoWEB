package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPO {

    WebDriver driver;
    int TimeImplicitWait = 30;
    int TimeExplicitWait = 20;

    By linkedButtonForm = By.id("htmlformtest");
    By inputUserName = By.name("username");
    By inputPassword = By.name("password");
    By inputComment = By.name("comments");
    By checkbox1 = By.partialLinkText("Checkbox 1");

    public FormPO(WebDriver driver ){this.driver = driver;}

    public void PreenchendoForm(String name, String password, String comment){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeExplicitWait));
        WebDriver.Timeouts timeouts = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeImplicitWait));

        driver.findElement(linkedButtonForm).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputUserName)).click();
        driver.findElement(inputUserName).sendKeys(name);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(inputComment).sendKeys(comment);
        driver.findElement(checkbox1).click();
    }

}
