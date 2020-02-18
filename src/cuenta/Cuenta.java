package cuenta;

import exception.MyRuntime;
import policomplicaciones.Transaccion;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

public class Cuenta {
    protected BigDecimal saldo = BigDecimal.ZERO;
    private ArrayList<Transaccion> transaccions = new ArrayList<>();

    public void depositar(BigDecimal valor) {
        if (this.valorEsPositivo(valor)) {
            transaccions.add(new Transaccion("depositar", valor));
            this.saldo = this.saldo.add(valor);
        } else {
            throw new MyRuntime("error depositar " + valor + " es negativo");
        }
    }

    public void extraccion(BigDecimal valor) {
        if (this.valorEsPositivo(valor)) {
            if (primeroMenorAlSegundo(valor, saldo)) {
                this.saldo = this.saldo.subtract(valor);
                transaccions.add(new Transaccion("extraccion", valor));
            } else {
                throw new MyRuntime("no tienes suficiente fondos para extraer " + valor + ", en la cuenta tienes: " + this.consultarSaldo());
            }
        } else {
            throw new MyRuntime("error extraccion " + valor + " es negativo");
        }
    }

    public BigDecimal consultarSaldo() {
        return saldo;
    }

    protected boolean valorEsPositivo(BigDecimal valor) {
        return valor.signum() == 1;
    }

    public synchronized void transferir(BigDecimal cantidad, Cuenta cuentaATransferir) {
        transaccions.add(new Transaccion("transferencia", cantidad));
        cuentaATransferir.depositar(cantidad);
        this.extraccion(cantidad);
    }

    public static boolean primeroMenorAlSegundo(BigDecimal valor, BigDecimal saldo) {
        return saldo.compareTo(valor) == 1 || saldo.compareTo(valor) == 0;
    }


    public ArrayList<Transaccion> getTransaccions() {
        return transaccions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(saldo, cuenta.saldo) &&
                Objects.equals(transaccions, cuenta.transaccions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(saldo, transaccions);
    }

    public void movimiento(String motivo, int monto){
        this.extraccion(new BigDecimal(monto));
        transaccions.add(new Transaccion(motivo, new BigDecimal(monto)));
    }
}
