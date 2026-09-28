package com.tatf.adminces.modules.access.task;

import com.tatf.adminces.modules.access.pom.AccessPO;
import com.tatf.core.browser.IBrowser;

public class AccessTask {

    private AccessPO accessPO;

    public AccessTask(IBrowser browser) {
        this.accessPO = new AccessPO(browser);
    }

    public void acceder(String hash) {
        accessPO.escribirHash(hash);
        accessPO.clickSubmit();
    }
}