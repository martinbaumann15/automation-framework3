package com.tatf.adminces.modules.login.pom;

import com.tatf.core.browser.IBrowser;

public class LoginPO {

    private IBrowser browser;

    public LoginPO(IBrowser browser) {
        this.browser = browser;
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
        browser.find().css("button.swal2-confirm").click();
    }
}