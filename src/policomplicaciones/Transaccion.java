package policomplicaciones;

import java.math.BigDecimal;
import java.util.Date;

public class Transaccion {
    private Date fecha;
    private String motivo;
    private BigDecimal monto;

    public Transaccion(String motivo, BigDecimal monto) {
        fecha = new Date();
        this.motivo = motivo;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "fecha=" + fecha +
                ", motivo='" + motivo + '\'' +
                ", monto=" + monto +
                '}';
    }
}
