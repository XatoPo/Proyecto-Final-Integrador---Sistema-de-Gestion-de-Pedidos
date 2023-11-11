package interfaces;

import clases.*;
import java.util.List;

public interface registros {
    void adiContacto(contacto contac);
    void adiPedido(pedido pedid, List<detalle_pedido> lista_productos);
    //String adiPedido(pedido pedid, List<detalle_pedido> lista_productos);
    void adiEmpleado(empleado emp);
    void adiGuia(gui_entrega guia);
    void adiProducto(producto produc);
    void adiProovedor(proovedor prov);
    void adiUbigeo(ubigeo ubigeo);
    void adiContactoEmp(contacto c);
    void adiUbigeoEmp(ubigeo u);

}
