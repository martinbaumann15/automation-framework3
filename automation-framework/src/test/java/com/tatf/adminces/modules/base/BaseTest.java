package com.tatf.adminces.modules.base;

import com.tatf.core.browser.BrowserFactory;
import com.tatf.core.browser.IBrowser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected static IBrowser browser;

    @BeforeEach
    void beforeEach() {
        browser = BrowserFactory.getBrowser(true);
    }

    @AfterEach
    void afterEach() {
        BrowserFactory.quitBrowser();
    }
}
