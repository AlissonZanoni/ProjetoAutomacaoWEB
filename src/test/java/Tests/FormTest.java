package Tests;
import PageObjects.FormPO;
import Settings.DriverSettings;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class FormTest extends DriverSettings {

    public WebDriver driver;

    @Test
    public void TestarFormComDados() throws Exception{
        System.setProperty(chromedriverkey,chromedriverlocale);
        driver = new ChromeDriver();
        driver.get(pagelink);
        driver.manage().window().maximize();

        FormPO formpo = new FormPO(driver);
        Faker faker = new Faker();
        String nome = faker.name().fullName();
        String password = faker.animal().name();
        String comment = faker.color().name();
        formpo.PreenchendoForm(nome,password,comment);
    }

    @Test
    public void TestarFormVazio() throws Exception{
        System.setProperty(edgedriverkey,edgedriverlocale);
        driver = new EdgeDriver();
        driver.get(pagelink);
        driver.manage().window().maximize();

        FormPO formpo = new FormPO(driver);
        formpo.PreenchendoForm("","","");
    }

    @Test
    public void TestarFormCaracteresInvalidos() throws Exception{
        System.setProperty(chromedriverkey,chromedriverlocale);
        driver = new ChromeDriver();
        driver.get(pagelink);
        driver.manage().window().maximize();

        FormPO formpo = new FormPO(driver);
        formpo.PreenchendoForm("$#!@$@$@$@$#@!$@$@$@$#@ _$#@$#@","$!@#$@$@#$! #$@!$$#@$!@$@!$#$!$#$!@#$@$@!$@!#$@#$@!$#@$#@$#@","$@#!$#@!$#@$#@$#@");
    }

    @After
    public void CloseDriver(){
        driver.close();
    }
}
