package com.tatf.adminces.modules.eliminarCuentaTester.pom;

import com.tatf.core.browser.IBrowser;

public class EliminarCuentaTesterPO {

    private IBrowser browser;

    public EliminarCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickVerUsuarios() {
        browser.find().css("#cardLogin[href='/adminces/view-users']").click();
    }

    public void clickUsuario() {
        browser.find().css("button[id='testemail@gmail.com']").click();
    }

    public void clickConfirmarEliminacion() {
        browser.find().css("button.swal2-confirm.swal2-styled.swal2-default-outline").click();
    }

    public String obtenerMensaje() {
        return browser.find().css("#swal2-html-container").getText();
    }
}