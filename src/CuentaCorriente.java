import exception.MyRuntime;
import cuenta.Cuenta;

import java.math.BigDecimal;

public class CuentaCorriente extends Cuenta {
    public BigDecimal variableAuxiliar;
    private BigDecimal descubierto;
    private BigDecimal montoDebe = BigDecimal.ZERO;

    public CuentaCorriente(BigDecimal descubierto) {
        this.descubierto = this.validacionDescubierto(descubierto);
        llenarTotalDisponible(descubierto);
    }

    private BigDecimal validacionDescubierto(BigDecimal descubierto) {
        if (descubierto.signum() == 1 || descubierto.signum() == 0) {
            return this.descubierto = descubierto;
        } else {
            throw new MyRuntime("el valor descubierto es negativo");
        }
    }

    private void llenarTotalDisponible(BigDecimal descubierto) {
        variableAuxiliar = descubierto;
    }

    @Override
    public void depositar(BigDecimal valor) {
        //300
        if (primeroMenorAlSegundo(valor, montoDebe)) {
            montoDebe = montoDebe.subtract(valor);
        } else {
            if (primeroMenorAlSegundo(montoDebe, valor) && montoDebe.compareTo(BigDecimal.ZERO) > 0) {
                descubierto = descubierto.add(new BigDecimal(1000));
                super.depositar(valor.subtract(montoDebe));
                montoDebe = BigDecimal.ZERO;
                variableAuxiliar = descubierto;
                variableAuxiliar = variableAuxiliar.add(super.saldo);
            } else {
                variableAuxiliar = variableAuxiliar.add(valor.subtract(montoDebe));
                super.depositar(valor.subtract(montoDebe));
            }
        }
    }

    //funciona pero se deberia mejorar =)
    public void retirarDisponible(BigDecimal valor) {
        BigDecimal montoUtilizadoDeDescubierto = BigDecimal.ZERO;
        if (primeroMenorAlSegundo(valor, super.saldo)) {
            super.extraccion(valor);
            variableAuxiliar = variableAuxiliar.subtract(valor);
        } else if (primeroMenorAlSegundo(valor, variableAuxiliar)) {
            montoUtilizadoDeDescubierto = variableAuxiliar.subtract(descubierto);
            super.extraccion(montoUtilizadoDeDescubierto);
            descubierto = descubierto.subtract(valor.subtract(montoUtilizadoDeDescubierto));
            variableAuxiliar = variableAuxiliar.subtract(valor);
            montoDebe = montoDebe.add(valor.subtract(montoUtilizadoDeDescubierto));
        } else {
            throw new MyRuntime("supera el monto disponible total ");
        }
    }

    public BigDecimal getDescubierto() {
        return descubierto;
    }

    public BigDecimal verDeuda() {
        return montoDebe;
    }
}
