package com.tatf.testPrimerosScripts1;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class AdminCEStests {

    private static IBrowser browser;

    @BeforeEach
    void beforeEach() {
        browser = BrowserFactory.getBrowser(true);
    }

    @AfterEach
    void afterEach() {
        BrowserFactory.quitBrowser();
    }


    @DisplayName("Crear cuenta Administrador")
    @Test
    void crearCuentaAdmin() throws InterruptedException {

        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("#pass").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
        Thread.sleep(2000);
        browser.find().css("#cardLogin[href='/adminces/register']").click();
        browser.find().css("input[name='inputFirstName']").write("testnombre");
        browser.find().css("input[name='inputLastName']").write("testapellido");
        browser.find().css("input[name='inputEmail']").write("testemail@gmail.com");
        browser.find().css("input[name='inputPassword']").write("testpassword");
        browser.find().css("input[name='inputRepeatPassword']").write("testpassword");
        browser.find().css("input[name='inputCountry']").write("Uruguay");
        browser.find().css("#btnRegister").click();
        Thread.sleep(2000);

        String mensaje = browser.find().css("#swal2-html-container").getText();
        IVerify.create().verify("Usuario creado.", mensaje, "El mensaje no es el esperado");


    }

    @DisplayName("Reiniciar contraseña")
    @Test
    void reiniciarContrasena() throws InterruptedException {

        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("#pass").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
        Thread.sleep(2000);
        browser.find().css("#cardLogin[href='/adminces/login']").click();
        browser.find().css("input[name='inputEmail']").write("leonardoperez@gmail.com");
        browser.find().css("input[name='inputPassword']").write("12345");
        browser.find().css("button[type='button'].btn-orange-ces").click();
// En este punto el script fallaba porque aparecía un aviso de seguridad de Chrome que interrumpía la prueba. Para solucionarlo me respalde en ChatGPT, que me guió para modificar el ChromeDriver.java y evitar ese aviso
        Thread.sleep(2000);
        browser.find().css("button.swal2-confirm").click();
        browser.find().css("#cardLogin[href='/adminces/forgot-password']").click();
        browser.find().css("input[name='inputEmail']").write("leonardoperez@gmail.com");
        browser.find().css("input[name='inputPassword']").write("12345");
        browser.find().css("input[name='inputRepeatPassword']").write("12345");
        browser.find().css("button.btn.btn-orange-ces.rounded-end-pill.btn-block").click();

        String mensaje = browser.find().css("#swal2-html-container").getText();
        IVerify.create().verify("Contraseña reiniciada.", mensaje, "El mensaje no es el esperado");

    }

    @DisplayName("Crear cuenta Tester")
    @Test
    void crearCuentaTester() throws InterruptedException {

        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("#pass").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
        Thread.sleep(2000);
        browser.find().css("#cardLogin[href='/adminces/login']").click();
        browser.find().css("input[name='inputEmail']").write("leonardoperez@gmail.com");
        browser.find().css("input[name='inputPassword']").write("12345");
        browser.find().css("button[type='button'].btn-orange-ces").click();
// En este punto el script fallaba porque aparecía un aviso de seguridad de Chrome que interrumpía la prueba. Para solucionarlo me respalde en ChatGPT, que me guió para modificar el ChromeDriver.java y evitar ese aviso
        Thread.sleep(2000);
        browser.find().css("button.swal2-confirm").click();
        browser.find().css("#cardLogin[href='/adminces/create-user']").click();
        browser.find().css("input[name='inputFirstName']").write("testnombre");
        browser.find().css("input[name='inputLastName']").write("testapellido");
        browser.find().css("input[name='inputEmail']").write("testemail@gmail.com");
        browser.find().css("select[name='inputCountry'] option[value='Uruguay']").click();
        browser.find().css("input[name='inputPassword']").write("testpassword");
        browser.find().css("label[for='testerJunior']").click();
        browser.find().css("button#btnRegister").click();

        String mensaje = browser.find().css("#swal2-html-container").getText();
        IVerify.create().verify("Usuario creado.", mensaje, "El mensaje no es el esperado");

    }

    @DisplayName("Eliminar cuenta Tester")
    @Test
    void eliminarCuentaTester() throws InterruptedException {

        browser.interaction().navigateTo("http://cestore.ces.com.uy/adminces/");
        browser.find().css("#pass").write("3)ea60e0be3ba12c6ecd%7297868%5c4");
        browser.find().css("button[type='submit']").click();
        Thread.sleep(2000);
        browser.find().css("#cardLogin[href='/adminces/login']").click();
        browser.find().css("input[name='inputEmail']").write("leonardoperez@gmail.com");
        browser.find().css("input[name='inputPassword']").write("12345");
        browser.find().css("button[type='button'].btn-orange-ces").click();
// En este punto el script fallaba porque aparecía un aviso de seguridad de Chrome que interrumpía la prueba. Para solucionarlo me respalde en ChatGPT, que me guió para modificar el ChromeDriver.java y evitar ese aviso
        Thread.sleep(2000);
        browser.find().css("button.swal2-confirm").click();
        browser.find().css("#cardLogin[href='/adminces/view-users']").click();
        browser.find().css("button#test@gmail.com").click();
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();

        String mensaje = browser.find().css("#swal2-html-container").getText();
        IVerify.create().verify("Usuario eliminado.", mensaje, "El mensaje no es el esperado");
// Este test falla porque la cuenta Tester que cree originalmente para este test ya fue eliminada en una ejecución anterior, por lo que ahora no existe.

    }

    }

