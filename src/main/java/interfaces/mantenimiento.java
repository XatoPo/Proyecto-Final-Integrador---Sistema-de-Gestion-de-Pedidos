package interfaces;

import clases.*;

public interface mantenimiento {
    void editEmpleado(empleado emp);
    void editProducto(producto p);
    void modificarContacto(contacto c);  
    void modificarUbigeo(ubigeo u);   
    void editProveedor(proovedor prov);
    void eliminarProveedor(String prov);
    void eliminarEmpleado(String emp);
}
