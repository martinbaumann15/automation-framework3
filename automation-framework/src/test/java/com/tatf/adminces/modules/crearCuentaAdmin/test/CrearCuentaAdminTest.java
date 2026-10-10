package com.tatf.adminces.modules.crearCuentaAdmin.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaAdmin.data.CrearCuentaAdminData;
import com.tatf.adminces.modules.crearCuentaAdmin.task.CrearCuentaAdminTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CrearCuentaAdminTest extends BaseTest {


// Parametrizacion con @CsvFileSource, con nuevos datos para una segunda ejecucion
    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/crear_cuenta_admin.csv",
            useHeadersInDisplayName = true
    )

    void crearCuentaAdmin(
            String firstName,
            String lastName,
            String email,
            String password,
            String repeatPassword,
            String country) {

        browser.interaction().navigateTo(AccessData.url);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(AccessData.hash);

        CrearCuentaAdminTask registerTask = new CrearCuentaAdminTask(browser);
        registerTask.crearCuentaAdministrador(
                firstName,
                lastName,
                email,
                password,
                repeatPassword,
                country
        );

        String mensaje = registerTask.obtenerMensaje();

        IVerify.create().verify("Usuario creado.", mensaje, "El mensaje no es el esperado");
    }
    }

// SCRIPT ORIGINAL
//    @Test
//    void crearCuentaAdmin() {
//
//        browser.interaction().navigateTo(AccessData.url);
//
//        AccessTask accessTask = new AccessTask(browser);
//        accessTask.acceder(AccessData.hash);
//
//        CrearCuentaAdminTask registerTask = new CrearCuentaAdminTask(browser);
//        registerTask.crearCuentaAdministrador(
//                CrearCuentaAdminData.firstName,
//                CrearCuentaAdminData.lastName,
//                CrearCuentaAdminData.email,
//                CrearCuentaAdminData.password,
//                CrearCuentaAdminData.repeatPassword,
//                CrearCuentaAdminData.country
//        );
//
//        String mensaje = registerTask.obtenerMensaje();
//
//        IVerify.create().verify(
//                "Usuario creado.",
//                mensaje,
//                "El mensaje no es el esperado"
//        );
//    }
