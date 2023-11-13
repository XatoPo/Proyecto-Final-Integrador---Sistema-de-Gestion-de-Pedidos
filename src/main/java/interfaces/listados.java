package interfaces;

import clases.*;
import java.util.List;

public interface listados {
    List<categoria> listCategoria(String id_ctg);
    /*------------------------------------------------------*/
    List<contacto> listContactoEmpleado (String id_contac, String id_emp);
    List<contacto> listContactoProovedor (String id_contac, String id_prov);
    List<ubigeo> listUbigeoEmpleado (String id_ubigeo, String id_emp);
    List<ubigeo> listUbigeoProovedor (String id_ubigeo, String id_prov);
    /*------------------------------------------------------*/
    List<proovedor> listProovedor(String id_prov);
    List<gui_entrega> listGia(String id_guia);
    List<producto> listProducto(String id_produc); 
    List<empleado>  lisEmp();
    List<proovedor>  lisProv();
    /*------------------------------------------------------*/
    List<pedido> listPedido(String id_pedi);
    List<detalle_pedido> listDetallePedido (String id_pedi);
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
