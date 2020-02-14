import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tests.Cuenta;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CuentaDeAhorroTest extends Cuenta {
    Cuenta cuentaOrigen;
    CuentaDeAhorro cuentaDeAhorro;
    CuentaCorriente cuentaCorriente;

    @Before
    public void setup() {
        //para que instancia unica vez y la limpie  :v
        //System.out.println("Before");
        cuentaOrigen = new Cuenta();
        cuentaDeAhorro = new CuentaDeAhorro();
        cuentaCorriente = new CuentaCorriente(new BigDecimal(1000));
    }

    @Test
    public void iniciar() {
        cuentaOrigen.depositar(new BigDecimal(10000));
        //System.out.println(cuentaOrigen.consultarSaldo());
        Assert.assertEquals(new BigDecimal(10000), cuentaOrigen.consultarSaldo());
        Assert.assertEquals(new BigDecimal(0), cuentaDeAhorro.consultarSaldo());
    }

    @Test
    public void reservarEnCuentaAhorro() {
        cuentaDeAhorro.depositar(new BigDecimal(10000));
        cuentaDeAhorro.reservar(new BigDecimal(550));
        Assert.assertEquals(new BigDecimal(9450), cuentaDeAhorro.consultarSaldo());
        Assert.assertEquals(new BigDecimal(550), cuentaDeAhorro.verSaldoAhorrado());
    }

    @Test
    public void reintegrarEnCuenta() {
        cuentaDeAhorro.depositar(new BigDecimal(10000));
        cuentaDeAhorro.reservar(new BigDecimal(550));
        cuentaDeAhorro.reintegrar(new BigDecimal(550));

        Assert.assertEquals(new BigDecimal(10000), cuentaDeAhorro.consultarSaldo());
        Assert.assertEquals(new BigDecimal(0), cuentaDeAhorro.verSaldoAhorrado());
    }

    @Test
    public void valorSaldo() {
        Boolean valor = cuentaDeAhorro.primeroMenorAlSegundo(new BigDecimal(30), new BigDecimal(40));
        assertEquals(true, valor);
    }

    @Test
    public void cuentaCorriente() {
        cuentaCorriente.depositar(new BigDecimal(100));
        Assert.assertEquals(new BigDecimal(100), cuentaCorriente.consultarSaldo());
        cuentaCorriente.retirarDisponible(new BigDecimal(10));
        Assert.assertEquals(new BigDecimal(90), cuentaCorriente.consultarSaldo());
        Assert.assertEquals(new BigDecimal(1000), cuentaCorriente.getDescubierto());
    }

    @Test
    public void cuentaCorriente2() {
        cuentaCorriente.depositar(new BigDecimal(50));

        Assert.assertEquals(new BigDecimal(0), cuentaCorriente.verDeuda());
        Assert.assertEquals(new BigDecimal(50), cuentaCorriente.consultarSaldo());
        Assert.assertEquals(new BigDecimal(1000), cuentaCorriente.getDescubierto());
        Assert.assertEquals(new BigDecimal(1050), cuentaCorriente.variableAuxiliar);

        cuentaCorriente.retirarDisponible(new BigDecimal(150));
        Assert.assertEquals(new BigDecimal(100), cuentaCorriente.verDeuda());
        Assert.assertEquals(new BigDecimal(0), cuentaCorriente.consultarSaldo());
        Assert.assertEquals(new BigDecimal(900), cuentaCorriente.getDescubierto());
        Assert.assertEquals(new BigDecimal(900), cuentaCorriente.variableAuxiliar);
    }

    @Test
    public void extraccionCuentaCorriente(){
        cuentaCorriente.depositar(new BigDecimal(100));
        cuentaCorriente.retirarDisponible(new BigDecimal(1100));
        Assert.assertEquals(new BigDecimal(1000), cuentaCorriente.verDeuda());
        Assert.assertEquals(new BigDecimal(0), cuentaCorriente.consultarSaldo());
        Assert.assertEquals(new BigDecimal(0), cuentaCorriente.getDescubierto());
        //Assert.assertEquals(new BigDecimal(900), cuentaCorriente.variableAuxiliar);

        cuentaCorriente.depositar(new BigDecimal(800));
        Assert.assertEquals(new BigDecimal(200), cuentaCorriente.verDeuda());
        Assert.assertEquals(new BigDecimal(0), cuentaCorriente.consultarSaldo());

    }

    @Test
    public void setCuentaCorriente3(){
        cuentaCorriente.depositar(new BigDecimal(100));
        cuentaCorriente.retirarDisponible(new BigDecimal(1100));
        //System.out.println(cuentaCorriente.verDeuda());

        cuentaCorriente.depositar(new BigDecimal(300));

        Assert.assertEquals(new BigDecimal(0), cuentaCorriente.getDescubierto());
        Assert.assertEquals(new BigDecimal(700), cuentaCorriente.verDeuda());
        Assert.assertEquals(new BigDecimal(0), cuentaCorriente.consultarSaldo());
        /*
        System.out.println(cuentaCorriente.verDeuda());
        System.out.println(cuentaCorriente.consultarSaldo());
        System.out.println(cuentaCorriente.variableAuxiliar); */

        cuentaCorriente.depositar(new BigDecimal(800));
        /*System.out.println(cuentaCorriente.verDeuda());
        System.out.println(cuentaCorriente.consultarSaldo());
        System.out.println(cuentaCorriente.variableAuxiliar);*/

        cuentaCorriente.depositar(new BigDecimal(300));
        System.out.println(cuentaCorriente.verDeuda());
        System.out.println(cuentaCorriente.consultarSaldo());
        System.out.println(cuentaCorriente.variableAuxiliar);

        cuentaCorriente.retirarDisponible(new BigDecimal(1400));
        System.out.println(cuentaCorriente.verDeuda());
        System.out.println(cuentaCorriente.consultarSaldo());
        System.out.println(cuentaCorriente.variableAuxiliar);
        /*
        cuentaCorriente.depositar(new BigDecimal(300));
        System.out.println(cuentaCorriente.verDeuda());
        System.out.println(cuentaCorriente.consultarSaldo());
        System.out.println(cuentaCorriente.variableAuxiliar); */
    }
}