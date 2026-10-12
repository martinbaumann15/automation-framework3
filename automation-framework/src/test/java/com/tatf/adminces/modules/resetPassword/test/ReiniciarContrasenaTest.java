package com.tatf.adminces.modules.resetPassword.test;

import com.tatf.adminces.modules.access.data.AccessData;
import com.tatf.adminces.modules.access.task.AccessTask;
import com.tatf.adminces.modules.base.BaseTest;
import com.tatf.adminces.modules.login.data.LoginData;
import com.tatf.adminces.modules.login.task.LoginTask;
import com.tatf.adminces.modules.resetPassword.task.ResetPasswordTask;
import com.tatf.core.verification.IVerify;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;

@Tag("regressiontest")
public class ReiniciarContrasenaTest extends BaseTest {

    @ParameterizedTest
    @DisplayName("Reiniciar contraseña")
    @Tag("gestioncuenta")
    @CsvSource({
            "leonardoperez@gmail.com, 12345, 12345"
    })
    void reiniciarContrasena(
            String email,
            String password,
            String repeatPassword) {

        browser.interaction().navigateTo(AccessData.url);

        AccessTask accessTask = new AccessTask(browser);
        accessTask.acceder(AccessData.hash);

        LoginTask loginTask = new LoginTask(browser);
        loginTask.iniciarSesion(LoginData.email, LoginData.password);

        ResetPasswordTask resetPasswordTask = new ResetPasswordTask(browser);
        resetPasswordTask.reiniciarContrasena(
                email,
                password,
                repeatPassword
        );

        String mensaje = resetPasswordTask.obtenerMensaje();

        IVerify.create().verify(
                "Contraseña reiniciada.",
                mensaje,
                "El mensaje de reinicio de contraseña no es el esperado"
        );

        resetPasswordTask.clickConfirmarPopup();

        LoginTask nuevoLoginTask = new LoginTask(browser);
        nuevoLoginTask.cerrarSesion();
        nuevoLoginTask.iniciarSesionSinCerrarPopup(email, password);

        String mensajeLogin = nuevoLoginTask.obtenerMensaje();

        IVerify.create().verify(
                "Sesión iniciada.",
                mensajeLogin,
                "No se pudo iniciar sesión con la nueva contraseña"
        );
    }
}