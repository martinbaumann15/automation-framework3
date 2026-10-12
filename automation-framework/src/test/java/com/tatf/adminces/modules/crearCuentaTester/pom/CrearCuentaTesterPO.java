
package com.tatf.adminces.modules.crearCuentaTester.pom;

import com.tatf.adminces.modules.base.PopupPO;
import com.tatf.core.browser.IBrowser;

public class CrearCuentaTesterPO {

    private final IBrowser browser;
    private final PopupPO popupPO;

    public CrearCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
        this.popupPO = new PopupPO(browser);
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

    public void seleccionarPais(String country) {
        browser.find().css("select[name='inputCountry'] option[value='" + country + "']").click();
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
        return popupPO.obtenerMensaje();
    }

    public void clickConfirmarPopup() {
        popupPO.clickConfirmar();
    }
}