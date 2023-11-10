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
    List<empleado> listEmpleado(String id_emp);
    List<proovedor> listProovedor(String id_prov);
    List<gui_entrega> listGia(String id_guia);
    List<producto> listProducto(String id_produc); 
    List<empleado>  lisEmp();
    /*------------------------------------------------------*/
    List<pedido> listPedido(String id_pedi);
    List<detalle_pedido> listDetallePedido (String id_pedi);
    
    
}
