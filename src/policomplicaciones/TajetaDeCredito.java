package policomplicaciones;

import cuenta.Cuenta;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;


public class TajetaDeCredito {
    private Cuenta cuenta;
    private Double comprasSuma = 0d;
    private List<Transaccion> comprasConTarjeta = new LinkedList<>();

    public TajetaDeCredito(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void comprar(String motivo, int monto) {
        comprasSuma += monto * 1.03;
        comprasConTarjeta.add(new Transaccion(motivo, new BigDecimal(monto)));
    }

    void cobrarse() {
        this.cuenta.movimiento("pago tarjeta de Credito", comprasSuma.intValue());
        //todo se tiene que preguntar que cuando no tiene salgo suficiente siga teniendo la deuda
        comprasSuma = 0d;
    }


    public Double getComprasSuma() {
        return comprasSuma;
    }
}
