package com.tatf.adminces.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("AdminCES - Gestión de cuentas")
@SelectPackages("com.tatf.adminces.modules")
@IncludeTags("gestioncuenta")
public class SuiteGestionCuentas {
}