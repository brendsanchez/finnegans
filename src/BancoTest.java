import org.junit.Before;
import org.junit.Test;
import policomplicaciones.Banco;
import cuenta.Cuenta;

import java.math.BigDecimal;
import java.util.*;

public class BancoTest extends Cuenta {
    Cuenta cuentaOrigen;
    CuentaDeAhorro cuentaDeAhorro;
    CuentaCorriente cuentaCorriente;
    Banco banco1;

    @Before
    public void setUp() throws Exception {
        cuentaOrigen = new Cuenta();
        cuentaDeAhorro = new CuentaDeAhorro();
        cuentaCorriente = new CuentaCorriente(new BigDecimal(1000));
        banco1 = new Banco(Arrays.asList(cuentaCorriente, cuentaDeAhorro));
    }

    @Test
    public void banco() {
        cuentaDeAhorro.depositar(new BigDecimal(1000));
        cuentaCorriente.depositar(new BigDecimal(3000));
        cuentaCorriente.transferir(new BigDecimal(2000), cuentaDeAhorro);
        cuentaDeAhorro.transferir(new BigDecimal(100), cuentaCorriente);

        System.out.println(banco1.verTransacciones());
        System.out.println(banco1.verTransacciones(cuentaDeAhorro));
    }
}