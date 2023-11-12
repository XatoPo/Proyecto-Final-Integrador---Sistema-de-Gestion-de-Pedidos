package interfaces;

import clases.categoria;
import clases.empleado;
import clases.proovedor;
import java.util.List;

public interface busquedas {
    String obtenerUltimoIdEmpleado();
    List<categoria> obtenerNombresCategorias();
    empleado obtenerDatosUnEmpleado(String id_emp);
    proovedor obtenerDatosProveedor(String id_prov);
    String generarNuevoIDPedido();
}
