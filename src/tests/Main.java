package tests;

import tests.Cuenta;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
/*
        tests.Cuenta miCuenta = new tests.Cuenta();

        miCuenta.depositar(new BigDecimal(100));
        System.out.println(miCuenta.consultarSaldo());

        miCuenta.extraccion(new BigDecimal(1000));
        System.out.println(miCuenta.consultarSaldo());*/
        // main
        Cuenta cuentaOrigen = new Cuenta();
        cuentaOrigen.depositar(new BigDecimal (10000));
        System.out.println(cuentaOrigen.consultarSaldo()); // 10000

        Cuenta cuentaDestino = new Cuenta();
        System.out.println(cuentaDestino.consultarSaldo()); // 0

        cuentaOrigen.transferir(new BigDecimal(550), cuentaDestino);
        System.out.println(cuentaOrigen.consultarSaldo()); // 9450
        System.out.println(cuentaDestino.consultarSaldo()); // 550

    }
}
