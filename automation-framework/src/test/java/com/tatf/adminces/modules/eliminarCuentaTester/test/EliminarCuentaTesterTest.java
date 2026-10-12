package com.tatf.adminces.modules.eliminarCuentaTester.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaTester.task.CrearCuentaTesterTask;
import com.tatf.adminces.modules.eliminarCuentaTester.task.EliminarCuentaTesterTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;

@Tag("regressiontest")
public class EliminarCuentaTesterTest extends BaseTest {

    @ParameterizedTest
    @DisplayName("Eliminar cuenta tester")
    @Tag("gestioncuenta")
    @CsvSource({
            "testnombre, testapellido, testemail@gmail.com, Uruguay, testpassword"
    })
    void eliminarCuentaTester(
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

        crearCuentaTesterTask.clickConfirmarPopup();

        EliminarCuentaTesterTask eliminarCuentaTesterTask = new EliminarCuentaTesterTask(browser);
        eliminarCuentaTesterTask.eliminarCuentaTester(email);

        String mensaje = eliminarCuentaTesterTask.obtenerMensaje();
        IVerify.create().verify("Usuario eliminado.", mensaje, "El mensaje no es el esperado");
    }
}