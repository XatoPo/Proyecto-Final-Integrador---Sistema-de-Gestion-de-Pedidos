package interfaces;

import clases.*;
import java.util.List;

public interface listados {
    List<categoria> listCategoria(String id_ctg);
    /*------------------------------------------------------*/
    List<producto> listProducto(String id_produc); 
    List<empleado>  lisEmp();
    List<proovedor>  lisProv();
    /*------------------------------------------------------*/
    List<producto> obtenerProductos();
    List<producto> obtenerProductosPorCategoria(String nom_ctg);
    List<producto> obtenerProductosPorMarca(String marca_produc);
    List<producto> obtenerProductosPorMarcaYCategoria(String marca_produc, String nom_ctg);
    /*------------------------------------------------------*/
    List<empleado> obtenerTodosLosEmpleadosDatos();
    /*------------------------------------------------------*/
    List<proovedor> obtenerTodosLosProveedoresDatos();
    /*------------------------------------------------------*/
    List<pedido> obtenerDatosPedidosParaLista();
}
