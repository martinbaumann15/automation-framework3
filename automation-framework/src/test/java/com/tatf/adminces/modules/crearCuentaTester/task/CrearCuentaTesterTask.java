package com.tatf.adminces.modules.crearCuentaTester.task;

import com.tatf.adminces.modules.crearCuentaTester.pom.CrearCuentaTesterPO;
import com.tatf.core.browser.IBrowser;

public class CrearCuentaTesterTask {

    private final CrearCuentaTesterPO crearCuentaTesterPO;

    public CrearCuentaTesterTask(IBrowser browser) {
        this.crearCuentaTesterPO = new CrearCuentaTesterPO(browser);
    }

    public void crearCuentaTester(
            String firstName,
            String lastName,
            String email,
            String country,
            String password) {

        crearCuentaTesterPO.clickCrearUsuario();
        crearCuentaTesterPO.escribirNombre(firstName);
        crearCuentaTesterPO.escribirApellido(lastName);
        crearCuentaTesterPO.escribirEmail(email);
        crearCuentaTesterPO.seleccionarPais(country);
        crearCuentaTesterPO.escribirPassword(password);
        crearCuentaTesterPO.seleccionarTesterJunior();
        crearCuentaTesterPO.clickRegistrar();

    }

    public String obtenerMensaje() {
        return crearCuentaTesterPO.obtenerMensaje();
    }

    public void clickConfirmarPopup() {
        crearCuentaTesterPO.clickConfirmarPopup();
    }

}