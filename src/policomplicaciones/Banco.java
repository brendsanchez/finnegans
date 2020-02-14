package policomplicaciones;

import tests.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
    private List<Cuenta> listaDeCuentas;
    private List<Transaccion> listaDeTransacciones = new ArrayList<>();

    public Banco(List<Cuenta> listaDeCuentas) {
        this.listaDeCuentas = listaDeCuentas;
    }

    public List<Transaccion> verTransacciones() {
        /*for (Cuenta cuenta : listaDeCuentas) {
            listaDeTransacciones.addAll(cuenta.getTransaccions());
        }*/
        return listaDeCuentas.stream()
                .flatMap(cuenta -> cuenta.getTransaccions()
                        .stream()).collect(Collectors.toList());
    }

    public List<Transaccion> verTransacciones(Cuenta cuenta) {
        /*for (Cuenta cuenta : listaDeCuentas) {
            listaDeTransacciones.addAll(cuenta.getTransaccions());
        }*/
        return this.cuentaFiltrada(cuenta).stream()
                .flatMap(c -> c.getTransaccions()
                        .stream()).collect(Collectors.toList());
    }

    private List<Cuenta> cuentaFiltrada(Cuenta cuenta) {
        return listaDeCuentas.stream()
                .filter(c -> c.equals(cuenta))
                .collect(Collectors.toList());
    }
}
