package com.tatf.adminces.suite;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.IncludeTags;

@Suite
@SuiteDisplayName("Suite Regression Test")
@SelectPackages("com.tatf.adminces.modules")
@IncludeTags("regressiontest")
public class SuiteRegressionTest {
}