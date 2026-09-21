package com.tatf.tests;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ConsultarInmobiliariaTest {
private static IBrowser browser;

    @BeforeAll
    static void beforeAll() {
        browser = BrowserFactory.getBrowser(true);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    static void afterAll() {
        BrowserFactory.quitBrowser();
    }

    @Test
    void consultarPropiedad() {
        browser.interaction().navigateTo("http://cestore.ces.com.uy/InmoCES/");
        browser.find().css("input[type='password']").write("c#3)d4e9d!bbf4d4ae26df!963=335&]");
        browser.find().css("button[type='submit']").click();
        browser.find().css("button[onclick=\"contactarPropiedad('Cabaña frente al mar')\"]").click();
        browser.find().id("f-email").write("consulta@test.com");
        browser.find().id("f-mensaje").write("Me interesa la propiedas, pueden contactarme para resolverme algunas dudas? Muchas gracias.");
        browser.find().xpath("//button[contains(text(),'Enviar mensaje')]").click();

        //String mensaje = browser.find().id("success-msg").find().tagName("h3").getText();
        String mensaje = browser.find().css("#success-msg h3").getText();
//        String mensaje=driver.findElement(By.id("success-msg")).findElement(By.tagName("h3")).getText();

        Assertions.assertEquals("¡Mensaje enviado!", mensaje, "El mensaje no es el esperado");

//        driver.get("http://cestore.ces.com.uy/InmoCES/");
//        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("c#3)d4e9d!bbf4d4ae26df!963=335&]");
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
//        driver.findElement(By.cssSelector("button[onclick=\"contactarPropiedad('Cabaña frente al mar')\"]")).click();
//        driver.findElement(By.id("f-email")).sendKeys("consulta@test.com");
//        driver.findElement(By.id("f-mensaje")).sendKeys("Me interesa la propiedas, pueden contactarme para resolverme algunas dudas? Muchas gracias.");
//        driver.findElement(By.xpath("//button[contains(text(),'Enviar mensaje')]")).click();
//        String mensaje=driver.findElement(By.id("success-msg")).findElement(By.tagName("h3")).getText();
//
//        Assertions.assertEquals("¡Mensaje enviado!", mensaje, "El mensaje no es el esperado");
    }
}
