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
    public void adiContacto(contacto contac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiPedido(pedido pedid, List<detalle_pedido> lista_productos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiGuia(gui_entrega guia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiProducto(producto produc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiProovedor(proovedor prov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void adiUbigeo(ubigeo ubigeo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            
            if (true) {
                emp = new empleado();
                
                emp.setId_emp(resultSet.getString(1));
                emp.setNom_pat_emp(resultSet.getString(2));
                emp.setNom_mat_emp(resultSet.getString(3));
                emp.setApe_pat_emp(resultSet.getString(4));
                emp.setApe_mat_emp(resultSet.getString(5));
                emp.getDatos_contacto_emp().setId_contac(resultSet.getString(6));
                emp.setCargo_emp(resultSet.getString(7));
                emp.getDatos_ubigeo_emp().setId_ubigeo(resultSet.getString(8));
                emp.setFech_nac_emp(resultSet.getString(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return emp;
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
                emp.setId_emp(rs.getString(1));
                emp.setNom_pat_emp(rs.getString(2));
                emp.setNom_mat_emp(rs.getString(3));
                emp.setApe_pat_emp(rs.getString(4));
                emp.setApe_mat_emp(rs.getString(5));
                emp.getDatos_contacto_emp().setId_contac(sql);
                list_emp.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list_emp;
    }

    @Override
    public empleado obtenerDatosUnEmpleado(String id_emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
