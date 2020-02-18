package policomplicaciones;

import cuenta.Cuenta;

import java.math.BigDecimal;


public class PlazoFijo {
    private final double interesAnual;
    private int montoTotal;
    private Cuenta cuenta;

    public PlazoFijo(Cuenta cuenta, double interesAnual) {
        this.cuenta = cuenta;
        this.interesAnual = interesAnual;
    }

    public void realizarPlazoFijo(Double monto, int cantidadMeses) {
        this.cuenta.movimiento("realiza plazo fijo", monto.intValue());
        this.montoTotal = (int) Math.round(monto * Math.pow(impuestoMes(), cantidadMeses));
    }

    private double impuestoMes() {
        return 1.0 + (this.interesAnual / 12);
    }

    public void cobrarPlazoFijo() {
        this.cuenta.depositar(new BigDecimal(this.montoTotal));
    }

    public int getMontoTotal() {
        return montoTotal;
    }
}
