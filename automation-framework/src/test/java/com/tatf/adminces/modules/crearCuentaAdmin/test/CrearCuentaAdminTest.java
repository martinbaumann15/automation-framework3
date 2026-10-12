package com.tatf.adminces.modules.crearCuentaAdmin.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.crearCuentaAdmin.task.CrearCuentaAdminTask;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Tags({
        @Tag("smoketest"),
        @Tag("regressiontest")
})
public class CrearCuentaAdminTest extends BaseTest {

    @ParameterizedTest(name = "{arguments}")
    @DisplayName("Crear cuenta de administrador")
    @Tag("creacioncuenta")
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

        String mensajeRegistro = registerTask.obtenerMensaje();

        IVerify.create().verify(
                "Usuario creado.",
                mensajeRegistro,
                "El mensaje de creación no es el esperado"
        );

        registerTask.clickConfirmarPopup();

        LoginTask loginTask = new LoginTask(browser);
        loginTask.iniciarSesionSinCerrarPopup(email, password);

        String mensajeLogin = loginTask.obtenerMensaje();

        IVerify.create().verify(
                "Sesión iniciada.",
                mensajeLogin,
                "No se pudo iniciar sesión con la cuenta de administrador creada"
        );
    }
}