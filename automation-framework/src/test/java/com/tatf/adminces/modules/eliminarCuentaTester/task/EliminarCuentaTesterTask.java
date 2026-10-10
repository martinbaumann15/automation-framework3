package com.tatf.adminces.modules.eliminarCuentaTester.task;

import com.tatf.adminces.modules.eliminarCuentaTester.pom.EliminarCuentaTesterPO;
import com.tatf.core.browser.IBrowser;

public class EliminarCuentaTesterTask {

    private EliminarCuentaTesterPO eliminarCuentaTesterPO;

    public EliminarCuentaTesterTask(IBrowser browser) {
        this.eliminarCuentaTesterPO = new EliminarCuentaTesterPO(browser);
    }

    public void eliminarCuentaTester(String email) {
        eliminarCuentaTesterPO.clickVerUsuarios();
        eliminarCuentaTesterPO.clickUsuario(email);
        eliminarCuentaTesterPO.clickConfirmarEliminacion();
    }

    public String obtenerMensaje() {
        return eliminarCuentaTesterPO.obtenerMensaje();
    }
}