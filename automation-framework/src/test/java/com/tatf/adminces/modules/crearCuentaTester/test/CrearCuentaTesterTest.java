package com.tatf.adminces.modules.crearCuentaTester.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaTester.data.CrearCuentaTesterData;
import com.tatf.adminces.modules.crearCuentaTester.task.CrearCuentaTesterTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CrearCuentaTesterTest extends BaseTest {

    @ParameterizedTest(name = "{arguments}")
    @CsvFileSource(
            resources = "/crear_cuenta_tester.csv",
            useHeadersInDisplayName = true
    )
    void crearCuentaTester(
            String firstName,
            String lastName,
            String email,
            String country,
            String password) {

        browser.interaction().navigateTo(AccessData.url);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(AccessData.hash);

        LoginTask loginTask = new LoginTask(browser);
        loginTask.iniciarSesion(LoginData.email, LoginData.password);

        CrearCuentaTesterTask crearCuentaTesterTask = new CrearCuentaTesterTask(browser);
        crearCuentaTesterTask.crearCuentaTester(
                firstName,
                lastName,
                email,
                country,
                password
        );

        String mensaje = crearCuentaTesterTask.obtenerMensaje();
        IVerify.create().verify("Usuario creado.", mensaje, "El mensaje no es el esperado");

        crearCuentaTesterTask.clickConfirmarPopup();
    }
}

//    @Test
//    void crearCuentaTester() {
//
//        browser.interaction().navigateTo(AccessData.url);
//
//        AccessTask accessTask = new AccessTask(browser);
//        accessTask.acceder(AccessData.hash);
//
//        LoginTask loginTask = new LoginTask(browser);
//        loginTask.iniciarSesion(LoginData.email, LoginData.password);
//
//        CrearCuentaTesterTask crearCuentaTesterTask = new CrearCuentaTesterTask(browser);
//        crearCuentaTesterTask.crearCuentaTester(CrearCuentaTesterData.firstName, CrearCuentaTesterData.lastName, CrearCuentaTesterData.email, CrearCuentaTesterData.country, CrearCuentaTesterData.password
//        );
//
//        String mensaje = crearCuentaTesterTask.obtenerMensaje();
//        IVerify.create().verify("Usuario creado.", mensaje, "El mensaje no es el esperado");
//
//        crearCuentaTesterTask.clickConfirmarPopup();
//    }
