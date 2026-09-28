package com.tatf.adminces.modules.crearCuentaTester.pom;

import com.tatf.core.browser.IBrowser;

public class CrearCuentaTesterPO {

    private IBrowser browser;

    public CrearCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickCrearUsuario() {
        browser.find().css("#cardLogin[href='/adminces/create-user']").click();
    }

    public void escribirNombre(String firstName) {
        browser.find().css("input[name='inputFirstName']").write(firstName);
    }

    public void escribirApellido(String lastName) {
        browser.find().css("input[name='inputLastName']").write(lastName);
    }

    public void escribirEmail(String email) {
        browser.find().css("input[name='inputEmail']").write(email);
    }

    public void seleccionarPais() {
        browser.find().css("select[name='inputCountry'] option[value='Uruguay']").click();
    }

    public void escribirPassword(String password) {
        browser.find().css("input[name='inputPassword']").write(password);
    }

    public void seleccionarTesterJunior() {
        browser.find().css("label[for='testerJunior']").click();
    }

    public void clickRegistrar() {
        browser.find().css("button#btnRegister").click();
    }

    public String obtenerMensaje() {
        return browser.find().css("#swal2-html-container").getText();
    }

    public void clickConfirmarPopup() {
        browser.find().css("button.swal2-confirm").click();
    }
}