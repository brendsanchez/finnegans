package policomplicaciones;

import cuenta.Cuenta;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TarjetaDebitoTest extends cuenta.Cuenta {


    @Test
    public void tarjetaDebito() {
        Cuenta cuenta = new Cuenta();
        cuenta.depositar(new BigDecimal(1000));

        TarjetaDebito tarjetaDebito = new TarjetaDebito(cuenta);
        tarjetaDebito.comprar("zapatilla", 1000);
        Assertions.assertEquals(cuenta.consultarSaldo(), new BigDecimal(0));
    }

    @Test
    public void plazoFijo() {
        Cuenta cuenta = new Cuenta();
        cuenta.depositar(new BigDecimal(1000));

        PlazoFijo plazoFijo = new PlazoFijo(cuenta,0.35 );
        plazoFijo.realizarPlazoFijo(1000.0,12);

        assertEquals(plazoFijo.getMontoTotal(), 1412);
    }

    @Test
    public void tarjetaCredito() {
        Cuenta cuenta = new Cuenta();
        cuenta.depositar(new BigDecimal(1000));

        TajetaDeCredito tajetaDeCredito = new TajetaDeCredito(cuenta);

        tajetaDeCredito.comprar("zapatillas", 500);
        tajetaDeCredito.comprar("juego", 200);

        assertEquals(tajetaDeCredito.getComprasSuma(), 721.0, 0);
        //assertEquals();
        tajetaDeCredito.cobrarse();
        assertEquals(cuenta.consultarSaldo(),new BigDecimal(279.0));

    }
}