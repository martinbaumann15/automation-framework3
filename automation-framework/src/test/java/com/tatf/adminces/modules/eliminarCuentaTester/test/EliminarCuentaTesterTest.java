package com.tatf.adminces.modules.eliminarCuentaTester.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaTester.data.CrearCuentaTesterData;
import com.tatf.adminces.modules.crearCuentaTester.task.CrearCuentaTesterTask;
import com.tatf.adminces.modules.eliminarCuentaTester.task.EliminarCuentaTesterTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.Test;

public class EliminarCuentaTesterTest extends BaseTest {

    @Test
    void eliminarCuentaTester() {

        browser.interaction().navigateTo(AccessData.url);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(AccessData.hash);

        LoginTask loginTask = new LoginTask(browser);
        loginTask.iniciarSesion(LoginData.email, LoginData.password);

        CrearCuentaTesterTask crearCuentaTesterTask = new CrearCuentaTesterTask(browser);

        crearCuentaTesterTask.crearCuentaTester(
                CrearCuentaTesterData.firstName,
                CrearCuentaTesterData.lastName,
                CrearCuentaTesterData.email,
                CrearCuentaTesterData.country,
                CrearCuentaTesterData.password
        );

        crearCuentaTesterTask.clickConfirmarPopup();

        EliminarCuentaTesterTask eliminarCuentaTesterTask = new EliminarCuentaTesterTask(browser);
        eliminarCuentaTesterTask.eliminarCuentaTester();

        String mensaje = eliminarCuentaTesterTask.obtenerMensaje();
        IVerify.create().verify("Usuario eliminado.", mensaje, "El mensaje no es el esperado");
    }
}
