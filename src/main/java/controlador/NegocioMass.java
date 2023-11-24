package controlador;

import java.sql.*;
import java.util.*;
import clases.*;
import interfaces.*;
import util.MySQLConexion;

public class NegocioMass implements registros, listados, mantenimiento, login, busquedas {
    
    /*-----REGISTRO DE DATOS-----*/
    @Override
    public void adiEmpleado(empleado e){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spAdicionEmpleado (?, ?, ?, ?, ?, ?, ?)}";
        try{           
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1, e.getNom_pat_emp());
            st.setString(2, e.getNom_mat_emp());
            st.setString(3, e.getApe_pat_emp());
            st.setString(4, e.getApe_mat_emp());
            st.setString(5, e.getCargo_emp());
            st.setString(6, e.getFech_nac_emp());         
            st.setString(7, e.getPassword_emp());
            int rowsAffected = st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void eliminarEmpleado(String idEmpleado) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spEliminarEmpleado (?)}";
        try {           
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, idEmpleado);
            int rowsAffected = st.executeUpdate();
            // Hacer algo con el resultado si es necesario
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void editEmpleado(empleado e) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spModificarEmpleado (?, ?, ?, ?, ?, ?, ?, ?)}";
        try {
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, e.getId_emp());  // Id del empleado que se va a modificar
            st.setString(2, e.getNom_pat_emp());
            st.setString(3, e.getNom_mat_emp());
            st.setString(4, e.getApe_pat_emp());
            st.setString(5, e.getApe_mat_emp());
            st.setString(6, e.getCargo_emp());
            st.setString(7, e.getFech_nac_emp());
            st.setString(8, e.getPassword_emp());
            int rowsAffected = st.executeUpdate();
            // Puedes agregar lógica adicional según tus necesidades, por ejemplo, verificar rowsAffected
        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    
    public void eliminarProducto(String idProducto) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spEliminarProducto (?)}";
        try {           
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, idProducto);
            int rowsAffected = st.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void editProducto(producto p){
        Connection cn = MySQLConexion.getConexion();
        String sqlConsulta = "SELECT id_ctg FROM categoria WHERE nom_ctg = ?";
        try {
            PreparedStatement consulta = cn.prepareStatement(sqlConsulta);
            consulta.setString(1, p.getNom_ctg());
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                String idCtg = rs.getString("id_ctg");
                String sql = "{CALL spModificarProducto (?, ?, ?, ?, ?, ?, ?)}";
                CallableStatement st = cn.prepareCall(sql);
                st.setString(1, p.getId_produc()); 
                st.setString(2, p.getNom_produc());
                st.setString(3, p.getMarca_produc());
                st.setDouble(4, p.getPrecio_empaq_produc());
                st.setInt(5, p.getCant_x_empaq_produc());
                st.setString(6, idCtg);
                st.setString(7, p.getTipo_empq_produc());
                int rowsAffected = st.executeUpdate();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
    
    
    @Override
    public void adiProveedor(proovedor p){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spAdicionProveedor (?, ?)}";
        try{           
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1,p.getNom_prov());            
            st.setString(2, p.getDescd_prov());            
            int rowsAffected = st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override
    public void eliminarProveedor(String idProveedor) {
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spEliminarProveedor (?)}";
        try {           
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, idProveedor);
            int rowsAffected = st.executeUpdate();
            // Hacer algo con el resultado si es necesario
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void editProveedor(proovedor p) {
    Connection cn = MySQLConexion.getConexion();
    String sql = "{CALL spModificarProveedor (?, ?, ?)}";
    try {           
        CallableStatement st = cn.prepareCall(sql);
        st.setString(1, p.getId_prov());  // El ID del proveedor que deseas modificar
        st.setString(2, p.getNom_prov()); // El nuevo nombre del proveedor
        st.setString(3, p.getDescd_prov()); // La nueva descripción del proveedor
        int rowsAffected = st.executeUpdate();
        // Hacer algo con el resultado si es necesario
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

        
    @Override   
    public List<empleado> lisEmp(){
        List<empleado> lista=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="select id_emp, nom_pat_emp, ape_pat_emp, ape_mat_emp, cargo_emp, fech_nac_emp from empleado";
           PreparedStatement st=cn.prepareStatement(sql);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               empleado men=new empleado();
               men.setId_emp(rs.getString(1));
               men.setNom_pat_emp(rs.getString(2));
               men.setApe_pat_emp(rs.getString(3));
               men.setApe_mat_emp(rs.getString(4));
               men.setCargo_emp(rs.getString(5));
               men.setFech_nac_emp(rs.getString(6));

               lista.add(men);
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lista;  
    }
    
    @Override   
    public List<proovedor> lisProv(){
        List<proovedor> lista=new ArrayList();
        Connection cn=MySQLConexion.getConexion();
        try{
           String sql="select id_prov, nom_prov, descd_prov, id_ubigeo, id_contac from proveedor";
           PreparedStatement st=cn.prepareStatement(sql);
           ResultSet rs=st.executeQuery();
           while(rs.next()){
               proovedor prov = new proovedor();
               prov.setId_prov(rs.getString(1));
               prov.setNom_prov(rs.getString(2));
               prov.setDescd_prov(rs.getString(3));
               // Initialize datos_ubigeo_prov
                ubigeo datos_ubigeo_prov = new ubigeo();
                datos_ubigeo_prov.setId_ubigeo(rs.getString(4));
                prov.setDatos_ubigeo_prov(datos_ubigeo_prov);
                // Initialize datos_contacto_prov
                contacto datos_contacto_prov = new contacto();
                datos_contacto_prov.setId_contac(rs.getString(5));
                prov.setDatos_contacto_prov(datos_contacto_prov);
                
               lista.add(prov);
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lista;  
    }
    
    @Override
    public void adiContactoEmp(contacto c){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spAdiContactoEmp (?, ?, ?)}";
        try{           
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1, c.getTipo_contac());
            st.setString(2, c.getTelef_contac());
            st.setString(3, c.getEmail_contac());
            int rowsAffected = st.executeUpdate();
    // Hacer algo con el resultado si es necesario        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @Override
    public void modificarContacto(contacto c) {
    Connection cn = MySQLConexion.getConexion();
    String sql = "{CALL spModificarContacto(?, ?, ?, ?)}";
    try {
        CallableStatement st = cn.prepareCall(sql);
        st.setString(1, c.getId_contac());  // ID del contacto que deseas modificar
        st.setString(2, c.getTipo_contac());
        st.setString(3, c.getTelef_contac());
        st.setString(4, c.getEmail_contac());
        int rowsAffected = st.executeUpdate();
        // Hacer algo con el resultado si es necesario
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    
    @Override        
    public void adiUbigeoEmp(ubigeo u){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spAdiUbigeoEmp(?, ?, ?, ?, ?)}";
        try{           
            CallableStatement st=cn.prepareCall(sql);
            //st.setString(1, e.getId_emp());
            st.setString(1, u.getDistrito_ubi());
            st.setString(2, u.getProvincia_ubi());
            st.setString(3, u.getCalle_avend_ubi());
            st.setInt(4, u.getNum_calle_ubi());
            st.setString(5, u.getReferencia_ubi());
            int rowsAffected = st.executeUpdate();
        // Hacer algo con el resultado si es necesario        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }     
    
    @Override
    public void modificarUbigeo(ubigeo u) {
    Connection cn = MySQLConexion.getConexion();
    String sql = "{CALL spModificarUbigeo(?, ?, ?, ?, ?, ?)}";
    try {
        CallableStatement st = cn.prepareCall(sql);
        st.setString(1, u.getId_ubigeo());  // ID del ubigeo que deseas modificar
        st.setString(2, u.getDistrito_ubi());
        st.setString(3, u.getProvincia_ubi());
        st.setString(4, u.getCalle_avend_ubi());
        st.setInt(5, u.getNum_calle_ubi());
        st.setString(6, u.getReferencia_ubi());
        int rowsAffected = st.executeUpdate();
        // Hacer algo con el resultado si es necesario
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    
    @Override
    public void adiContactoProv(contacto c){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spAdiContactoProv (?, ?, ?)}";
        try{           
            CallableStatement st=cn.prepareCall(sql);
            st.setString(1, c.getTipo_contac());
            st.setString(2, c.getTelef_contac());
            st.setString(3, c.getEmail_contac());
            int rowsAffected = st.executeUpdate();
    // Hacer algo con el resultado si es necesario        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    @Override        
    public void adiUbigeoProv(ubigeo u){
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL spAdiUbigeoProv(?, ?, ?, ?, ?)}";
        try{           
            CallableStatement st=cn.prepareCall(sql);
            //st.setString(1, e.getId_emp());
            st.setString(1, u.getDistrito_ubi());
            st.setString(2, u.getProvincia_ubi());
            st.setString(3, u.getCalle_avend_ubi());
            st.setInt(4, u.getNum_calle_ubi());
            st.setString(5, u.getReferencia_ubi());
            int rowsAffected = st.executeUpdate();
        // Hacer algo con el resultado si es necesario        
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }     

    @Override
    public void adiContacto(contacto contac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiGuia(gui_entrega guia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiProducto(producto p) {
        Connection cn = MySQLConexion.getConexion();
        String sqlConsulta = "SELECT id_ctg FROM categoria WHERE nom_ctg = ?";
        try {
            PreparedStatement consulta = cn.prepareStatement(sqlConsulta);
            consulta.setString(1, p.getNom_ctg());
            ResultSet rs = consulta.executeQuery();
            if (rs.next()) {
                String idCtg = rs.getString("id_ctg");
                String sql = "{CALL spAdicionProducto (?, ?, ?, ?, ?, ?)}";
                CallableStatement st = cn.prepareCall(sql);
                st.setString(1, p.getNom_produc());
                st.setString(2, p.getMarca_produc());
                st.setDouble(3, p.getPrecio_empaq_produc());
                st.setInt(4, p.getCant_x_empaq_produc());
                st.setString(5, idCtg);  
                st.setString(6, p.getTipo_empq_produc());
                int rowsAffected = st.executeUpdate();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void adiProovedor(proovedor prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiUbigeo(ubigeo ubigeo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void registrarDetallePedido(String id_pedi, detalle_pedido deta_pedi) {
        Connection cn = MySQLConexion.getConexion();
        String sql="{Call registrarDetallePedido(?, ?, ?, ?)}";
        try{           
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, id_pedi);
            st.setString(2, deta_pedi.getId_produc());
            st.setInt(3, deta_pedi.getCant_produc_pedi());
            st.setDouble(4, deta_pedi.precio_tot_x_produc());
            st.executeQuery();      
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void registrarPedido(pedido pedi) {
        Connection cn = MySQLConexion.getConexion();
        String sql="{Call registrarPedido(?, ?, ?, ?, ?, ?)}";
        try {
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1, pedi.getId_pedi());
            st.setString(2, pedi.getFech_pedi());
            st.setString(3, pedi.getHora_pedi());
            st.setString(4, pedi.getId_prov());
            st.setString(5, pedi.getId_emp());
            st.setString(6, pedi.getEstado_pedi());
            st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*-----LISTADO DE DATOS-----*/
    @Override
    public List<categoria> listCategoria(String id_ctg) {
        List<categoria> list_ctg = new ArrayList();
        Connection connection = MySQLConexion.getConexion();
        String sql = "SELECT * FROM categoria";
        
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                categoria categoria = new categoria();
                categoria.setNom_ctg(resultSet.getString(2));
                categoria.setId_ctg(resultSet.getString(1));
                list_ctg.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_ctg;
    }

    @Override
    public List<contacto> listContactoEmpleado(String id_contac, String id_emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<contacto> listContactoProovedor(String id_contac, String id_prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ubigeo> listUbigeoEmpleado(String id_ubigeo, String id_emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ubigeo> listUbigeoProovedor(String id_ubigeo, String id_prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<proovedor> listProovedor(String id_prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<gui_entrega> listGia(String id_guia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<producto> listProducto(String id_produc) {
        List<producto> list_produc = new ArrayList();
        
        Connection connection = MySQLConexion.getConexion();
        
        try {
            String sql="";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_produc;
    }
    
    public List<producto> obtenerNombresMarcas() {
    List<producto> nombresMarcas = new ArrayList<>();
    Connection cn = MySQLConexion.getConexion();
    try {
        String sql = "{CALL ObtenerNombresMarcas()}";
        CallableStatement cs = cn.prepareCall(sql);
        ResultSet rs = cs.executeQuery();
        while (rs.next()) {
            producto p = new producto();
            p.setMarca_produc(rs.getString(1));
            nombresMarcas.add(p);
        }
    } catch (Exception e) {
        e.printStackTrace();
        }
        return nombresMarcas;
    }
    
    @Override
    public List<producto> obtenerProductos() {
        List<producto> list_produc = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerProductos()}";
            CallableStatement cs = cn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                producto producto = new producto();
                producto.setId_produc(rs.getString(1));
                producto.setNom_produc(rs.getString(2));
                producto.setMarca_produc(rs.getString(3));
                producto.setPrecio_empaq_produc(rs.getDouble(4));
                producto.setCant_x_empaq_produc(rs.getInt(5));
                producto.setId_ctg(rs.getString(6));
                producto.setTipo_empq_produc(rs.getString(7));
                producto.setNom_ctg(rs.getString(8));
                list_produc.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_produc;
    }
    
    @Override
    public List<producto> obtenerProductosPorCategoria(String nom_ctg) {
        List<producto> list_produc = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerProductosPorCategoria(?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, nom_ctg);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                producto producto = new producto();
                producto.setId_produc(rs.getString(1));
                producto.setNom_produc(rs.getString(2));
                producto.setMarca_produc(rs.getString(3));
                producto.setPrecio_empaq_produc(rs.getDouble(4));
                producto.setCant_x_empaq_produc(rs.getInt(5));
                producto.setId_ctg(rs.getString(6));
                producto.setTipo_empq_produc(rs.getString(7));
                producto.setNom_ctg(rs.getString(8));
                list_produc.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_produc;
    }

    @Override
    public List<producto> obtenerProductosPorMarca(String marca_produc) {
        List<producto> list_produc = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerProductosPorMarca(?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, marca_produc);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                producto producto = new producto();
                producto.setId_produc(rs.getString(1));
                producto.setNom_produc(rs.getString(2));
                producto.setMarca_produc(rs.getString(3));
                producto.setPrecio_empaq_produc(rs.getDouble(4));
                producto.setCant_x_empaq_produc(rs.getInt(5));
                producto.setId_ctg(rs.getString(6));
                producto.setTipo_empq_produc(rs.getString(7));
                producto.setNom_ctg(rs.getString(8));
                list_produc.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_produc;
    }

    @Override
    public List<producto> obtenerProductosPorMarcaYCategoria(String marca_produc, String nom_ctg) {
        List<producto> list_produc = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerProductosPorMarcaYCategoria(?, ?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, marca_produc);
            cs.setString(2, nom_ctg);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                producto producto = new producto();
                producto.setId_produc(rs.getString(1));
                producto.setNom_produc(rs.getString(2));
                producto.setMarca_produc(rs.getString(3));
                producto.setPrecio_empaq_produc(rs.getDouble(4));
                producto.setCant_x_empaq_produc(rs.getInt(5));
                producto.setId_ctg(rs.getString(6));
                producto.setTipo_empq_produc(rs.getString(7));
                producto.setNom_ctg(rs.getString(8));
                list_produc.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_produc;
    }
    
    @Override
    public List<empleado> obtenerTodosLosEmpleadosDatos() {
        List<empleado> list_emp = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerTodosLosEmpleadosDatos()}";
            CallableStatement cs = cn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                empleado emp = new empleado();
                contacto datos_contacto_prov = new contacto();
                ubigeo datos_ubigeo_prov = new ubigeo();
                emp.setId_emp(rs.getString(1));
                emp.setNom_pat_emp(rs.getString(2));
                emp.setNom_mat_emp(rs.getString(3));
                emp.setApe_pat_emp(rs.getString(4));
                emp.setApe_mat_emp(rs.getString(5));
                
                datos_contacto_prov.setId_contac(rs.getString(6));
                
                emp.setCargo_emp(rs.getString(7));
                
                datos_ubigeo_prov.setId_ubigeo(rs.getString(8));
                
                emp.setFech_nac_emp(rs.getString(9));
                
                datos_contacto_prov.setTipo_contac(rs.getString(10));
                datos_contacto_prov.setTelef_contac(rs.getString(11));
                datos_contacto_prov.setEmail_contac(rs.getString(12));
                emp.setDatos_contacto_emp(datos_contacto_prov);
                
                datos_ubigeo_prov.setDistrito_ubi(rs.getString(13));
                datos_ubigeo_prov.setProvincia_ubi(rs.getString(14));
                datos_ubigeo_prov.setCalle_avend_ubi(rs.getString(15));
                datos_ubigeo_prov.setNum_calle_ubi(rs.getInt(16));
                datos_ubigeo_prov.setReferencia_ubi(rs.getString(17));
                emp.setDatos_ubigeo_emp(datos_ubigeo_prov);
                list_emp.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_emp;
    }
    
    @Override
    public List<proovedor> obtenerTodosLosProveedoresDatos() {
        List<proovedor> list_prov = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerTodosLosProveedoresDatos()}";
            CallableStatement cs = cn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                proovedor prov = new proovedor();
                prov.setId_prov(rs.getString(1));
                prov.setNom_prov(rs.getString(2));
                prov.setDescd_prov(rs.getString(3));

                // Initialize datos_ubigeo_prov
                ubigeo datos_ubigeo_prov = new ubigeo();
                datos_ubigeo_prov.setId_ubigeo(rs.getString(4));
                datos_ubigeo_prov.setDistrito_ubi(rs.getString(5));
                datos_ubigeo_prov.setProvincia_ubi(rs.getString(6));
                datos_ubigeo_prov.setCalle_avend_ubi(rs.getString(7));

                // Handle 'NUM_CALLE_UBI' as an integer
                datos_ubigeo_prov.setNum_calle_ubi(rs.getInt(8));

                datos_ubigeo_prov.setReferencia_ubi(rs.getString(9));
                prov.setDatos_ubigeo_prov(datos_ubigeo_prov);

                // Initialize datos_contacto_prov
                contacto datos_contacto_prov = new contacto();
                datos_contacto_prov.setId_contac(rs.getString(10));
                datos_contacto_prov.setTipo_contac(rs.getString(11));
                datos_contacto_prov.setTelef_contac(rs.getString(12));
                datos_contacto_prov.setEmail_contac(rs.getString(13));
                prov.setDatos_contacto_prov(datos_contacto_prov);

                list_prov.add(prov);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_prov;
    }
    
    @Override
    public List<pedido> obtenerDatosPedidosParaLista() {
        List<pedido> list_pedi = new ArrayList();
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerDatosPedidos()}";
            CallableStatement cs = cn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                pedido pedi = new pedido();
                pedi.setId_pedi(rs.getString(1));
                pedi.setFech_pedi(rs.getString(2));
                pedi.setHora_pedi(rs.getString(3));
                pedi.setNom_prov_pedi(rs.getString(4));
                pedi.setNom_emp_pedi(rs.getString(5));
                pedi.setEstado_pedi(rs.getString(6));
                pedi.setTotal_precio_pedi(rs.getDouble(7));
                list_pedi.add(pedi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_pedi;
    }
    
    @Override
    public List<pedido> listPedido(String id_pedi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<detalle_pedido> listDetallePedido(String id_pedi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /*-----BUSQUEDAS-----*/
    @Override
    public List<categoria> obtenerNombresCategorias() {
        List<categoria> list_ctg = new ArrayList();
        Connection connection = MySQLConexion.getConexion();
        String sql = "{CALL obtenerNombresCategorias()}";
        
        try {
            CallableStatement statement = connection.prepareCall(sql);
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                categoria categoria = new categoria();
                categoria.setNom_ctg(resultSet.getString(1));
                list_ctg.add(categoria);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_ctg;
    }
    
    @Override
    public String obtenerUltimoIdEmpleado() {
        Connection cn = MySQLConexion.getConexion();
        String ultimoIdEmp = null;

        try {
            // Realizar la consulta SQL para obtener el último id_emp
            String sql = "SELECT MAX(id_emp) FROM empleado";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String maxId = rs.getString(1);

                if (maxId != null) {
                    // Extraer los últimos dos dígitos
                    int num = Integer.parseInt(maxId.substring(3));

                    // Incrementar en 1 y formatear como cadena con dos dígitos
                    String nuevoNum = String.format("%02d", num + 1);

                    // Formar el nuevo id_emp
                    ultimoIdEmp = "EMP" + nuevoNum;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return ultimoIdEmp;
    }
    
    @Override
    public empleado obtenerDatosUnEmpleado(String id_emp) {
        empleado emp = null;
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerDatosUnEmpleado(?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, id_emp);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                emp = new empleado();
                contacto datos_contacto_prov = new contacto();
                ubigeo datos_ubigeo_prov = new ubigeo();
                emp.setId_emp(rs.getString(1));
                emp.setNom_pat_emp(rs.getString(2));
                emp.setNom_mat_emp(rs.getString(3));
                emp.setApe_pat_emp(rs.getString(4));
                emp.setApe_mat_emp(rs.getString(5));
                
                datos_contacto_prov.setId_contac(rs.getString(6));
                
                emp.setCargo_emp(rs.getString(7));
                
                datos_ubigeo_prov.setId_ubigeo(rs.getString(8));
                
                emp.setFech_nac_emp(rs.getString(9));
                emp.setPassword_emp(rs.getString(10));
                
                datos_contacto_prov.setTipo_contac(rs.getString(11));
                datos_contacto_prov.setTelef_contac(rs.getString(12));
                datos_contacto_prov.setEmail_contac(rs.getString(13));
                emp.setDatos_contacto_emp(datos_contacto_prov);
                
                datos_ubigeo_prov.setDistrito_ubi(rs.getString(14));
                datos_ubigeo_prov.setProvincia_ubi(rs.getString(15));
                datos_ubigeo_prov.setCalle_avend_ubi(rs.getString(16));
                datos_ubigeo_prov.setNum_calle_ubi(rs.getInt(17));
                datos_ubigeo_prov.setReferencia_ubi(rs.getString(18));
                emp.setDatos_ubigeo_emp(datos_ubigeo_prov);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return emp;
    }
    
    @Override
    public proovedor obtenerDatosProveedor(String id_prov) {
        proovedor prov = null;
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerDatosProveedor(?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, id_prov);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                prov = new proovedor();
                prov.setId_prov(rs.getString(1));
                prov.setNom_prov(rs.getString(2));
                prov.setDescd_prov(rs.getString(3));

                // Initialize datos_ubigeo_prov
                ubigeo datos_ubigeo_prov = new ubigeo();
                datos_ubigeo_prov.setId_ubigeo(rs.getString(4));
                datos_ubigeo_prov.setDistrito_ubi(rs.getString(5));
                datos_ubigeo_prov.setProvincia_ubi(rs.getString(6));
                datos_ubigeo_prov.setCalle_avend_ubi(rs.getString(7));

                // Handle 'NUM_CALLE_UBI' as an integer
                datos_ubigeo_prov.setNum_calle_ubi(rs.getInt(8));

                datos_ubigeo_prov.setReferencia_ubi(rs.getString(9));
                prov.setDatos_ubigeo_prov(datos_ubigeo_prov);

                // Initialize datos_contacto_prov
                contacto datos_contacto_prov = new contacto();
                datos_contacto_prov.setId_contac(rs.getString(10));
                datos_contacto_prov.setTipo_contac(rs.getString(11));
                datos_contacto_prov.setTelef_contac(rs.getString(12));
                datos_contacto_prov.setEmail_contac(rs.getString(13));
                prov.setDatos_contacto_prov(datos_contacto_prov);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return prov;
    }
    
    @Override
    public String generarNuevoIDPedido() {
        String id_pedi = null;
        Connection cn = MySQLConexion.getConexion();
        
        String sql = "{CALL generarNuevoIDPedido()}";
        
        try {
            CallableStatement cs = cn.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                id_pedi = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id_pedi;
    }
    
    @Override
    public producto obtenerDatosProducto(String id_produc) {
        producto produc = null;
        Connection cn = MySQLConexion.getConexion();
        
        try {
            String sql = "{CALL obtenerDatosProducto(?)}";
            CallableStatement cs = cn.prepareCall(sql);
            cs.setString(1, id_produc);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                produc = new producto();
                produc.setNom_produc(rs.getString(1));
                produc.setMarca_produc(rs.getString(2));
                produc.setPrecio_empaq_produc(rs.getDouble(3));
                produc.setCant_x_empaq_produc(rs.getInt(4));
                produc.setTipo_empq_produc(rs.getString(5));
                produc.setNom_ctg(rs.getString(6));
                produc.setId_ctg(rs.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return produc;
    }
    
    /*-----LOGIN-----*/
    @Override
    public empleado login_emp(String id_emp, String password_emp) {
        empleado emp = null;
        Connection connection = MySQLConexion.getConexion();
        
        String sql = "{CALL sp_login_emp(?, ?)}";
        
        try {
            CallableStatement statement = connection.prepareCall(sql);
            statement.setString(1, id_emp);
            statement.setString(2, password_emp);
            
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                emp = new empleado();
                
                emp.setId_emp(resultSet.getString(1));
                emp.setNom_pat_emp(resultSet.getString(2));
                emp.setNom_mat_emp(resultSet.getString(3));
                emp.setApe_pat_emp(resultSet.getString(4));
                emp.setApe_mat_emp(resultSet.getString(5));
                
                contacto datos_contacto_prov = new contacto();
                datos_contacto_prov.setId_contac(resultSet.getString(6));
                emp.setDatos_contacto_emp(datos_contacto_prov);
                
                emp.setCargo_emp(resultSet.getString(7));
                
                ubigeo datos_ubigeo_prov = new ubigeo();
                datos_ubigeo_prov.setId_ubigeo(resultSet.getString(8));
                emp.setDatos_ubigeo_emp(datos_ubigeo_prov);
                
                emp.setFech_nac_emp(resultSet.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return emp;
    }

    @Override
    public String ObtenerCategoriaID(String nom_ctg) {
        String id_ctg = "";
        Connection cn = MySQLConexion.getConexion();
        String sql = "{CALL ObtenerCategoriaID (?)}";
        try{
            CallableStatement st = cn.prepareCall(sql);
            st.setString(1,nom_ctg);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                id_ctg = rs.getString(1);
            }
             
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return id_ctg;
    }

}
