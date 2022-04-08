package PageObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FormPO {

    WebDriver driver;
    int TimeImplicitWait = 30;
    int TimeExplicitWait = 20;

    //Elementos para cadastro
    By linkedButtonForm = By.id("htmlformtest");
    By inputUserName = By.name("username");
    By inputPassword = By.name("password");
    By inputComment = By.name("comments");
    By checkbox1 = By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[5]/td/input[1]");
    By checkbox2 = By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[5]/td/input[2]");
    By checkbox3 = By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[5]/td/input[3]");
    By radiobutton1 = By.cssSelector("input[type=radio]:nth-child(2)");
    By radiobutton2 = By.cssSelector("input[type=radio]:nth-child(3)");
    By radiobutton3 = By.cssSelector("input[type=radio]:nth-child(4)");
    By listDropDown = By.name("dropdown");
    By btnSubmit = By.xpath("/html/body/div[1]/div[3]/form/table/tbody/tr[9]/td/input[2]");

    //Elementos para validação
    By btnIndex = By.partialLinkText("Index");
    By valueusername = By.id("_valueusername");
    By valuepassword = By.id("_valuepassword");
    By valuecomments = By.id("_valuecomments");

    public FormPO(WebDriver driver ){this.driver = driver;}

    public void PreenchendoForm(String name, String password, String comment) throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeExplicitWait));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeImplicitWait));

        driver.findElement(linkedButtonForm).click();
        wait.until(ExpectedConditions.elementToBeClickable(inputUserName)).click();
        driver.findElement(inputUserName).sendKeys(name);
        Thread.sleep(2000);
        driver.findElement(inputPassword).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(inputComment).clear();
        Thread.sleep(1500);
        driver.findElement(inputComment).sendKeys(comment);
        Thread.sleep(2000);
        driver.findElement(checkbox1).click();
        Thread.sleep(2000);
        driver.findElement(checkbox2).click();
        Thread.sleep(2000);
        driver.findElement(checkbox3).click();
        Thread.sleep(1500);
        driver.findElement(radiobutton1).click();
        Thread.sleep(1500);
        driver.findElement(radiobutton2).click();
        Thread.sleep(1500);
        driver.findElement(radiobutton3).click();
        Thread.sleep(1500);
        driver.findElement(radiobutton3).click();
        Thread.sleep(1500);

        Select Sel = new Select(driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[7]/td/select")));
        if (Sel.isMultiple()) {
            Sel.selectByIndex(0);
            Thread.sleep(1000);
            Sel.selectByIndex(1);
            Thread.sleep(1000);
            Sel.selectByIndex(2);
            Thread.sleep(1000);
        }
        driver.findElement(listDropDown).click();
        Thread.sleep(1000);
        driver.findElement(listDropDown).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(listDropDown).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(listDropDown).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(listDropDown).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(btnSubmit).click();

        wait.until(ExpectedConditions.elementToBeClickable(btnIndex));

        String tituloPage = "Processed Form Details";
        String validaruser = driver.findElement(valueusername).getText();
        String validarsenha = driver.findElement(valuepassword).getText();
        String valircomments = driver.findElement(valuecomments).getText();

        Thread.sleep(5000);
        Assert.assertEquals(driver.getPageSource().contains(tituloPage),true);
        Assert.assertEquals(validaruser,name);
        Assert.assertEquals(validarsenha,password);
        Assert.assertEquals(valircomments,comment);
    }
}
