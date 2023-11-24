package interfaces;

import clases.*;
import java.util.List;

public interface busquedas {
    String obtenerUltimoIdEmpleado();
    List<categoria> obtenerNombresCategorias();
    empleado obtenerDatosUnEmpleado(String id_emp);
    proovedor obtenerDatosProveedor(String id_prov);
    String generarNuevoIDPedido();
    producto obtenerDatosProducto(String id_produc);
    String ObtenerCategoriaID(String nom_ctg);
}
