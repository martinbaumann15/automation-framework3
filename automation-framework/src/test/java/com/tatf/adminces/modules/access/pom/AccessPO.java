package com.tatf.adminces.modules.access.pom;

import com.tatf.core.browser.IBrowser;

public class AccessPO {

    private final IBrowser browser;

    public AccessPO(IBrowser browser) {
        this.browser = browser;
    }

    public void escribirHash(String hash) {
        browser.find().css("#pass").write(hash);
    }

    public void clickSubmit() {
        browser.find().css("button[type='submit']").click();
    }
}