package com.tatf.adminces.modules.login.pom;

import com.tatf.adminces.modules.base.PopupPO;
import com.tatf.core.browser.IBrowser;

public class LoginPO {

    private final IBrowser browser;
    private final PopupPO popupPO;

    public LoginPO(IBrowser browser) {
        this.browser = browser;
        this.popupPO = new PopupPO(browser);
    }

    public void clickLogin() {
        browser.find().css("#cardLogin[href='/adminces/login']").click();
    }

    public void escribirEmail(String email) {
        browser.find().css("input[name='inputEmail']").write(email);
    }

    public void escribirPassword(String password) {
        browser.find().css("input[name='inputPassword']").write(password);
    }

    public void clickIniciarSesion() {
        browser.find().css("button[type='button'].btn-orange-ces").click();
    }

    public void clickConfirmarPopup() {
        popupPO.clickConfirmar();
    }

    public String obtenerMensaje() {
        return popupPO.obtenerMensaje();
    }

    public void clickOpcionesUsuario() {
        browser.find().css("a.dropdown-toggle[data-bs-toggle='dropdown']").click();
    }

    public void clickCerrarSesion() {
        browser.find().css("a.dropdown-item[href='/adminces']").click();
    }
}