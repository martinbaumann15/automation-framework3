package com.tatf.adminces.modules.eliminarCuentaTester.pom;

import com.tatf.adminces.modules.base.PopupPO;
import com.tatf.core.browser.IBrowser;

public class EliminarCuentaTesterPO {

    private final IBrowser browser;
    private final PopupPO popupPO;

    public EliminarCuentaTesterPO(IBrowser browser) {
        this.browser = browser;
        this.popupPO = new PopupPO(browser);
    }

    public void clickVerUsuarios() {
        browser.find().css("#cardLogin[href='/adminces/view-users']").click();
    }

    public void clickUsuario(String email) {
        browser.find().css("button[id='" + email + "']").click();
    }

    public void clickConfirmarEliminacion() {
        popupPO.clickConfirmar();
    }

    public String obtenerMensaje() {
        return popupPO.obtenerMensaje();
    }

    public String obtenerIdBotonBorrar(String email) {
        return browser.find().css("button[id='" + email + "']").getAttribute("id");
    }
}