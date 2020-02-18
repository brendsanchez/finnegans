package cuenta;

import exception.MyRuntime;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class MainTest {
    Cuenta miCuenta;

    @Before
    public void setup(){
        //para que instancia unica vez y la limpie  :v
        System.out.println("Before");
        miCuenta = new Cuenta();
    }


    @Test
    void testMain() {
        //tests.Cuenta miCuenta = new tests.Cuenta();

        //System.out.println(miCuenta.depositar(new BigDecimal(100)));
        //System.out.println(miCuenta.extraccion(new BigDecimal(100)));
        //System.out.println(miCuenta.depositar(new BigDecimal(100)));

        miCuenta.depositar(new BigDecimal(1000));
        //ssertEquals(new BigDecimal(100), miCuenta.getSaldo());
        //System.out.println(miCuenta.getSaldo());
        Assertions.assertEquals(new BigDecimal(1010), miCuenta.consultarSaldo());
    }

    @Test
    public void excepciones(){
        try{
            miCuenta.extraccion(new BigDecimal(100));
            System.out.println(miCuenta.consultarSaldo());
        }catch (MyRuntime e){
            System.out.println(e);
        }

        try{
            miCuenta.depositar(new BigDecimal(10));
            System.out.println(miCuenta.consultarSaldo());
        }catch (MyRuntime e){
            System.out.println(e);
        }
    }
}