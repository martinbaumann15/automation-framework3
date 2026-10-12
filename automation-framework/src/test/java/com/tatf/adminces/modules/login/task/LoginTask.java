
package com.tatf.adminces.modules.login.task;

import com.tatf.adminces.modules.login.pom.LoginPO;
import com.tatf.core.browser.IBrowser;

public class LoginTask {

    private final LoginPO loginPO;

    public LoginTask(IBrowser browser) {
        this.loginPO = new LoginPO(browser);
    }

    public void iniciarSesion(String email, String password) {

        loginPO.clickLogin();
        loginPO.escribirEmail(email);
        loginPO.escribirPassword(password);
        loginPO.clickIniciarSesion();
        loginPO.clickConfirmarPopup();
    }

    public String obtenerMensaje() {
        return loginPO.obtenerMensaje();
    }

    public void iniciarSesionSinCerrarPopup(String email, String password) {
        loginPO.clickLogin();
        loginPO.escribirEmail(email);
        loginPO.escribirPassword(password);
        loginPO.clickIniciarSesion();
    }

    public void cerrarSesion() {
        loginPO.clickOpcionesUsuario();
        loginPO.clickCerrarSesion();
        loginPO.clickConfirmarPopup();
        loginPO.clickConfirmarPopup();
    }

}