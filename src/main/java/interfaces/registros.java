package interfaces;

import clases.*;

public interface registros {
    void registrarDetallePedido(String id_pedi, detalle_pedido deta_pedi);
    void registrarPedido(pedido pedi);
    void adiEmpleado(empleado emp);
    void adiProveedor(proovedor emp);
    void adiGuia(gui_entrega g);
    void adiProducto(producto produc);
    void adiContactoEmp(contacto c);
    void adiUbigeoEmp(ubigeo u);
    void adiContactoProv(contacto c);
    void adiUbigeoProv(ubigeo u);

}
