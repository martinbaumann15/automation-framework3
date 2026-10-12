package com.tatf.adminces.modules.crearCuentaAdmin.pom;

import com.tatf.adminces.modules.base.PopupPO;
import com.tatf.core.browser.IBrowser;

public class CrearCuentaAdminPO {

    private final IBrowser browser;
    private final PopupPO popupPO;

    public CrearCuentaAdminPO(IBrowser browser) {
        this.browser = browser;
        this.popupPO = new PopupPO(browser);
    }

    public void clickRegister() {
        browser.find().css("#cardLogin[href='/adminces/register']").click();
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

    public void escribirPassword(String password) {
        browser.find().css("input[name='inputPassword']").write(password);
    }

    public void repetirPassword(String repeatPassword) {
        browser.find().css("input[name='inputRepeatPassword']").write(repeatPassword);
    }

    public void escribirPais(String country) {
        browser.find().css("input[name='inputCountry']").write(country);
    }

    public void clickRegistrar() {
        browser.find().css("#btnRegister").click();
    }

    public String obtenerMensaje() {
        return popupPO.obtenerMensaje();
    }

    public void clickConfirmarPopup() {
        popupPO.clickConfirmar();
    }
}