import exception.MyRuntime;
import tests.Cuenta;

import java.math.BigDecimal;

public class CuentaDeAhorro extends Cuenta {
    private BigDecimal saldoAhorrado = BigDecimal.ZERO;

    public synchronized void reservar(BigDecimal valor) {
        if (primeroMenorAlSegundo(valor, super.saldo)) {
            super.extraccion(valor);
            this.saldoAhorrado = this.saldoAhorrado.add(valor);
        } else {
            throw new MyRuntime("tu saldo es: " + saldo + " no posees suficiente para ahorrar");
        }
    }

    public synchronized void reintegrar(BigDecimal valor) {
        if (primeroMenorAlSegundo(valor, saldoAhorrado)) {
            super.depositar(valor);
            this.saldoAhorrado = this.saldoAhorrado.subtract(valor);
        } else {
            throw new MyRuntime("no se puede reintegrar " + valor + " es superior al que tiene " + this.saldoAhorrado);
        }
    }

    public BigDecimal verSaldoAhorrado(){
        return this.saldoAhorrado;
    }
}
