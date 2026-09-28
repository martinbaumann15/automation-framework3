package com.tatf.adminces.modules.resetPassword.task;

import com.tatf.adminces.modules.resetPassword.pom.ResetPasswordPO;
import com.tatf.core.browser.IBrowser;

public class ResetPasswordTask {

    private ResetPasswordPO resetPasswordPO;

    public ResetPasswordTask(IBrowser browser) {
        this.resetPasswordPO = new ResetPasswordPO(browser);
    }

    public void reiniciarContrasena(
            String email,
            String password,
            String repeatPassword) {

        resetPasswordPO.clickForgotPassword();
        resetPasswordPO.escribirEmail(email);
        resetPasswordPO.escribirPassword(password);
        resetPasswordPO.repetirPassword(repeatPassword);
        resetPasswordPO.clickResetPassword();
    }

    public String obtenerMensaje() {
        return resetPasswordPO.obtenerMensaje();
    }
}