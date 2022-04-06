package Tests;

import PageObjects.FormPO;
import Settings.DriverSettings;
import com.github.javafaker.Faker;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest extends DriverSettings {

    @Test
    public void TestarFormluario(){
        System.setProperty(chromedriverkey,localedriver);
        WebDriver driver = new ChromeDriver();
        driver.get(linkacessdesafio);
        driver.manage().window().maximize();

        FormPO formpo = new FormPO(driver);
        Faker faker = new Faker();
        String nome = faker.name().fullName();
        String password = faker.animal().name();
        String comment = faker.food().fruit();
        formpo.PreenchendoForm(nome,password,comment);
    }

}
