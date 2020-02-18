package policomplicaciones;

import cuenta.Cuenta;

public class TarjetaDebito {
    private Cuenta cuenta;

    public TarjetaDebito(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void comprar(String motivo, int monto) {
        cuenta.movimiento("tarjeta de Debito compra" + motivo, monto);
    }
}
