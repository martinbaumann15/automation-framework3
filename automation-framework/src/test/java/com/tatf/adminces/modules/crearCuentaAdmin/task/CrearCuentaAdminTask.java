package com.tatf.adminces.modules.crearCuentaAdmin.task;

import com.tatf.adminces.modules.crearCuentaAdmin.pom.CrearCuentaAdminPO;
import com.tatf.core.browser.IBrowser;

public class CrearCuentaAdminTask {

    private final CrearCuentaAdminPO crearCuentaAdminPO;

    public CrearCuentaAdminTask(IBrowser browser) {
        this.crearCuentaAdminPO = new CrearCuentaAdminPO(browser);
    }

    public void crearCuentaAdministrador(
            String firstName,
            String lastName,
            String email,
            String password,
            String repeatPassword,
            String country) {

        crearCuentaAdminPO.clickRegister();
        crearCuentaAdminPO.escribirNombre(firstName);
        crearCuentaAdminPO.escribirApellido(lastName);
        crearCuentaAdminPO.escribirEmail(email);
        crearCuentaAdminPO.escribirPassword(password);
        crearCuentaAdminPO.repetirPassword(repeatPassword);
        crearCuentaAdminPO.escribirPais(country);
        crearCuentaAdminPO.clickRegistrar();
    }

    public String obtenerMensaje() {
        return crearCuentaAdminPO.obtenerMensaje();
    }

    public void clickConfirmarPopup() {
        crearCuentaAdminPO.clickConfirmarPopup();
    }
}