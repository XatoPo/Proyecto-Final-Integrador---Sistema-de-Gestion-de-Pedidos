package interfaces;

import clases.categoria;
import clases.empleado;
import java.util.List;

public interface busquedas {
    String obtenerUltimoIdEmpleado();
    List<categoria> obtenerNombresCategorias();
    empleado obtenerDatosUnEmpleado(String id_emp);
}
