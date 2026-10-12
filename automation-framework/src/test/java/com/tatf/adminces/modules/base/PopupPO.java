package com.tatf.adminces.modules.base;

import com.tatf.core.browser.IBrowser;

public class PopupPO {

    private final IBrowser browser;

    public PopupPO(IBrowser browser) {
        this.browser = browser;
    }

    public void clickConfirmar() {
        browser.find().css("button.swal2-confirm").click();
    }

    public String obtenerMensaje() {
        browser.wait("#swal2-html-container").css();
        return browser.find().css("#swal2-html-container").getText();
    }
}