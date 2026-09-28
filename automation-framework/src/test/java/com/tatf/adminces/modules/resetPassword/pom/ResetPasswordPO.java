package com.tatf.adminces.modules.resetPassword.pom;

import com.tatf.core.browser.IBrowser;

public class ResetPasswordPO {

    private IBrowser browser;

    public ResetPasswordPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickForgotPassword() {
        browser.find().css("#cardLogin[href='/adminces/forgot-password']").click();
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

    public void clickResetPassword() {
        browser.find().css("button.btn.btn-orange-ces.rounded-end-pill.btn-block").click();
    }

    public String obtenerMensaje() {
        return browser.find().css("#swal2-html-container").getText();
    }
}