package com.tatf.adminces.modules.crearCuentaAdmin.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaAdmin.data.CrearCuentaAdminData;
import com.tatf.adminces.modules.crearCuentaAdmin.task.CrearCuentaAdminTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.Test;

public class CrearCuentaAdminTest extends BaseTest {

    @Test
    void crearCuentaAdmin() {

        browser.interaction().navigateTo(AccessData.url);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(AccessData.hash);

        CrearCuentaAdminTask registerTask = new CrearCuentaAdminTask(browser);
        registerTask.crearCuentaAdministrador(
                CrearCuentaAdminData.firstName,
                CrearCuentaAdminData.lastName,
                CrearCuentaAdminData.email,
                CrearCuentaAdminData.password,
                CrearCuentaAdminData.repeatPassword,
                CrearCuentaAdminData.country
        );

        String mensaje = registerTask.obtenerMensaje();

        IVerify.create().verify(
                "Usuario creado.",
                mensaje,
                "El mensaje no es el esperado"
        );
    }
}