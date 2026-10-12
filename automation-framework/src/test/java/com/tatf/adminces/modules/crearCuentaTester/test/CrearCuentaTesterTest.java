package com.tatf.adminces.modules.crearCuentaTester.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaTester.task.CrearCuentaTesterTask;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.DisplayName;
import com.tatf.adminces.modules.eliminarCuentaTester.pom.EliminarCuentaTesterPO;

@Tags({
        @Tag("smoketest"),
        @Tag("regressiontest")
})
public class CrearCuentaTesterTest extends BaseTest {

    @ParameterizedTest(name = "{arguments}")
    @DisplayName("Crear cuenta tester")
    @Tag("creacioncuenta")
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

        EliminarCuentaTesterPO eliminarCuentaTesterPO =
                new EliminarCuentaTesterPO(browser);

        eliminarCuentaTesterPO.clickVerUsuarios();

        String idBotonBorrar = eliminarCuentaTesterPO.obtenerIdBotonBorrar(email);

        IVerify.create().verify(
                email,
                idBotonBorrar,
                "No se encontró el botón de borrar del tester creado"
        );
    }
}