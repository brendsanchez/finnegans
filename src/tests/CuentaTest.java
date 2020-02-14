package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;


public class CuentaTest {
    Cuenta cuentaOrigen;
    Cuenta cuentaDestino;

    @Before
    public void setup(){
        //para que instancia unica vez y la limpie  :v
        System.out.println("Before");
        cuentaOrigen = new Cuenta();
        cuentaDestino = new Cuenta();
    }

    @Test
    public void depositar(){
        cuentaOrigen.depositar(new BigDecimal(10000));
        //System.out.println(cuentaOrigen.consultarSaldo());
        Assert.assertEquals(new BigDecimal(10000), cuentaOrigen.consultarSaldo());
        Assert.assertEquals(new BigDecimal(0), cuentaDestino.consultarSaldo());
    }

    @Test
    public void transferir(){
        cuentaOrigen.depositar(new BigDecimal(10000));
        Assert.assertEquals(new BigDecimal(10000), cuentaOrigen.consultarSaldo());
        cuentaOrigen.transferir(new BigDecimal(550), cuentaDestino);
        //System.out.println(cuentaOrigen.consultarSaldo());
        Assert.assertEquals(new BigDecimal(9450), cuentaOrigen.consultarSaldo());
        Assert.assertEquals(new BigDecimal(550), cuentaDestino.consultarSaldo());
        //System.out.println(cuentaOrigen.consultarSaldo()); // 9450
        //System.out.println(cuentaDestino.consultarSaldo()); // 550
    }


    @Test
    public void cajaAhorroTransferencia(){
        cuentaOrigen.depositar(new BigDecimal(10000));
    }
}