package interfaces;

import clases.*;
import java.util.List;

public interface registros {
    void adiContacto(contacto contac);
    void registrarDetallePedido(String id_pedi, detalle_pedido deta_pedi);
    void registrarPedido(pedido pedi);
    void adiEmpleado(empleado emp);
    void adiProveedor(proovedor emp);
    void adiGuia(gui_entrega guia);
    void adiProducto(producto produc);
    void adiProovedor(proovedor prov);
    void adiUbigeo(ubigeo ubigeo);
    void adiContactoEmp(contacto c);
    void adiUbigeoEmp(ubigeo u);
    void adiContactoProv(contacto c);
    void adiUbigeoProv(ubigeo u);

}
